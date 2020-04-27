package com.example.College.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fName;
	
	private String lName;
	
	//private String address;
	
	private Double salary;
	
	@CreationTimestamp
	private Date created_at;
	
	@UpdateTimestamp
	private Date updated_at;
	
	@ManyToOne(fetch=FetchType.LAZY ,optional=false)
	@JoinColumn(name="depId", nullable=false)
	@JsonIgnore
	private Department dep;
	
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_addresses", joinColumns = @JoinColumn(name = "employee_id"))
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
    })
    private Set<Address> addresses = new HashSet<>();
	

	public Employee() {

	}
	
	public Employee(String fName, String lName, String address, Double salary) {
		this.fName = fName;
		this.lName = lName;
		//this.address = address;
		this.salary = salary;
	}
	
	
	public Employee(Long id, String fName, String lName, Set<Address> addresses,Department dep) {
		this.id = id;
		this.fName = fName;
		this.lName = lName;
		this.addresses = addresses;
		this.dep=dep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	/*public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}*/

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fName=" + fName + ", lName=" + lName +  ", salary="
				+ salary + "]";
	}
	
	
}
