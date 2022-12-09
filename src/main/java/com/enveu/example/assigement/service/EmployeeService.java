package com.enveu.example.assigement.service;

import com.enveu.example.assigement.entity.Employee;
import com.enveu.example.assigement.entity.EmployeeDTO;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
/*@Author Shyam Kumar*/
@Service
public class EmployeeService {

    ArrayList<Employee> al=new ArrayList<>();
    ArrayList<EmployeeDTO> dto=new ArrayList<>();

    public String addEmployee(Employee employee){
        int x=al.size();
        //System.out.println(employee.getName());
        al.add(employee);
        return x<al.size()?"Data add successfully":"Data not add ";
    }
    public String deleteEmployee(Integer id1){
        int x=al.size();
        al= (ArrayList<Employee>) al.stream().filter(ag1 -> ag1.getId() !=id1).collect(Collectors.toList());
        return x>al.size()?"Data delete successfully":"Id not found";

    }
    public String updateEmployee(Integer id, Employee employee){
        Iterator iterator=al.iterator();
        while (iterator.hasNext()){
            Employee e=(Employee) iterator.next();
            if (e.getId()==id){
                e.setName(employee.getName());
                e.setDepartment(employee.getDepartment());
                e.setSalary(employee.getSalary());
                return "update";
            }
        }
        return "not";

    }
    public ArrayList<EmployeeDTO> listEmployee(){
        dto.removeAll(dto);
        for (Employee e:al
             ) {
            dto.add(employeeDto(e));
        }
        return this.dto;
    }

    public ArrayList<Employee> detailsEmployee(Integer id2){
        return (ArrayList<Employee>) al.stream().filter(ag1 -> ag1.getId() ==id2).collect(Collectors.toList());
    }
    public EmployeeDTO employeeDto(Employee employee){
        EmployeeDTO dto=new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setDepartment(employee.getDepartment());
        return dto;
    }
}
