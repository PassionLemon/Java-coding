package com.example.reflection.entity;

import java.time.LocalDate;

/**
 * @Author: lyh
 * @Date: 2021/06/24  15:22
 * @Description:
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    public Employee(){}

    public Employee(String name, Double salary, LocalDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }
}
