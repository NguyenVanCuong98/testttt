package com.example.demo3trangthaijava.controller;

import com.example.demo3trangthaijava.model.dto.StatusDto;
import com.example.demo3trangthaijava.model.entity.Status;
import com.example.demo3trangthaijava.model.in.StatusIn;
import com.example.demo3trangthaijava.repository.StatusRepository;
import com.example.demo3trangthaijava.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<List<StatusDto>>getAll(){
        return new ResponseEntity<>(statusService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Status create(@RequestBody StatusIn statusIn){
        return statusService.create(statusIn);
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Status update(@PathVariable Integer id , @RequestBody StatusIn statusIn){
        return statusService.update(id,statusIn);
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id, @RequestBody StatusIn statusIn){
         statusService.delete(id, statusIn);
    }
}
