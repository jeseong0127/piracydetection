package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Image;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    void deleteByReportNo(int reportNo);

    Optional<Image> findByReportNo(int reportNo);
}
