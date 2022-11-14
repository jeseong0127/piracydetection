package com.example.test.domain.service;

import com.example.test.domain.model.dto.GetMainMetadataDto;
import com.example.test.domain.model.repository.MainRepository;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;

    public List<GetMainMetadataDto> getMainMetadata() {
        return mainRepository.findAllByOrderByRegDateDesc().stream()
                .map(GetMainMetadataDto::new)
                .collect(Collectors.toList());
    }
}
