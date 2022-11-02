package com.example.test.domain.service;

import com.example.test.domain.model.dto.GetMetadataDto;
import com.example.test.domain.model.repository.MetadataRepository;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MetadataService {
    private final MetadataRepository metadataRepository;

    String defaultReserveId = "N/A";

    public List<GetMetadataDto> getImageSearchMetadata(List<String> data) {
        List<GetMetadataDto> getMetadataDtos = new ArrayList<>();

        for (String RegistrationNumber : data) {
            metadataRepository.findByModelNameIsNotNullAndPathImgContainingAndReserveIdAndRegIdNullAndImgCountLessThan(RegistrationNumber, defaultReserveId, 62)
                    .ifPresent(metadata -> getMetadataDtos.add(new GetMetadataDto(metadata, "photo")));

            metadataRepository.findByModelNameIsNotNullAndPathImgGoodsContainingAndReserveIdAndRegIdNullAndImgCountLessThan(RegistrationNumber, defaultReserveId, 62)
                    .ifPresent(metadata -> getMetadataDtos.add(new GetMetadataDto(metadata, "drawing")));
        }
        return getMetadataDtos;
    }
}
