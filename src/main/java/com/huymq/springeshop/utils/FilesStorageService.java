package com.huymq.springeshop.utils;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
    public void init();
    public String save(MultipartFile file, String path);
    public String saveS3(MultipartFile file, String path);
    public void removeObjectS3(String path, String filename);
    public void removeMutiObjectS3(String path, List<String> fileNames);
    public Resource load(String filename);
    public void deleteAll();
    public Stream<Path> loadAll();
}
