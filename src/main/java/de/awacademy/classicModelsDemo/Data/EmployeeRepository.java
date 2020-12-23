package de.awacademy.classicModelsDemo.Data;

import de.awacademy.classicModelsDemo.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}