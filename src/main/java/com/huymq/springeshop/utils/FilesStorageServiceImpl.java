package com.huymq.springeshop.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  private String BucketName = MyConstants.MY_BUCKET_STRING;

  private final Path root = Paths.get("uploads");

  @Autowired
  private FileStoreS3 s3;

  
  @Override
  public void init() {
    try {
      if (!Files.exists(this.root)){
        Files.createDirectory(root);
      }

      } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
      }
    }
  @Override
  public String save(MultipartFile file, String path) {
    Path uploadPath = Paths.get(this.root.toString()+path);
      
    String fileNameSave = null;
    try {
      if (!Files.exists(uploadPath)) {
        Files.createDirectories(uploadPath);
      }
      String extFile= null;
      Optional<String> optional = getExtensionByStringHandling(file.getOriginalFilename());
      if(optional.isPresent()){
        extFile= optional.get();
      }else{
        extFile = "";
      }
      fileNameSave = UUID.randomUUID().toString()+"."+extFile;
      Files.copy(file.getInputStream(), uploadPath.resolve(fileNameSave));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
    return fileNameSave;
  }
  @Override
  public Resource load(String filename) {
    try {
      Path file = root.resolve(filename);
      Resource resource = new UrlResource(file.toUri());
      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
     throw new RuntimeException("Error: " + e.getMessage());
    }
  }
  @Override
  public void deleteAll() {
    FileSystemUtils.deleteRecursively(root.toFile());
  }

  @Override
  public Stream<Path> loadAll() {
    try {
      return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

  public Optional<String> getExtensionByStringHandling(String filename) {
    return Optional.ofNullable(filename)
      .filter(f -> f.contains("."))
      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
}
  @Override
  public String saveS3(MultipartFile file, String path) {
    //check if the file is empty
    if (file.isEmpty()) {
      throw new IllegalStateException("Cannot upload empty file");
  }
  //Check if the file is an image
  if (!Arrays.asList(ContentType.IMAGE_PNG.getMimeType(),
  ContentType.IMAGE_BMP.getMimeType(),
  ContentType.IMAGE_GIF.getMimeType(),
  ContentType.IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
      throw new IllegalStateException("FIle uploaded is not an image");
  }
  //get file metadata
  Map<String, String> metadata = new HashMap<>();
  metadata.put("Content-Type", file.getContentType());
  metadata.put("Content-Length", String.valueOf(file.getSize()));
  //Save Image in S3 and then save Todo in the database
  String pathSave = String.format("%s%s", BucketName, path);
  String fileNameSave = null;
  String extFile= null;
      Optional<String> optional = getExtensionByStringHandling(file.getOriginalFilename());
      if(optional.isPresent()){
        extFile= optional.get();
      }else{
        extFile = "";
      }
      fileNameSave = UUID.randomUUID().toString()+"."+extFile;
 
  try {
    s3.upload(pathSave, fileNameSave, Optional.of(metadata), file.getInputStream());
  } catch (IOException e) {
      throw new IllegalStateException("Failed to upload file", e);
  }
    return fileNameSave;
  }
    
}
