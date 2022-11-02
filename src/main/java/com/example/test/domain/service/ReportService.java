package com.example.test.domain.service;

import com.example.test.application.request.DeleteReportRequest;
import com.example.test.application.request.ReportRequest;
import com.example.test.domain.model.entity.Report;
import com.example.test.domain.model.repository.ImageRepository;
import com.example.test.domain.model.repository.ReportRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {

    private final ReportRepository reportRepository;

    private final ImageService imageService;

    private final ImageRepository imageRepository;

    public void submitReport(String memberId, ReportRequest reportRequest) {
        reportRepository.save(new Report(memberId, reportRequest));
        uploadImages(memberId, reportRequest);
    }

    private void uploadImages(String memberId, ReportRequest reportRequest) {
        if (reportRequest.getImage() != null) {
            imageService.uploadReportImage(memberId, reportRequest.getMetaSeq(), reportRequest.getImage());
        }
    }

    public void deleteReport(DeleteReportRequest request) {
        imageRepository.deleteByReportNo(request.getReportNo());
        reportRepository.deleteById(request.getReportNo());
    }
}
