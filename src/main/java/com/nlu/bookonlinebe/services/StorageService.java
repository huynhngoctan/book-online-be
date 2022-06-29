package com.nlu.bookonlinebe.services;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    public String storageFile(MultipartFile file);
    public byte[] readFileContent(String fileName);
}
