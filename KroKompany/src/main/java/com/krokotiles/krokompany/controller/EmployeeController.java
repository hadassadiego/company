package com.krokotiles.krokompany.controller;

import com.krokotiles.krokompany.dto.EmployeeRecordDto;

import com.krokotiles.krokompany.model.EmployeeModel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import lombok.CustomLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.krokotiles.krokompany.service.EmployeeService;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getEmployeeList(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "role", required = false) String role) {
        List<EmployeeModel> employees;

        if (name != null && role != null) {
            employees = employeeService.findEmployeesByNameAndRole(name, role);
        } else if (name != null) {
            employees = employeeService.findEmployeesByName(name);
        } else if (role != null) {
            employees = employeeService.findEmployeesByRole(role);
        } else {
            employees = employeeService.getEmployeeList();
        }

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }


    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "role", required = false) String role) {
        Long countEmployees;

        if (name != null && role != null) {
            countEmployees = employeeService.getEmployeeCountByNameAndRole(name, role);
        } else if (name != null) {
            countEmployees = employeeService.getEmployeeCountByName(name);
        } else if (role != null) {
            countEmployees = employeeService.getEmployeeCountByRole(role);
        } else {
            countEmployees = employeeService.getEmployeeCount();
        }
        return ResponseEntity.status(HttpStatus.OK).body(countEmployees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(
            @PathVariable Long id,
            @RequestBody @Valid EmployeeRecordDto updatedEmployeeDto) {

        var existingEmployee = employeeService.findById(id);

        if (existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(updatedEmployeeDto, existingEmployee);

        var updatedEmployee = employeeService.save(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        if (employeeService.existsById(id)) {
            employeeService.delete(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<EmployeeModel> saveEmployee(@RequestBody @Valid EmployeeRecordDto employeeRecordDto) {
        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeRecordDto, employeeModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.save(employeeModel));
    }

}
