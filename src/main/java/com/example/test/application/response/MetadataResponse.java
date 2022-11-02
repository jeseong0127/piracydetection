package com.example.test.application.response;

import com.example.test.domain.model.dto.GetMetadataDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MetadataResponse {
    private final List<GetMetadataDto> metadata;
}
