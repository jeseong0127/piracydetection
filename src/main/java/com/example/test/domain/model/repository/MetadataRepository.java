package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Metadata;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Integer> {
    Optional<Metadata> findByModelNameIsNotNullAndPathImgContainingAndReserveIdAndRegIdNullAndImgCountLessThan(String registrationNumber, String defaultReserveId, int i);

    Optional<Metadata> findByModelNameIsNotNullAndPathImgGoodsContainingAndReserveIdAndRegIdNullAndImgCountLessThan(String registrationNumber, String defaultReserveId, int i);
}
