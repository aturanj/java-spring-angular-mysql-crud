package io.aturanj.employee.manager.service;

import io.aturanj.employee.manager.exception.UserNotFoundException;
import io.aturanj.employee.manager.model.Employee;
import io.aturanj.employee.manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public void deleteEmployeeByID(Long employeeId) {
        employeeRepository.deleteEmployeeByID(employeeId);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findEmployeeById(employeeId)
                .orElseThrow(() -> new UserNotFoundException("User by id " + employeeId + " was not found"));
    }
}
