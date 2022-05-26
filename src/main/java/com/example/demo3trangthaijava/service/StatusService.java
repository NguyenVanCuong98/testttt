package com.example.demo3trangthaijava.service;

import com.example.demo3trangthaijava.model.dto.StatusDto;
import com.example.demo3trangthaijava.model.entity.Status;
import com.example.demo3trangthaijava.model.in.StatusIn;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StatusService {
    List<StatusDto> getAll();
    Status create(StatusIn statusIn);
    Status update(Integer id, StatusIn statusIn);
    void delete(Integer id, StatusIn statusIn);
}
