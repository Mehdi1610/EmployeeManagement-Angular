package com.example.employeeappbackend.Controller;


import com.example.employeeappbackend.mapper.EmployeeMapper;
import com.example.employeeappbackend.model.Employee;
import com.example.employeeappbackend.service.EmployeeService;
import com.example.employeeappbackend.dto.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class Controlleremployee {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        System.out.println("Get all employees : ");
        employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping("employee/{id}")
    public  ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long id) {
        System.out.println("Get employee by id : ");

        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @DeleteMapping("delete-employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable long id) {
        System.out.println("Deleting employee with id :  " + id);
        employeeService.deleteEmployeById(id);
        return ResponseEntity.ok("Deleted employee with id : " + id);
    }

    @PostMapping("employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println("Creating employee : " + employeeDTO);
        return ResponseEntity.ok(employeeService.createEmployee(employeeDTO));
    }

    @PatchMapping("update-employee/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) {
        System.out.println("Updating employee with id : " + id);
        return ResponseEntity.ok(employeeService.updateEmployeById(id,employeeDTO));
    }


}
