package com.jorge.test.models.DTOs;

public class CarDto {
	
	public String name;
	
	public String plate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlate() {
		return plate;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	@Override
	public String toString() {
		return "CarDto [name=" + name + ", plate=" + plate + "]";
	}
	
	
	
	

}
