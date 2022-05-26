package com.example.demo3trangthaijava.model.in;

import com.example.demo3trangthaijava.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class StatusIn {
    private Integer id;
    private String name_status;
    private Boolean checkDelete;
    private List<User> users;
}
