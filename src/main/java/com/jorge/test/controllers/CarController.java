package com.jorge.test.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.test.models.DTOs.CarDto;
import com.jorge.test.models.entitys.CarEntity;
import com.jorge.test.services.interfaces.ICarService;

@RestController
@RequestMapping("cars")
public class CarController {
	
	
	@Autowired
	private ICarService carSer;
	
	@GetMapping("/{franchise}")
	public ResponseEntity<List<CarDto>> getCarsByFranchise(@PathVariable("franchise") String franchise){
		return new ResponseEntity<List<CarDto>>(carSer.getCarsByFranchise(franchise), HttpStatus.OK);
	}
	
	@PostMapping("/{franchise}")
	public ResponseEntity<CarEntity> saveCarsByFranchise(@RequestBody CarDto carDto, @PathVariable("franchise") String franchise){
		CarEntity carSaved = carSer.saveCarsByFranchise(carDto, franchise);
		return new ResponseEntity<CarEntity>(carSaved, HttpStatus.OK);
	}

}
