package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;


@RestController
@RequestMapping("rest/dept")
public class RestControllerDepartment {
	@Autowired
	public DepartmentDao deptdao;

	@GetMapping()
	public Iterable<Department> getAllDept() {
		return deptdao.findAll();
	}

	@GetMapping("/{id}")
	public Department getOneDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptdao.findById(id);
		if (dept.isPresent())
			return dept.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Deprtment Not Found");
	}

	@PostMapping()
	public Department addDept(Department dept) {
		try {
			deptdao.save(dept);
			return dept;

		} catch (Exception e) {

			System.out.println(e);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Data");
		}
	}

	@DeleteMapping("{id}")
	public void deleteDept(@PathVariable("id") int id) {
		Optional<Department> dept = deptdao.findById(id);
		if (dept.isPresent()) {
			try {
				deptdao.delete(dept.get());

			} catch (Exception e) {

				System.out.println(e);
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "department id is not found!");
		}
	}
}
