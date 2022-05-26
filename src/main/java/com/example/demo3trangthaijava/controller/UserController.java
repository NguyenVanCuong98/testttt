package com.example.demo3trangthaijava.controller;

import com.example.demo3trangthaijava.model.dto.UserDto;
import com.example.demo3trangthaijava.model.entity.User;
import com.example.demo3trangthaijava.model.in.UserIn;
import com.example.demo3trangthaijava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<UserDto>>getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User create(@RequestBody UserIn userIn){
        return userService.create(userIn);
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public User create( @PathVariable Integer id,@RequestBody UserIn userIn){
        return userService.update(id,userIn);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void create( @PathVariable Integer id){
        userService.delete(id);
    }

}
