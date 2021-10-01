package com.jorge.test.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jorge.test.models.entitys.CarEntity;

public interface ICarRepository extends JpaRepository<CarEntity, Integer> {
	
	
	@Query(value = "SELECT * FROM car where franchise_id = ?", nativeQuery = true)
	List<CarEntity> findByFranchise(int idFranchise);

}
