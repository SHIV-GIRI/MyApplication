package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.DepartmentDao;
import com.example.demo.model.Department;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentDao depts;

	@RequestMapping("/dept")
	public String getDept(@RequestParam("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		String msg;
		if (dept.isPresent())
			msg = dept.get().getId() + " _" + dept.get().getName();
		else
			msg = "sorry ! Department Id is Not Found";
		model.addAttribute("message", msg);
		return "dept_info";

	}

	@RequestMapping("/deptlist")
	public String getDeptList(ModelMap model) {
		model.addAttribute("depts", depts.findAll());
		return "deptlist";
	}

	@RequestMapping("/adddept")
	public String adddept(ModelMap model) {
		Department d = new Department();
		model.addAttribute("dept", d);
		return "add_dept";
	}

	@RequestMapping(value = "/adddept", method = RequestMethod.POST)
	public String addDept(@Valid Department d, Errors errors, ModelMap model) {
		try {
			if (errors.getErrorCount() > 0)
				throw new RuntimeException(errors.toString());
			if (depts.findById(d.getId()).isPresent())
				throw new RuntimeException("Dept Id exits");

			depts.save(d);
			return "redirect:/deptlist";
		} catch (Exception ex) {
			model.addAttribute("dept", d);
			model.addAttribute("message", ex.getMessage());
		}
		return "add_dept";
	}

	@RequestMapping("/deletedept/{id}")
	public String deleteDept(@PathVariable("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		if (dept.isPresent()) {
			depts.delete(dept.get());
			return "redirect:/deptlist";
		} else {
			model.addAttribute("error", "Department Id Not Found !!!");
			return "delete_dept";
		}

	}

	@RequestMapping("/editdept/{id}")
	public String editDept(@PathVariable("id") int id, ModelMap model) {
		Optional<Department> dept = depts.findById(id);
		if (dept.isPresent())
			model.addAttribute("dept", dept.get());
		else
			model.addAttribute("error", "Department Id Not Found !!!");
		return "edit_dept";
	}

	@RequestMapping(value = "/editdept/{id}", method = RequestMethod.POST)
	public String updateDept(@PathVariable("id") int id, Department d, ModelMap model) {
		try {
			Optional<Department> dept = depts.findById(d.getId());
			if (dept.isPresent())
				depts.save(d);
			else
				throw new Exception("Invaild Department id");
			return "redirect:/deptlist";
		} catch (Exception ex) {
			model.addAttribute("dept", d);
			model.addAttribute("message", ex.getMessage());
		}
		return "edit_dept";
	}

}
