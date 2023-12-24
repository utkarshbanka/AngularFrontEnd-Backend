package com.Angualrlearn.LearnAngular.Service;

import com.Angualrlearn.LearnAngular.Model.Employee;

import java.util.List;

public interface EmployeeService  {


        public Employee  createEmployee(Employee empolyee);

        public Employee updateEmployee(Employee employee,Integer id);

        public void DeletEmpolye(Integer empolyeeid);


        public List<Employee> getallempolyee();

        public Employee getEmpolyeebyid(Integer id);

}
