package com.example.fileuploadpoc.controller;


import com.example.fileuploadpoc.service.AvatarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/avatar")
@RequiredArgsConstructor
@RestController
public class AvatarController {
    private AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }


    @PostMapping("/uploadImage")
    public void uploadImage(@RequestParam("file") MultipartFile file) {
        avatarService.uploadImage(file);
//        return ResponseEntity.status(HttpStatus.OK).build();
    }





}
