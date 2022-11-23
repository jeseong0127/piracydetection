package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Metadata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Integer> {
    List<Metadata> findAllByModelNameIsNotNull();
}
