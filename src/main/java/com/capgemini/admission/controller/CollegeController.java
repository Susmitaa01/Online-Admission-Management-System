package com.capgemini.admission.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.admission.dto.CollegeDTO;
import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.entity.College;
import com.capgemini.admission.exception.CollegeNotFoundException;
import com.capgemini.admission.service.ICollegeService;
import com.capgemini.admission.service.IUniversityService;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

	// Inject dependency of UniversityService
	@Autowired
	private IUniversityService universityService;

	// Inject dependency of CollegeService
	@Autowired
	private ICollegeService collegeService;

	// Create new College
	@PostMapping
	public ResponseEntity<CollegeDTO> addCollege(@RequestBody CollegeDTO collegeDTO) {
		UniversityDTO universityDTO = universityService.getByUniversityId(collegeDTO.getCollegeRegId());
		CollegeDTO college = collegeService.addCollege(collegeDTO);
		return ResponseEntity.ok(college);
	}

	// Update College details
	@PutMapping
	public ResponseEntity<CollegeDTO> updateCollege(@RequestBody CollegeDTO collegeDTO) {
		CollegeDTO college = collegeService.addCollege(collegeDTO);
		return ResponseEntity.ok(college);
	}

	// Get details of specific College
	@GetMapping("/{collegeRegId}")
	public ResponseEntity<CollegeDTO> getClgById(@PathVariable int collegeRegId) {
		CollegeDTO collegeDTO = collegeService.getByClgId(collegeRegId);
		return new ResponseEntity<CollegeDTO>(collegeDTO, HttpStatus.FOUND);
	}

	// get all Colleges
	@GetMapping
	public ResponseEntity<List<CollegeDTO>> getAllColleges() {
		List<CollegeDTO> list = collegeService.findAll();
		return ResponseEntity.ok(list);
	}

	// Delete College
	@DeleteMapping("/{collegeRegId}")
	public ResponseEntity<CollegeDTO> deleteCourseById(@PathVariable Integer collegeRegId) {
		CollegeDTO collegeDTO = collegeService.getByClgId(collegeRegId);
		if (collegeDTO != null) {
			collegeService.deleteCollege(collegeDTO);
			return new ResponseEntity<CollegeDTO>(collegeDTO, HttpStatus.ACCEPTED);

		}

		throw new CollegeNotFoundException("College with id " + collegeRegId + " doesn't exist");
	}

	// get Colleges based on University Id
	@GetMapping("/university/{uid}")
	public List<College> getCollegesByUniversityId(@PathVariable("uid") int universityId) {
		return collegeService.getCollegesByUniversityId(universityId);
	}

}
