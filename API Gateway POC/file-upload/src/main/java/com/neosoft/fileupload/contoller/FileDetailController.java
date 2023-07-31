package com.neosoft.fileupload.contoller;

import com.neosoft.fileupload.entity.FileDetails;
import com.neosoft.fileupload.service.FileDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file-detail")
public class FileDetailController {


    private final FileDetailService fileDetailService;

    @PostMapping("/file")
    public void uploadImage(@RequestParam("file") MultipartFile file) {
            fileDetailService.uploadImage(file);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") Long id) {

        FileDetails fileDetails = fileDetailService.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileDetails.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "image: fileName=test.png\""
                                +"\"")
                .body(new ByteArrayResource(fileDetails.getFile()));

    }

}
