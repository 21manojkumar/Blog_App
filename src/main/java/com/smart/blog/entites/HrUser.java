package com.smart.blog.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HrUser {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer hrId;
	private String hrName;
	private String department;
	private String address;
	
	
	
	public Integer getHrId() {
		return hrId;
	}
	public void setHrId(Integer hrId) {
		this.hrId = hrId;
	}
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public HrUser(Integer hrId, String hrName, String department, String address) {
		super();
		this.hrId = hrId;
		this.hrName = hrName;
		this.department = department;
		this.address = address;
	}
	public HrUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
