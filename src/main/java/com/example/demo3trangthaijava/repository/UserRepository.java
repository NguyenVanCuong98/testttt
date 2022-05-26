package com.example.demo3trangthaijava.repository;

import com.example.demo3trangthaijava.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     @Query(value = "select * from users order by id_status asc ",nativeQuery = true)
     List<User> findById_statusOrderById_statusAsc();
}
