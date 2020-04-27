package com.example.College;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.College.model.Address;
import com.example.College.model.Department;
import com.example.College.model.Employee;
import com.example.College.repositories.departmentRepository;
import com.example.College.repositories.employeeRepository;

@SpringBootApplication
public class CollegeApplication{
/*	@Autowired
    private employeeRepository rep;
	@Autowired
    private departmentRepository drep;*/
	
	public static void main(String[] args) {
		SpringApplication.run(CollegeApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		rep.deleteAll();
		Long id=(long) 1;
        Set<Address> addresses = new HashSet<>();
        addresses.add(new Address("747", "Golf View Road",
                "Karnataka", "India", "560008"));
        addresses.add(new Address("Plot No 44", "Electronic City",
                "Karnataka", "India", "560001"));
        Department d= new Department();
        d.setId(id);
        drep.save(d);
        Employee e = new Employee(1L,"Ayu", "Mei", addresses,d);
        rep.save(e);
		
	}*/

}
