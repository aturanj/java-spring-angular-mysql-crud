package io.aturanj.employee.manager.controller;

import io.aturanj.employee.manager.model.Employee;
import io.aturanj.employee.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.findAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employeeList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee employeeCreated = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeCreated);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee employeeUpdated = employeeService.updateEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employeeUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeByID(id);
        return ResponseEntity.ok().build();
    }
}
