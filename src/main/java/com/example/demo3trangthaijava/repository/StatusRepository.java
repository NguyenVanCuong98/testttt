package com.example.demo3trangthaijava.repository;

import com.example.demo3trangthaijava.model.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    Status findAllById(Integer id);
}
