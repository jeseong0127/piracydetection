package com.example.test.domain.service;

import com.example.test.domain.model.dto.GetMetadataDto;
import com.example.test.domain.model.repository.MetadataRepository;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MetadataService {
    private final MetadataRepository metadataRepository;

    @Transactional(readOnly = true)
    public List<GetMetadataDto> getImageSearchMetadata(List<String> data) {
        List<GetMetadataDto> getMetadataDtos = new ArrayList<>();

        for (String registrationNumber : data) {
            metadataRepository.findAllByModelNameIsNotNull()
                    .forEach(metadata -> {
                        if (metadata.getPathImgGoods() != null && metadata.getPathImgGoods().contains(registrationNumber)) {
                            getMetadataDtos.add(new GetMetadataDto(metadata));
                        } else if (metadata.getPathImg() != null && metadata.getPathImg().contains(registrationNumber)) {
                            getMetadataDtos.add(new GetMetadataDto(metadata));
                        }
                    });
        }
        return getMetadataDtos;
    }
}
