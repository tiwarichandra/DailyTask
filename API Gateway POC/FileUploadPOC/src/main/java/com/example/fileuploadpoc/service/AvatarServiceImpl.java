package com.example.fileuploadpoc.service;


import com.example.fileuploadpoc.entity.Avatar;
import com.example.fileuploadpoc.repo.AvatarRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;

@Service
@RequiredArgsConstructor
public class AvatarServiceImpl implements AvatarService {

    private AvatarRepo avatarRepo;

    public AvatarServiceImpl(AvatarRepo avatarRepo) {
        this.avatarRepo = avatarRepo;
    }

    @Override
    public void uploadImage(MultipartFile file) {
        Avatar avatar = new Avatar();

        avatar.setName(file.getOriginalFilename());
        avatar.setType(file.getContentType());
        try {
            avatar.setImageData(compressImage(file.getBytes()));
            avatarRepo.save(avatar);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private byte[] compressImage(byte[] fileData) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(fileData);
        deflater.finish();


        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(fileData.length);

        byte[] bytes = new byte[4*1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(bytes);
            byteArrayOutputStream.write(bytes, 0, size);
        }

        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return byteArrayOutputStream.toByteArray();
    }

}
