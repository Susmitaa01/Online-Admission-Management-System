package com.capgemini.admission.testutils;

import com.capgemini.admission.dto.UniversityDTO;

public class MasterData {

		public static UniversityDTO getUniversityDTO() {
			UniversityDTO dto = new UniversityDTO();
			dto.setUniversityId(1);
			dto.setName("SUK");
			dto.setCollegeList(null);
			return dto;
		}
}
