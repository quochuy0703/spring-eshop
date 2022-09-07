package com.huymq.springeshop.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  private final Path root = Paths.get("uploads");
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
    
}
