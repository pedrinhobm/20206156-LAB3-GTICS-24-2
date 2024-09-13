package com.example.Tarea2_20206156.model.bean;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private Job job;
    private Department department;
    private Double salary;
    private String phone_number;
    private int enabled;

}
