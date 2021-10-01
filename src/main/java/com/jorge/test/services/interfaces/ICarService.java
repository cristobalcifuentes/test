package com.jorge.test.services.interfaces;

import java.util.List;

import com.jorge.test.models.DTOs.CarDto;
import com.jorge.test.models.entitys.CarEntity;

public interface ICarService {
	
	public List<CarDto> getCarsByFranchise(String franchise);
	
	public CarEntity saveCarsByFranchise(CarDto carDto, String franchise);

}
