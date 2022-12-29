package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.CollegeDTO;
import com.capgemini.admission.entity.College;
import com.capgemini.admission.entity.University;
import com.capgemini.admission.repository.CollegeRepository;
import com.capgemini.admission.repository.UniversityRepository;
import com.capgemini.admission.service.ICollegeService;

@Service
public class ICollegeServiceImpl implements ICollegeService {
	@Autowired
	private CollegeRepository collegeRepository;
	@Autowired
	private UniversityRepository universityRepository;

	// To save college details
	@Override
	public CollegeDTO addCollege(CollegeDTO collegeDTO) {

		int universityId = collegeDTO.getUniversityId();
		University university = universityRepository.findById(universityId).get();

		// set university fields into colleges
		if (university != null) {
			// to convert dto into entity
			College college = new College();
			BeanUtils.copyProperties(collegeDTO, college);
			college.setUniversity(university);
			college.setCollegeName(collegeDTO.getCollegeName());
			collegeRepository.save(college);
		}
		return collegeDTO;

	}

	// To update college details
	@Override
	public CollegeDTO updateColleges(CollegeDTO collegeDTO) {

		College college = new College();
		BeanUtils.copyProperties(collegeDTO, college);
		collegeRepository.save(college);
		return collegeDTO;

	}

	// get colleges by college id
	@Override
	public CollegeDTO getByClgId(Integer collegeRegId) {

		Optional<College> college = collegeRepository.findById(collegeRegId);
		CollegeDTO dto = new CollegeDTO();
		BeanUtils.copyProperties(college.get(), dto);
		return dto;

	}

	// to get all colleges
	@Override
	public List<CollegeDTO> findAll() {
		List<College> colleges = (List<College>) collegeRepository.findAll();
		List<CollegeDTO> dtos = new ArrayList<>();
		for (College college : colleges) {
			CollegeDTO dto = new CollegeDTO();
			BeanUtils.copyProperties(college, dto);
			dtos.add(dto);
		}
		return dtos;

	}

	// to delete college
	@Override
	public CollegeDTO deleteCollege(CollegeDTO collegeDTO) {

		College college = new College();
		BeanUtils.copyProperties(collegeDTO, college);
		collegeRepository.delete(college);
		return collegeDTO;

	}

	// to get all colleges by university id
	@Override
	public List<College> getCollegesByUniversityId(int universityId) {

		University u = universityRepository.findById(universityId).get();
		return u.getCollegeList();

	}

}
