package com.example.employeeappbackend.mapper;

import com.example.employeeappbackend.model.Employee;
import com.example.employeeappbackend.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.*;
import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

public interface EmployeeMapper {

    Employee toEntity(EmployeeDTO employeeDTO);
    EmployeeDTO toDto(Employee employee);
    Employee updateEntityFromDto(EmployeeDTO employeeDTO, Employee employee);

    List<EmployeeDTO> toDto(List<Employee> employees);
    List<Employee> toEntity(List<EmployeeDTO> employeeDTO);


}
