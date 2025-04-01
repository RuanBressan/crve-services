package com.crveservices.crvservices.repositories;

import com.crveservices.crvservices.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {


}
