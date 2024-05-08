package com.firstbootapp.em;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/")
public class EmpConroller {
  // EmployeeService employeeService = new EmployeeServiceImpl();

  @Autowired
  EmployeeService employeeService;

  @GetMapping("employees")
  public List<Employee> getAllEmployee() {
    return employeeService.readEmloyees();
  }

  @GetMapping("employees/{id}")
  public Employee getEmployeeById(@PathVariable Long id) {
    return employeeService.readEmloyee(id);
  }

  @PostMapping("employees")
  public String postMethodName(@RequestBody Employee employee) {

    // employees.add(employee);

    return employeeService.createEmployee(employee);

  }

  @DeleteMapping("employees/{id}")

  public String deleteEmployee(@PathVariable Long id) {
    System.out.println(id);
    if (employeeService.deleteEmployee(id))
      return "Deleted Sucessfully";
    return "Unable to Delete the Employee";
  }

  @PutMapping("employees/{id}")
  public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
    return employeeService.UpdateEmployee(id, employee);
  }
}
