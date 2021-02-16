package com.myBatis.EmployeeCrud.controller;

import com.myBatis.EmployeeCrud.csv.Employee;
import com.myBatis.EmployeeCrud.exception.EmployeeAlreadyExitsException;
import com.myBatis.EmployeeCrud.model.Employees;
import com.myBatis.EmployeeCrud.services.EmployeesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
@CrossOrigin("*")
public class EmployeesController {

    @Autowired
    EmployeesService  service;

    @GetMapping("employees")
    public List<Employees> getAllEmployees(){
        log.info("All details fetched from database");
        return service.getAllEmployees();
    }
    @GetMapping("/download/employees.csv")
    public void downloadCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; file=employees.csv");

        List<Employees> emp = (List<Employees>) service.getAllEmployees();
        Employee.writeObjectToCSV(response.getWriter(), emp);
    }
    @GetMapping("/employees/gender/{gender}")
    public List<Employees> getAllEmployeesByGender(@PathVariable String gender){
        return service.findByGender(gender);
    }
    @PostMapping("employees")
    public ResponseEntity<Employees> saveEmployee(@RequestBody Employees employees) throws EmployeeAlreadyExitsException {
        return new ResponseEntity<Employees>(service.addEmployee(employees), HttpStatus.CREATED);
    }
    @DeleteMapping("/employee/{emp_id}")
    public ResponseEntity<Employees> deleteByEmpId(@PathVariable int emp_id){
        service.deleteEmployee(emp_id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("employees")
    public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employees){
      return new ResponseEntity<Employees>(service.updateEmployee(employees),HttpStatus.CREATED);
    }


}
