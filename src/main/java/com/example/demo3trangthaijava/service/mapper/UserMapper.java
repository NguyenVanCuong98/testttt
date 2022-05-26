package com.example.demo3trangthaijava.service.mapper;

import com.example.demo3trangthaijava.model.dto.UserDto;
import com.example.demo3trangthaijava.model.entity.User;
import com.example.demo3trangthaijava.model.in.UserIn;

public class UserMapper {
    public static UserDto map(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(userDto.getUsername());
        userDto.setId_status(userDto.getId_status());
        return userDto;
    }
    public static User map(UserIn userIn){
        User user = new User();
        if(userIn.getId()==null){
            user.setId(userIn.getId());
        }
        user.setUsername(userIn.getUsername());
        user.setId_status(userIn.getId_status());
        if (userIn.getStatus()!= null){
            user.setStatus(userIn.getStatus());
        }
        return user;
    }
}
