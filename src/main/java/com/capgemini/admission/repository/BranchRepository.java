package com.capgemini.admission.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.admission.entity.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Integer> {

	@Query(value = "select c.branchList from Course c where c.courseId=:courseId ")
	List<Branch> FindBranchesByCourseId(@Param("courseId") Integer courseId);

	@Query(value = "select c.branchList from College c where c.collegeRegId=:collegeRegId")
	List<Branch> FindBranchesByCollegeRegId(@Param("collegeRegId") Integer collegeRegId);

}
