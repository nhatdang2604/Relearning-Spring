package com.example.template.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer salary;
}
