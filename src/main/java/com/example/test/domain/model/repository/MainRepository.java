package com.example.test.domain.model.repository;

import com.example.test.domain.model.entity.Main;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Main, Integer> {
    List<Main> findAllByOrderByRegDateDesc();
}
