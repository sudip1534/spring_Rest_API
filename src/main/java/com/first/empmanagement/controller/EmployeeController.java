package com.first.empmanagement.controller;

import com.first.empmanagement.model.Employee;
import com.first.empmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empmanagement/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeservice;

    //get all data
@GetMapping("/all")
    public List<Employee> getAllMyEmployees(){

        return this.employeeservice.getAllEmps();
    }


    //add emp data
    @PostMapping("/addemp")
    public Employee addEmployee(@RequestBody Employee employee){
           return this.employeeservice.addEmployee(employee);
    }

    //update emp data
    @PutMapping("/update/{id}")
    public Employee updateEmpData(@PathVariable Integer id,@RequestBody Employee employee){
        return this.employeeservice.updateEmp(id,employee);
    }

    //delete emp data
    @DeleteMapping("/delete/{empId}")
    public void deleteEmployee(@PathVariable Integer empId)
    {
        this.employeeservice.deleteEmp(empId);
    }

    @GetMapping("/emp/{empId}")
    public Employee getEmp(@PathVariable Integer empId){

        return  this.employeeservice.getSpecificEmp(empId);
    }

    @PatchMapping("/patchupdate/{id}")
    public String partialUpdateEmpData(@PathVariable Integer id,@RequestBody String firstName){

    return this.employeeservice.patchUpdateEmp(id,firstName);
    }
}
