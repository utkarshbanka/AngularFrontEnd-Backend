package com.Angualrlearn.LearnAngular.Service;

import com.Angualrlearn.LearnAngular.Exception.ResourceNotFoundExcepiton;
import com.Angualrlearn.LearnAngular.Model.Employee;
import com.Angualrlearn.LearnAngular.Repositry.EmployeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl  implements EmployeeService{


    @Autowired
    private EmployeRepo employeRepo;

    @Override
    public Employee createEmployee(Employee empolyee) {

         Optional<Employee> getem = employeRepo.findById(empolyee.getId());

         Employee em = null;

         if(getem.isEmpty())
         {
              em = employeRepo.save(empolyee);
         }


        return em;
    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id) {

        Optional<Employee> getem = employeRepo.findById(id);

         Employee em = null;
         if(getem.isPresent())
         {
             em =  getem.get();
             em.setEmail(employee.getEmail());
             em.setFirst_Name(employee.getFirst_Name());
             em.setLast_Name(employee.getLast_Name());
             employeRepo.save(em);
         }


        return em;
    }

    @Override
    public void DeletEmpolye(Integer empolyeeid) {

        Optional<Employee> getem = employeRepo.findById(empolyeeid);

        if (getem.isPresent())
        {
            employeRepo.delete(getem.get());
        }
        else {
            throw new ResourceNotFoundExcepiton("No user Exist");
        }



    }

    @Override
    public List<Employee> getallempolyee() {

        return employeRepo.findAll();
    }

    @Override
    public Employee getEmpolyeebyid(Integer id) {

            return  employeRepo.findById(id).orElseThrow(()->new ResourceNotFoundExcepiton("No user exit with this id"));
    }
}
