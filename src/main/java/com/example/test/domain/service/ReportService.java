package com.example.test.domain.service;

import com.example.test.application.request.ReportRequest;
import com.example.test.domain.exception.metadata.MetadataNotFoundException;
import com.example.test.domain.model.entity.Metadata;
import com.example.test.domain.model.entity.Report;
import com.example.test.domain.model.repository.ImageRepository;
import com.example.test.domain.model.repository.MetadataRepository;
import com.example.test.domain.model.repository.ReportRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReportService {

    private final MetadataRepository metadataRepository;

    private final ReportRepository reportRepository;

    private final ImageService imageService;

    private final ImageRepository imageRepository;

    public void submitReport(String memberId, ReportRequest reportRequest) {
        Metadata metadata = metadataRepository.findById(reportRequest.getMetaSeq()).orElseThrow(() -> new MetadataNotFoundException(reportRequest.getMetaSeq()));
        Report report = reportRepository.save(new Report(memberId, reportRequest, metadata));
        uploadImages(memberId, report.getReportNo(), reportRequest);
    }

    private void uploadImages(String memberId, int reportNo, ReportRequest reportRequest) {
        if (reportRequest.getImage() != null) {
            imageService.uploadReportImage(memberId, reportNo, reportRequest.getImage());
        }
    }

    public void deleteReport(int reportNo) {
        imageRepository.deleteByReportNo(reportNo);
        reportRepository.deleteById(reportNo);
    }
}
