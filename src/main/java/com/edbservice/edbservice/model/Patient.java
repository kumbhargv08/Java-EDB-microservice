package com.edbservice.edbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table(name = "patient")
public class Patient extends Person{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4160793384031822900L;

	@NotBlank
	@Column(name = "bloodgrp")
	private String bloodgrp;
	
	@NotBlank
	@Column(name = "PastMedicalInput")
	private String[] pastMedicalInput;
	
	@NotBlank
	@Column(name = "patienthierarchy")
	private String patienthierarchy;

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public String[] getPastMedicalInput() {
		return pastMedicalInput;
	}

	public void setPastMedicalInput(String[] pastMedicalInput) {
		this.pastMedicalInput = pastMedicalInput;
	}

	public String getPatienthierarchy() {
		return patienthierarchy;
	}

	public void setPatienthierarchy(String patienthierarchy) {
		this.patienthierarchy = patienthierarchy;
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(long id, @NotBlank Object name, @NotBlank String username,
			@NotBlank String password, @NotBlank Object address,
			@NotBlank String dOB, @NotBlank String gender,
			@NotBlank int mobileNo, @NotBlank String email,
			@NotBlank String createat, @NotBlank String changedat,
			@NotBlank String bloodgrp,
			@NotBlank String[] pastMedicalInput,
			@NotBlank String patienthierarchy) {
		super(id, name, username, password, address, dOB, gender, mobileNo, email,
				createat, changedat);
		this.bloodgrp = bloodgrp;
		this.pastMedicalInput = pastMedicalInput;
		this.patienthierarchy = patienthierarchy;
	}
   
}

