package io.aturanj.employee.manager.repository;

import io.aturanj.employee.manager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    void deleteEmployeeByID(Long employeeId);

    Optional<Employee>  findEmployeeById(Long employeeId);
}
