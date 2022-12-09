package com.enveu.example.assigement.controller;

import com.enveu.example.assigement.entity.Employee;
import com.enveu.example.assigement.entity.EmployeeDTO;
import com.enveu.example.assigement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
/*@Author shyam kumar*/
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public String addEmployee(@RequestBody Employee employee){
        //System.out.println(employee.getName());
        return employeeService.addEmployee(employee);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){

        return employeeService.deleteEmployee(id);
    }
    @PutMapping("/update/{id}")
    public String updateData(@PathVariable("id") Integer id,@RequestBody Employee employee){
        String str3= employeeService.updateEmployee(id,employee);
        return str3=="update"?"Data update Successfully":"Id not Found";
    }

    @GetMapping("/details/{id}")
    public ArrayList<Employee> detailsData(@PathVariable("id") Integer id){
        return employeeService.detailsEmployee(id);
    }

    @GetMapping("/list")
    public ArrayList<EmployeeDTO> showList(){
        return employeeService.listEmployee();
    }
}
