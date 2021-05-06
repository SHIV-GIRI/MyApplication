package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {
	@Query("from Department d where d.id > ?1")
	List<Department> getRecentDepartments(int deptid);

	@Query(value = "select avg(length(department_name)) from departments", nativeQuery = true)
	int getAvgLength();

	// List<Department> getDepartmentsByLocation (int locationid);
}
