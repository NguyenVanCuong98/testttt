package com.example.demo3trangthaijava.service.mapper;

import com.example.demo3trangthaijava.model.dto.StatusDto;
import com.example.demo3trangthaijava.model.entity.Status;
import com.example.demo3trangthaijava.model.in.StatusIn;


public class StatusMapper {
    public static StatusDto map(Status status){
        StatusDto statusDto = new StatusDto();
        statusDto.setId(status.getId());
        statusDto.setName_status(status.getName_status());
        return statusDto;
    }
    public static Status map(StatusIn statusIn){
        Status status = new Status();
        if(statusIn.getId()==null){
            status.setId(statusIn.getId());
        }
        status.setName_status(statusIn.getName_status());
        if (statusIn.getUsers()!= null){
            status.setUsers(statusIn.getUsers());
        }
        return status;
    }
}
