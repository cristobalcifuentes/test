package com.jorge.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorge.test.models.entitys.FranchiseEntity;

public interface IFranchiseRepository extends JpaRepository<FranchiseEntity, Integer> {
	
	List<FranchiseEntity> findByName(String name);

}
