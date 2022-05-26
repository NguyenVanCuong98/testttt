package com.example.demo3trangthaijava.model.in;

import com.example.demo3trangthaijava.model.entity.Status;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserIn {
    private Integer id;
    private String username;
    private Integer id_status;
    private Status status;
}
