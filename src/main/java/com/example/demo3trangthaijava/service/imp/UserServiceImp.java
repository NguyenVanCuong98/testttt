package com.example.demo3trangthaijava.service.imp;

import com.example.demo3trangthaijava.model.dto.UserDto;
import com.example.demo3trangthaijava.model.entity.Status;
import com.example.demo3trangthaijava.model.entity.User;
import com.example.demo3trangthaijava.model.in.UserIn;
import com.example.demo3trangthaijava.repository.StatusRepository;
import com.example.demo3trangthaijava.repository.UserRepository;
import com.example.demo3trangthaijava.service.UserService;
import com.example.demo3trangthaijava.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImp implements UserService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    public List<UserDto> getAll() {
        List<User> list = userRepository.findById_statusOrderById_statusAsc();
        List<UserDto> dtoList = list.stream().map(it->userMapper.map(it)).collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public User create(UserIn userIn) {
        User user = userMapper.map(userIn);
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, UserIn userIn) {
        User user = userRepository.getById(id);
        userIn.setId_status(id);
        Status status = user.getStatus();

        if (userIn.getId() != null){
            status = statusRepository.findAllById(userIn.getId());
        }
        if (userIn.getStatus() != null){
            status = userIn.getStatus();
        }
        user = userMapper.map(userIn);
        user.setStatus(status);
        User user1 = user;
        return userRepository.save(user1);
    }

    @Override
    public void delete(Integer id) {
        User user = userRepository.getById(id);
        user.setStatus(null);
        userRepository.save(user);
        userRepository.deleteById(id);
    }
}
