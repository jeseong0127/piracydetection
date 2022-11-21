package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.ReportLog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportLogRepository extends JpaRepository<ReportLog, Integer> {
    List<ReportLog> findAllByRegIdOrderByRegDateDesc(String memberId);
}
