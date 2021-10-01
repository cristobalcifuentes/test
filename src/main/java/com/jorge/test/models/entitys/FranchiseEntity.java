package com.jorge.test.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "franchise")
public class FranchiseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFranchise;

	@Column(name = "name")
	private String name;

	public Integer getIdFranchise() {
		return idFranchise;
	}

	public void setIdFranchise(Integer idFranchise) {
		this.idFranchise = idFranchise;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FranchiseEntity [idFranchise=" + idFranchise + ", name=" + name + "]";
	}
	
	
	
	

}
