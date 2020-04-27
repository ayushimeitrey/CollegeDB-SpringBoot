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
import com.example.College.repositories.departmentRepository;

@Service
public class DepartmentService {
	@Autowired
	departmentRepository depRepo;
	
	public List<Department> getDepartments() {
		return depRepo.findAll();
	}
	
	public Department addDepartments(@RequestBody Department dep) {
		return depRepo.save(dep);
	}

	public Department editDepartments(@PathVariable(value="depId") Long id, @RequestBody Department dep) throws Exception{
		Optional<Department> oldDep=depRepo.findById(id);
		if(oldDep.isPresent()) {
			oldDep.get().setName(dep.getName());
			oldDep.get().setArea(dep.getArea());
			return depRepo.save(oldDep.get());
		}
		else {
			throw new Exception("No Department");
		}
	}

	public void deleteDepartments(@PathVariable(value="depId") Long id) {
		 depRepo.deleteById(id);
	}

	public Department updateName(String name, @PathVariable(value="depId") Long id) throws Exception{
		Optional<Department> oldDep=depRepo.findById(id);
		if(oldDep.isPresent()) {
			oldDep.get().setName(name);
			return depRepo.save(oldDep.get());
		}
		else {
			throw new Exception("No Department");
		}
	}
	
}
