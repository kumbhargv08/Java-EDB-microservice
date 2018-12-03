package com.edbservice.edbservice.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "DoctorMD")
public class Doctor extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5739629609470550687L;

	@NotBlank
    @Column(name = "specialized_in")
	private String[] specializedIn;
	
	@NotBlank
    @Column(name = "doctor_hierarchy")
	private String doctorHierarchy;

	public String[] getSpecializedIn() {
		return specializedIn;
	}

	public void setSpecializedIn(String[] specializedIn) {
		this.specializedIn = specializedIn;
	}

	public String getDoctorHierarchy() {
		return doctorHierarchy;
	}

	public void setDoctorHierarchy(String doctorHierarchy) {
		this.doctorHierarchy = doctorHierarchy;
	}

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(long id, @NotBlank Object name, @NotBlank String username,
			@NotBlank String password, @NotBlank Object address,
			@NotBlank String dOB, @NotBlank String gender,
			@NotBlank int mobileNo, @NotBlank String email,
			@NotBlank String createat, @NotBlank String changedat,
			@NotBlank String[] specializedIn,
			@NotBlank String doctorHierarchy) {
		super(id, name, username, password, address, dOB, gender, mobileNo, email,
				createat, changedat);
		this.specializedIn = specializedIn;
		this.doctorHierarchy = doctorHierarchy;
	}

    
   
    
}
