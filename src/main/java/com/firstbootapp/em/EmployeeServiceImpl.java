package com.firstbootapp.em;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  // List<Employee> employees = new ArrayList<>();

  @Override
  public String createEmployee(Employee employee) {
    EmployeeEntity employeeEntity = new EmployeeEntity();
    BeanUtils.copyProperties(employee, employeeEntity);

    employeeRepository.save(employeeEntity);

    // employees.add(employee);
    return "Saved Successfully";
  }

  @Override
  public List<Employee> readEmloyees() {

    List<Employee> employees = new ArrayList<>();
    List<EmployeeEntity> employeesList = employeeRepository.findAll();

    // for (EmployeeEntity employeeEntity : employeesList) {
    // Employee emp = new Employee();
    // emp.setName(employeeEntity.getName());
    // emp.setId(employeeEntity.getId());
    // emp.setEmail(employeeEntity.getEmail());
    // emp.setPhone(employeeEntity.getPhone());
    // employees.add(emp);
    // }

    for (EmployeeEntity employeeEntity : employeesList) {
      Employee emp = new Employee();
      BeanUtils.copyProperties(employeeEntity, emp);
      employees.add(emp);
    }
    return employees;
  }

  @Override
  public boolean deleteEmployee(Long id) {
    EmployeeEntity emp = employeeRepository.findById(id).get();
    employeeRepository.delete(emp);
    // employees.remove(id);
    return true;
  }

  @Override
  public String UpdateEmployee(Long id, Employee employee) {
    EmployeeEntity existingEmp = employeeRepository.findById(id).get();

    existingEmp.setEmail(employee.getEmail());
    existingEmp.setName(employee.getName());
    existingEmp.setPhone(employee.getPhone());
    employeeRepository.save(existingEmp);
    return "update Successfully";
  }

  @Override
  public Employee readEmloyee(Long id) {
    EmployeeEntity empEntity = employeeRepository.findById(id).get();
    Employee employee = new Employee();
    BeanUtils.copyProperties(empEntity, employee);
    return employee;
  }

}
