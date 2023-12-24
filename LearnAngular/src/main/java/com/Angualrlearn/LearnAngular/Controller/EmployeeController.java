package com.Angualrlearn.LearnAngular.Controller;

import com.Angualrlearn.LearnAngular.Model.Employee;
import com.Angualrlearn.LearnAngular.Service.EmployeeService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/allemployee")
     public ResponseEntity<List<Employee>> getallEmployee()
     {
         List<Employee> em = employeeService.getallempolyee();
         return new ResponseEntity<List<Employee>>(em, HttpStatus.OK);
     }
     @PostMapping("/save")
    public ResponseEntity<Employee> saveemployee(@RequestBody Employee employee)
     {
         Employee em = employeeService.createEmployee(employee);
         return  new ResponseEntity<Employee>(em,HttpStatus.CREATED);
     }

     @DeleteMapping ("/employee/{Id}")
    public  void deletemployee(@PathVariable("Id")Integer employeeId)
     {
            employeeService.DeletEmpolye(employeeId);
     }


     @PutMapping("/update/{employeeId}")
     ResponseEntity<Employee> updateEmploye(@RequestBody Employee employee, @PathVariable("employeeId") Integer  id)
     {
         Employee em = employeeService.updateEmployee(employee,id);
         return new ResponseEntity<Employee>(em,HttpStatus.OK);
     }


     @GetMapping("/employee/{Id}")
    public  ResponseEntity<Employee> getEmpolybyid(@PathVariable("Id")  Integer id)
     {
         Employee s = employeeService.getEmpolyeebyid(id);

         if(s!=null)
         {
              return  new ResponseEntity<Employee>(s,HttpStatus.OK);
         }
         else {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
     }
}
