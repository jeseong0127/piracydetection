package com.example.test.domain.service;

import com.example.test.domain.model.dto.GetMainMetadataDto;
import com.example.test.domain.model.repository.MainRepository;

import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final MainRepository mainRepository;

    @Transactional(readOnly = true)
    public List<GetMainMetadataDto> getMainMetadata() {
        return mainRepository.findAllByOrderByRegDateDesc().stream()
                .map(GetMainMetadataDto::new)
                .collect(Collectors.toList());
    }
}
