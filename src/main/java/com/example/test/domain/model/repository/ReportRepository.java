package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Report;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query("select r from Report r join fetch r.metadata where r.regId = :memberId")
    List<Report> findAllByRegId(@Param("memberId") String memberId);

    int countByRegId(String memberId);

    int countByRegIdAndStatus(String memberId, int i);

    int countByRegIdAndRegDateBetween(String memberId, LocalDateTime start, LocalDateTime end);
}
