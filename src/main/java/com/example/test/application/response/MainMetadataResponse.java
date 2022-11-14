package com.example.test.application.response;

import com.example.test.domain.model.dto.GetMainMetadataDto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MainMetadataResponse {
    private List<GetMainMetadataDto> list;
}
