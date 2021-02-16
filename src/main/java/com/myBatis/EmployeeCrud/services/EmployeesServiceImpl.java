package com.myBatis.EmployeeCrud.services;

import com.myBatis.EmployeeCrud.exception.EmployeeAlreadyExitsException;
import com.myBatis.EmployeeCrud.model.Employees;
import com.myBatis.EmployeeCrud.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeesServiceImpl implements EmployeesService{

    @Autowired
    EmployeesRepository repository;

    @Override
    public Employees addEmployee(Employees employees) throws EmployeeAlreadyExitsException {
      if(repository.existsById(employees.getEmp_id()))
      {
          throw new EmployeeAlreadyExitsException();
      }
      Employees employees1 = repository.save(employees);
        return repository.save(employees1);
    }

    @Override
    public List<Employees> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public List<Employees> findByGender(String gender) {
        return repository.findByGender(gender);
    }

    @Override
    public void deleteEmployee(int emp_id) {
     repository.deleteById(emp_id);
    }

    @Override
    public Employees updateEmployee(Employees employees) {
        return repository.save(employees);
    }
}
