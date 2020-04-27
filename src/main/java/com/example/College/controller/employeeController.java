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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.College.model.Employee;
import com.example.College.repositories.employeeRepository;
import com.example.College.services.EmployeeService;

@RestController
public class employeeController {
	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("/department/{depId}/employees")
	public List<Employee> getEmployee(@PathVariable("depId") Long id){
		return empService.getEmployee(id);
	}
	
	@PostMapping("/department/{depId}/employees")
	public Employee addEmployee(@PathVariable("depId") Long id, @RequestBody Employee emp) throws Exception{
		return empService.addEmployee(id,emp);
	}
	
	@PutMapping("/department/{depId}/employees/{id}")
	public Employee editEmployee(@PathVariable(value="id") Long id,@PathVariable(value="depId") Long depId, @RequestBody Employee emp) throws Exception{
		return empService.editEmployee(id, depId, emp);
	}
	
	@DeleteMapping("/department/{depId}/employees/{id}")
	public void deleteEmployee(@PathVariable(value="id") Long id) throws Exception{
		 empService.deleteEmployee(id);
	}
	
	@ExceptionHandler
	void handleException(Exception e, HttpServletResponse response) throws Exception {
	    response.sendError(HttpStatus.BAD_REQUEST.value(),"Custom Exception- PLease enter correct entries");
	}
}
