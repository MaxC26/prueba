package com.tecnica.prueba.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Direccion {

	@Id
	@GeneratedValue
	private int did;
	private String direccion;
	private int cd_fk;
	
	public Direccion() {
		super();
	}
	public Direccion(int did, String direccion, int cd_fk) {
		super();
		this.did = did;
		this.direccion = direccion;
		this.cd_fk = cd_fk;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCd_fk() {
		return cd_fk;
	}
	public void setCd_fk(int cd_fk) {
		this.cd_fk = cd_fk;
	}
}
