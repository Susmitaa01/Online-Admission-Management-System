package com.capgemini.admission.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class BranchDTO {

	private int branchId;
	
	@NotBlank(message = "The Branch name should not be blank,empty or Null")
	private String branchName;
	private String branchDescription;
	
	@NotBlank(message = "The collegeRgId should not be blank,empty or Null")
	private int collegeRegId;
	
	@NotBlank(message = "The courseId should not be blank,empty or Null")
	private int courseId;
	

	public int getCollegeRegId() {
		return collegeRegId;
	}

	public void setCollegeRegId(int collegeRegId) {
		this.collegeRegId = collegeRegId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchDescription() {
		return branchDescription;
	}

	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}

}
