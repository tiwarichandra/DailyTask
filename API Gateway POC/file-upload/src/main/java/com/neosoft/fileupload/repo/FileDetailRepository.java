package com.neosoft.fileupload.repo;

import com.neosoft.fileupload.entity.FileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface FileDetailRepository extends JpaRepository<FileDetails, Long> {


}
