package com.neosoft.fileupload.service;

import com.neosoft.fileupload.entity.FileDetails;
import org.springframework.web.multipart.MultipartFile;

public interface FileDetailService {

    void uploadImage(MultipartFile file);

    FileDetails downloadFile(Long id);
}
