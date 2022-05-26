package com.example.demo3trangthaijava.service;

import com.example.demo3trangthaijava.model.dto.UserDto;
import com.example.demo3trangthaijava.model.entity.User;
import com.example.demo3trangthaijava.model.in.UserIn;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
     List<UserDto>getAll();
     User create(UserIn userIn);
     User update(Integer id, UserIn userIn);
     void delete(Integer id);
}
