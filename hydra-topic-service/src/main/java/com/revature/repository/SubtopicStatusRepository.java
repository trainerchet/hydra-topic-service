package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.model.SubtopicStatus;




@Repository
public interface SubtopicStatusRepository extends JpaRepository<SubtopicStatus, Integer> {
	public SubtopicStatus findByid(Integer id);
	public SubtopicStatus findByName(String name);
}