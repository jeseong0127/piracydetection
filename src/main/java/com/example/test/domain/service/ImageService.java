package com.example.test.domain.service;

import com.example.test.domain.exception.image.CannotViewImageException;
import com.example.test.domain.exception.image.ImageNotFoundException;
import com.example.test.domain.model.entity.Image;
import com.example.test.domain.model.repository.ImageRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    @Value("${image.upload-path}")
    private String imagePath;

    private final ImageRepository imageRepository;

    public byte[] viewImage(int imageId) {
        Image image = imageRepository.findById(imageId).orElseThrow(() -> new ImageNotFoundException(imageId));
        return this.viewImage(imagePath + File.separator + image.getImagePath());
    }

    private byte[] viewImage(String fileName) {
        try (
                FileInputStream inputStream = new FileInputStream(fileName);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ) {
            byte[] buffer = new byte[8192];
            int length;
            while ((length = inputStream.read(buffer)) != -1)
                outputStream.write(buffer, 0, length);
            return outputStream.toByteArray();
        } catch (IOException e) {
            throw new CannotViewImageException(fileName);
        }
    }
}
