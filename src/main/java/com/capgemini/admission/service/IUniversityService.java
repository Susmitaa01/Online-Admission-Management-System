package com.capgemini.admission.service;

import java.util.List;

import com.capgemini.admission.dto.UniversityDTO;

public interface IUniversityService {
	
	public UniversityDTO saveUniversity(UniversityDTO universityDTO);

	public UniversityDTO updateUniversity(UniversityDTO universityDTO);

	public UniversityDTO deleteUniversity(UniversityDTO universityDTO);

	public UniversityDTO getByUniversityId(int universityId);

	public List<UniversityDTO> findAll();

}
