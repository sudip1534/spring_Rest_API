package com.first.empmanagement.service;

import com.first.empmanagement.model.Employee;
import com.first.empmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;





    public List<Employee> getAllEmps(){

        return this.employeeRepository.findAll();
    }

    public  Employee addEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    //update emp data
    public Employee updateEmp(Integer id, Employee newEmpData){
        Employee oldEmpData = this.employeeRepository.findById(id).get();

       oldEmpData.setFirstname(newEmpData.getFirstname());
       oldEmpData.setLastname(newEmpData.getLastname());
       oldEmpData.setSalary(newEmpData.getSalary());
       oldEmpData.setLocation(newEmpData.getLocation());
       oldEmpData.setNoOfyearsOfExperience(newEmpData.getNoOfyearsOfExperience());

        this.employeeRepository.save(oldEmpData);
        return oldEmpData;

    }

    //delete emp data
    public void deleteEmp(Integer id){
        this.employeeRepository.deleteById(id);

    }

    //update specific data
    public Employee getSpecificEmp(Integer empId){
        Employee selectedEmp=this.employeeRepository.findById(empId).get();
        return selectedEmp;
    }

    //Partial Update
    public String patchUpdateEmp(Integer id, String firstName){

        Employee existingEmp=this.employeeRepository.findById(id).get();

        existingEmp.setFirstname(firstName);
        this.employeeRepository.save(existingEmp);

        return "Updated Successfully";
    }

}
