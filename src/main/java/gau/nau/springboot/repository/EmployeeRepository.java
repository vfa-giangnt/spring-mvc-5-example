package gau.nau.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gau.nau.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
