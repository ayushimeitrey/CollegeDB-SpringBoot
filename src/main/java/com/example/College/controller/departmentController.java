package com.example.College.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.College.model.Department;
import com.example.College.repositories.departmentRepository;
import com.example.College.services.DepartmentService;

@RestController
public class departmentController {

	@Autowired
	DepartmentService depService;
	
	@GetMapping("/departments")
	public List<Department> getDepartments() {
		return depService.getDepartments();
	}
	
	@PostMapping("/departments")
	public Department addDepartments(@RequestBody Department dep) {
		return depService.addDepartments(dep);
	}
	
	@PutMapping("/departments/{depId}")
	public Department editDepartments(@PathVariable(value="depId") Long id, @RequestBody Department dep) throws Exception{
			return depService.editDepartments(id,dep);	
	}
	
	@PatchMapping("/departments/{depId}")
	public Department updateName(@RequestParam("name") String name, @PathVariable("depId") Long id) throws Exception{
	 return depService.updateName(name, id);
	}
	
	@DeleteMapping("/departments/{depId}")
	public void deleteDepartments(@PathVariable(value="depId") Long id) {
		depService.deleteDepartments(id);
	}
	
	@ExceptionHandler
	void handleException(Exception e, HttpServletResponse response) throws Exception {
	    response.sendError(HttpStatus.BAD_REQUEST.value(),"Custom Exception - PLease enter correct entries");
	}
	
}
