package com.myBatis.EmployeeCrud.services;

import com.myBatis.EmployeeCrud.exception.EmployeeAlreadyExitsException;
import com.myBatis.EmployeeCrud.model.Employees;

import java.util.List;
import java.util.Optional;

public interface EmployeesService {
    public Employees addEmployee(Employees employees) throws EmployeeAlreadyExitsException;
    List<Employees> getAllEmployees();
    List<Employees> findByGender(String gender);
    public void deleteEmployee(int emp_id);
    public Employees updateEmployee(Employees employees);
    Employees findById(int emp_id);
}
