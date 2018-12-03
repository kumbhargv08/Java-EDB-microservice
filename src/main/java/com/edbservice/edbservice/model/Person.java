package com.edbservice.edbservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Person implements Serializable{
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
    private long id;
	
	@NotBlank
	@Column(name = "name")
	private Object name;
	
	@NotBlank
	@Column(name = "username")
	private String username;
	
	@NotBlank
	@Column(name = "password")
	private String password;
	
	@NotBlank
	@Column(name = "address")
	private Object address;
	
	@NotBlank
	@Column(name = "DOB")
	private String DOB;
	
	@NotBlank
	@Column(name = "gender")
	private String gender;
	
	@NotBlank
	@Column(name = "mobileNo")
	private int mobileNo;
	
	@NotBlank
	@Column(name = "email")
	private String email;

	@NotBlank
	@Column(name = "createat")
	private String createat;
	
	@NotBlank
	@Column(name = "changedat")
	private String changedat;

 
    public Object getName() {
		return name;
	}

	public void setName(Object name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Object getAddress() {
		return address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		this.DOB = dOB;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateat() {
		return createat;
	}

	public void setCreateat(String createat) {
		this.createat = createat;
	}

	public String getChangeddat() {
		return changedat;
	}

	public void setChangeddat(String changeddat) {
		this.changedat = changeddat;
	}

	public void setId(long id){
    	this.id = id;
    }
    
    public long getId(){
    	return id;
    }
    
    public Person() {}
 
 
    public Person(long id, @NotBlank Object name, @NotBlank String username,
			@NotBlank String password, @NotBlank Object address,
			@NotBlank String dOB, @NotBlank String gender,
			@NotBlank int mobileNo, @NotBlank String email,
			@NotBlank String createat,
			@NotBlank String changedat) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.address = address;
		this.DOB = dOB;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.email = email;
		this.createat = createat;
		this.changedat = changedat;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", username="
				+ username + ", password=" + password + ", address=" + address
				+ ", DOB=" + DOB  + ", gender="
				+ gender + ", mobileNo=" + mobileNo
				+ ", email=" + email
				+ ", createat=" + createat + ", Changeddat=" + changedat + "]";
	}


}

