package com.revature.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.revature.model.SubtopicName;

@RepositoryRestResource
public interface SubtopicNameRepository extends JpaRepository<SubtopicName, Integer> {
	public SubtopicName findByid(Integer id);
	public SubtopicName findByName(String name);
	public List<SubtopicName> findAll();
}
