package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.domain.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/display")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "4") Integer pageSize) {
		List<Student> list = studentService.getAllStudents(pageNo, pageSize);

		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/add")
	public Student addStudent(@RequestBody Student ticket) {
		return studentService.addStudent(ticket);
	}

}
