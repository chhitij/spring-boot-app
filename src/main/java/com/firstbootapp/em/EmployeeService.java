package com.firstbootapp.em;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
  String createEmployee(Employee employee);

  List<Employee> readEmloyees();

  boolean deleteEmployee(Long id);

  String UpdateEmployee(Long id, Employee employee);

  Employee readEmloyee(Long id);

}
