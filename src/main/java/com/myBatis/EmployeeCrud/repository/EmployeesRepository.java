package com.myBatis.EmployeeCrud.repository;

import com.myBatis.EmployeeCrud.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    List<Employees> findByGender(String gender);
    Employees findById(int emp_id);
}
