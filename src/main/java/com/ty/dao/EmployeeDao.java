package com.ty.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.ty.dto.Employee;

public class EmployeeDao {
	@Autowired
	EntityManagerFactory entityManagerFactory;
	public Employee saveEmployee(Employee emp) {
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entitymanager.getTransaction();
		entityTransaction.begin();
		entitymanager.persist(emp);
		entityTransaction.commit();
		return emp;	
	}
	public Employee updateEmployee(Employee emp)
	{
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entitymanager.getTransaction();
		entityTransaction.begin();
		entitymanager.merge(emp);
		entityTransaction.commit();
		return emp;
		
	}
	public Employee getEmployeeByid(int id)
	{
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Employee emp=entitymanager.find( Employee.class,id);
		return emp;
		
	}
	
	
	public void removeEmployee(int id)
	{
		EntityManager entitymanager=entityManagerFactory.createEntityManager();
		Employee emp=entitymanager.find( Employee.class,id);
		EntityTransaction entityTransaction=entitymanager.getTransaction();
		entityTransaction.begin();
		if(emp!=null)
		{
			entitymanager.remove(emp);
		}
		entityTransaction.commit();
		
	}
		
		public List<Employee> getAllEmployee()
		{     EntityManager entitymanager=entityManagerFactory.createEntityManager();
			Query query=entitymanager.createQuery("Select e from Employee e");
			List<Employee>s=query.getResultList();
		
			System.out.println("All data fetched from table");
			return s;
		}
		
		public Employee getEmployeeByEmail(String email)
		{
			EntityManager entitymanager = entityManagerFactory.createEntityManager();
			Query query=entitymanager.createQuery("Select e from Employee e where e.email=?1");
		return	(Employee)query.setParameter(1, email).getSingleResult();
		}
		
		
	}
	


