package com.example.fileuploadpoc.service;

import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {
    void uploadImage(MultipartFile file);
}
