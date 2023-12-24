package com.Angualrlearn.LearnAngular.Repositry;

import com.Angualrlearn.LearnAngular.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo  extends JpaRepository<Employee,Integer> {




}
