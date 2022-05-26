package com.example.demo3trangthaijava.model.dto;

import com.example.demo3trangthaijava.model.entity.User;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class StatusDto {
    private Integer id;
    private String name_status;
    private List<User> users;

}
