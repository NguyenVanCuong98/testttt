package com.example.demo3trangthaijava.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "status")

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "name_status")
    private String name_status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "status")
    @Column(name = "id_status")
    @JsonIgnore
    private List<User> users;

    public void setUser(List<User> users){
        this.users=users;
        for (User user:users) {
            user.setStatus(this);
        }
    }


}
