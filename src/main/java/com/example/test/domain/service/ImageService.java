package com.example.test.domain.service;

import com.example.test.domain.exception.image.CannotUploadImageException;
import com.example.test.domain.exception.image.CannotViewImageException;
import com.example.test.domain.exception.image.ImageNotFoundException;
import com.example.test.domain.model.entity.Image;
import com.example.test.domain.model.repository.ImageRepository;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSSSS");

    @Value("${image.upload-path}")
    private String imagePath;

    @Value("${image.search-path}")
    private String searchImagePath;

    private final ImageRepository imageRepository;

    public byte[] viewImage(int reportNo) {
        Image image = imageRepository.findByReportNo(reportNo).orElseThrow(() -> new ImageNotFoundException(reportNo));
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

    public void uploadReportImage(String memberId, int reportNo, MultipartFile image) {
        try {
            LocalDateTime now = LocalDateTime.now();
            String date = now.format(dateFormatter);
            String time = now.format(dateTimeFormatter);

            String fileType = "." + FilenameUtils.getExtension(image.getOriginalFilename());
            String fileSize = String.valueOf(image.getSize());
            String fileName = date + "/" + time + fileType;
            uploadImage(imagePath, image, fileName);
            imageRepository.save(new Image(memberId, reportNo, fileName.substring(fileName.lastIndexOf("/") + 1), fileName, fileSize, fileType));
        } catch (IOException e) {
            throw new CannotUploadImageException();
        }
    }

    private void uploadImage(String imagePath, MultipartFile file, String fileName) throws IOException {
        File directory = new File(imagePath + File.separator + fileName.substring(0, fileName.lastIndexOf("/")));
        File image = new File(imagePath + File.separator + fileName);

        FileUtils.forceMkdir(directory);
        file.transferTo(image);
    }

    public byte[] viewThumbnailImage(String imagePath) {
        return this.viewImage(this.searchImagePath + imagePath);
    }
}
