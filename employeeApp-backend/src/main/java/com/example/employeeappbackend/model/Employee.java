package com.example.employeeappbackend.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "emailaddress")
    private String emailaddress;


    public Employee(String firstName, String lastName, String emailaddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailaddress = emailaddress;
    }




    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + emailaddress + '\'' +
                '}';
    }
}
