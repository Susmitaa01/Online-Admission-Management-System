package com.capgemini.admission.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.entity.University;
import com.capgemini.admission.repository.UniversityRepository;
import com.capgemini.admission.service.IUniversityService;

@Service
public class IUniversityServiceImpl implements IUniversityService {

	// Inject dependency of universityRepository
	@Autowired
	private UniversityRepository universityRepository;

	// Add University
	@Override
	public UniversityDTO saveUniversity(UniversityDTO universityDTO) {
		// convert dto object into entity object
		University university = new University();
		BeanUtils.copyProperties(universityDTO, university);
		universityRepository.save(university);
		return universityDTO;
	}

	// To update University
	@Override
	public UniversityDTO updateUniversity(UniversityDTO universityDTO) {

		University university = new University();
		BeanUtils.copyProperties(universityDTO, university);
		universityRepository.save(university);
		return universityDTO;

	}

	// To get all the universities
	@Override
	public List<UniversityDTO> findAll() {
		// TODO Auto-generated method stub
		Iterable<University> list = universityRepository.findAll();
		List<UniversityDTO> dtos = new ArrayList<>();
		for (University uni : list) {
			UniversityDTO dto = new UniversityDTO();
			BeanUtils.copyProperties(uni, dto);
			dtos.add(dto);
		}
		return dtos;
	}

	// to delete particular university
	@Override
	public UniversityDTO deleteUniversity(UniversityDTO universityDTO) {
		// TODO Auto-generated method stub
		University university = new University();
		BeanUtils.copyProperties(universityDTO, university);
		universityRepository.delete(university);
		return universityDTO;
	}

	// get university by university id
	@Override
	public UniversityDTO getByUniversityId(int universityId) {

		Optional<University> university = universityRepository.findById(universityId);
		if (university.isPresent()) {
			// convert the entity object to DTO object
			UniversityDTO dto = new UniversityDTO();
			BeanUtils.copyProperties(university.get(), dto);
			return dto;
		}
		return null;

	}

}
