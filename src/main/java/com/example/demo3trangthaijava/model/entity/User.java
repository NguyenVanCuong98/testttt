package com.example.demo3trangthaijava.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "id_status")
    private Integer id_status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonIgnore
    private Status status;

}
