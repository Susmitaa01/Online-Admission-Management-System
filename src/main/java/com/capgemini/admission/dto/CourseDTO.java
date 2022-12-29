package com.capgemini.admission.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class CourseDTO {

	private int courseId;
	
	@NotBlank(message = "The Course name should not be blank, empty or Null")
	private String courseName;
	
	private String eligibity;
	
	@NotBlank(message = "The collegeRgId should not be blank,empty or Null")
	private int collegeRegId;
	
	
	private List<BranchDTO> branches = new ArrayList<>();
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getEligibity() {
		return eligibity;
	}
	public void setEligibity(String eligibity) {
		this.eligibity = eligibity;
	}
	
	public List<BranchDTO> getBranches() {
		return branches;
	}
	public void setBranches(List<BranchDTO> branches) {
		this.branches = branches;
	}
	public int getCollegeRegId() {
		return collegeRegId;
	}
	public void setCollegeRegId(int collegeRegId) {
		this.collegeRegId = collegeRegId;
	}

	

}
