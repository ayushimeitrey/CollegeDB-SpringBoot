package com.example.College.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.College.model.Department;
import com.example.College.model.Employee;
import com.example.College.repositories.departmentRepository;
import com.example.College.repositories.employeeRepository;

@Service
public class EmployeeService {

	@Autowired
	employeeRepository empRepo;
	@Autowired
	departmentRepository depRepo;
	
	public List<Employee> getEmployee(Long id){
		Optional<Department> dep= depRepo.findById(id);	
		return empRepo.findByDep(dep.get());	
	}
	
	public Employee addEmployee(Long id, @RequestBody Employee emp) throws Exception{
		Optional<Department> dep= depRepo.findById(id);
		if(dep.isPresent()) {
			emp.setDep(dep.get());
			return empRepo.save(emp);
		}
		else {
			throw new Exception("test");
		}
		
	}
	
	public Employee editEmployee(@PathVariable(value="id") Long id,@PathVariable(value="depId") Long depId, @RequestBody Employee emp) throws Exception{
		Optional<Employee> oldEmp=empRepo.findById(id);
		Optional<Department> oldDep=depRepo.findById(depId);
		if(oldEmp.isPresent()) {
			oldEmp.get().setDep(oldDep.get());
			oldEmp.get().setfName(emp.getfName());
			oldEmp.get().setlName(emp.getlName());
			//oldEmp.get().setAddress(emp.getAddress());
			oldEmp.get().setSalary(emp.getSalary());
			return empRepo.save(oldEmp.get());
		}
		else {
			throw new Exception("No such Employee");
		}
	}
	
	public void deleteEmployee(@PathVariable(value="id") Long id) throws Exception{
		Optional<Employee> emp=empRepo.findById(id);
		if(emp.isPresent()) {
			empRepo.deleteById(id);
		}
		else {
			throw new Exception("No such Employee");
		}
	}

}
