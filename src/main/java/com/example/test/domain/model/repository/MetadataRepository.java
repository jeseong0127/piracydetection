package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Metadata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Integer> {
    @Query("select m from Metadata m where m.modelName is not null group by m.modelName, m.registrationNumber")
    List<Metadata> findAllByModelNameIsNotNull();
}
