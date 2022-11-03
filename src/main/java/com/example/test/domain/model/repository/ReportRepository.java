package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query("select r from Report r join fetch r.metadata")
    List<Report> findAllByRegId(String memberId);
}
