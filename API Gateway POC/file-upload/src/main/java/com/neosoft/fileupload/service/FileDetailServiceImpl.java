package com.neosoft.fileupload.service;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import com.neosoft.fileupload.entity.FileDetails;
import com.neosoft.fileupload.repo.FileDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class FileDetailServiceImpl implements FileDetailService {

    private final FileDetailRepository fileDetailRepository;


    @Override
    public void uploadImage(MultipartFile file) {
        try {
            FileDetails fileDetails = FileDetails.builder()
                    .type(file.getContentType())
                    .file(file.getBytes()).build();

            fileDetailRepository.save(fileDetails);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public FileDetails downloadFile(Long id) {
        FileDetails byName = fileDetailRepository.findById(id).orElse(FileDetails.builder().file(new byte[0]).build());

        return byName;
    }
}
