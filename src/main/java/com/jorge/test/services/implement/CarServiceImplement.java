package com.jorge.test.services.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jorge.test.models.DTOs.CarDto;
import com.jorge.test.models.entitys.CarEntity;
import com.jorge.test.models.entitys.FranchiseEntity;
import com.jorge.test.repositories.ICarRepository;
import com.jorge.test.repositories.IFranchiseRepository;
import com.jorge.test.services.interfaces.ICarService;

@Service
public class CarServiceImplement implements ICarService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private IFranchiseRepository franchiseRepository;
	
	@Autowired
	private ICarRepository carRepository;
	
	final private String API_REST = "https://run.mocky.io/v3/c1c90329-7e70-4c74-bd62-6538c8613f03" ;


	@Override
	public List<CarDto> getCarsByFranchise(String franchise) {
		
		List<CarDto> cars = new ArrayList<>();
		try {
			List<CarDto> carsApi = Arrays.asList(restTemplate.getForObject(API_REST , CarDto[].class));
			cars.addAll(carsApi);
			List<FranchiseEntity> franchises  = franchiseRepository.findByName(franchise) ;
			if(franchises.size() == 1) {
				FranchiseEntity franchiseEntity = franchises.get(0);
				List<CarEntity> carsFranchise = carRepository.findByFranchise(franchiseEntity.getIdFranchise()); 
				cars.addAll(entityToDtoCars(carsFranchise));
			}
			
		} catch (Exception e) {
			//agregar la excepcion correspondiente
		}
		return cars;
	}
	
	private List<CarDto> entityToDtoCars(List<CarEntity> carsEntitys){
		List<CarDto> carsDto = new ArrayList<>();
		for (CarEntity entity: carsEntitys) {
			CarDto dto = new CarDto();
			dto.setName(entity.getName());
			dto.setPlate(entity.getPlate());
			carsDto.add(dto);
		}
		return carsDto;
	}

	@Override
	public CarEntity saveCarsByFranchise(CarDto carDto, String franchise) {
		
		List<FranchiseEntity> franchises  = franchiseRepository.findByName(franchise) ;
		FranchiseEntity franchiseEntity = null;
		if(franchises.size() == 1) {
			franchiseEntity = franchises.get(0);
		}
		CarEntity carEntity = new CarEntity();
		carEntity.setFranchise(franchiseEntity);
		carEntity.setName(carDto.getName());
		carEntity.setPlate(carDto.getPlate());
		
		return carRepository.save(carEntity);
	}

}
