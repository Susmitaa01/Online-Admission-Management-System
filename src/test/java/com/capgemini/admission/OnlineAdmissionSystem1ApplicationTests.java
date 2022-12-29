package com.capgemini.admission;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.admission.dto.BranchDTO;
import com.capgemini.admission.dto.CollegeDTO;
import com.capgemini.admission.dto.CourseDTO;
import com.capgemini.admission.dto.UniversityDTO;
import com.capgemini.admission.service.IBranchService;
import com.capgemini.admission.service.ICollegeService;
import com.capgemini.admission.service.ICourseService;
import com.capgemini.admission.service.IUniversityService;

@SpringBootTest
class OnlineAdmissionSystem1ApplicationTests {

	@Autowired
	private IUniversityService universityService;
	
	@Autowired
	private ICollegeService collegeService;
	@Autowired
	private IBranchService branchService;
	@Autowired
	private ICourseService courseService;
	
	//@Test
	void contextLoads() {
	}

	/*void testSaveUniversity() {
		UniversityDTO universityDTO=new UniversityDTO();
		List<University> ulist = MasterData.getUniversityDTO();
		assertEquals(2,ulist.size());
	}*/
	
	@Test
	void testgetByUniversityId() {
		UniversityDTO u = universityService.getByUniversityId(25);
		assertEquals("Shivaji University", u.getName());
	}
	
	@Test
	void testgetByClgId() {
		CollegeDTO c = collegeService.getByClgId(45);
		assertEquals("BLR",c.getCollegeName());
	}
	
	/*@Test
	void testgetByBranchId() {
		BranchDTO b = branchService.getByBranchId(35);
		assertEquals("CSE",b.getBranchName());
		assertEquals("CSE with Machine Learning",b.getBranchDescription());
		assertEquals(27,b.getCollegeRegId());
		assertEquals(32,b.getCourseId());
		
	}*/
	
	@Test
	void testgetByCourseId() {
		CourseDTO c=courseService.getByCourseId(32);
		assertEquals("Btech",c.getCourseName());
		assertEquals("12th / diploma",c.getEligibity());
	}
}
