package com.jorge.test.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "car")
public class CarEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCar;
	
	
	
	@Column(name="name")
	private String name;
	
	@Column(name="plate")
	private String plate;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "franchise_id", foreignKey = @ForeignKey(name = "FRANCHISE_fk"))
	private FranchiseEntity franchise;


	public Integer getIdCar() {
		return idCar;
	}


	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}


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


	public FranchiseEntity getFranchise() {
		return franchise;
	}


	public void setFranchise(FranchiseEntity franchise) {
		this.franchise = franchise;
	}
	
	
	

}
