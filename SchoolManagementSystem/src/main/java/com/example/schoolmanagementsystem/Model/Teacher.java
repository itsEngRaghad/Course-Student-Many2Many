package com.example.schoolmanagementsystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@Entity
@Setter
@Getter
@NoArgsConstructor

public class Teacher {

//Teacher Class :
//id , name , age , email , salary ( Add all required validation )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String email;
    private Integer salary;

    //define relations+Make cascade conditions
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
    @PrimaryKeyJoinColumn
    private Address address;

    //define one to many relation with courses
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course>courseSet;




}
