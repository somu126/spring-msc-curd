package com.ty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.dao.EmployeeDao;
import com.ty.dto.Employee;

public class EmployeeService {
	@Autowired
	EmployeeDao dao;
	public Employee saveEmployee(Employee emp)
	{
		dao.saveEmployee(emp);
		return emp;
		
	}
	public Employee getEmployeeByEmail(Employee emp)
	{
		Employee emp1=dao.getEmployeeByEmail(emp.getEmail());
		if(emp1.getPassword().equals(emp.getPassword()))
		{
			return emp1;
		}
		else
		{
			return null;
		}
	}
public List<Employee> getallEmployee() {
		
		return dao.getAllEmployee();
	}
	public void removeEmployee(int id)
	{
		dao.removeEmployee(id);
	}
    public Employee getEmployeeByid(int id)
    {
    	return dao.getEmployeeByid(id);
    }
   public void updateEmployee(Employee emp)
    {
    	Employee emp1=dao.updateEmployee(emp);
     }

}
