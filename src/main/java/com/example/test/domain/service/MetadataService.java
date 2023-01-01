package com.example.test.domain.service;

import com.example.test.domain.model.dto.GetMetadataDto;
import com.example.test.domain.model.entity.Metadata;
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
    public List<GetMetadataDto> getImageSearchMetadata(List<String> images) {
        List<GetMetadataDto> getMetadataDtos = new ArrayList<>();

        List<Metadata> metadataList = metadataRepository.findAllByModelNameIsNotNull();
        for (String pathImage : images) {
            metadataList.forEach(metadata -> {
                        if (metadata.getPathImgGoods() != null && metadata.getPathImgGoods().contains(pathImage)) {
                            getMetadataDtos.add(new GetMetadataDto(metadata));
                        } else if (metadata.getPathImg() != null && metadata.getPathImg().contains(pathImage)) {
                            getMetadataDtos.add(new GetMetadataDto(metadata));
                        }
                    }
            );
        }

        // refactoring

//        List<Metadata> metadataList = metadataRepository.findAllByModelNameIsNotNull();
//        for (String pathImage : images) {
//            metadataList.stream()
//                    .filter(metadata -> metadata.getPathImgGoods() != null && metadata.getPathImgGoods().contains(pathImage))
//                    .findAny()
//                    .ifPresent(metadata -> getMetadataDtos.add(new GetMetadataDto(metadata)));
//
//            metadataList.stream()
//                    .filter(metadata -> metadata.getPathImg() != null && metadata.getPathImg().contains(pathImage))
//                    .findAny()
//                    .ifPresent(metadata -> getMetadataDtos.add(new GetMetadataDto(metadata)));
//        }

        return getMetadataDtos;
    }
}
