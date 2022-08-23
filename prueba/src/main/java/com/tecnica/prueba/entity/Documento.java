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
public class Documento {
	
	@Id
	@GeneratedValue
	private int nid;
	private String tipo;
	private String numero;
	private int cn_fk;
	
	public Documento() {
		super();
	}

	public Documento(int nid, String tipo, String numero, int cn_fk) {
		super();
		this.nid = nid;
		this.tipo = tipo;
		this.numero = numero;
		this.cn_fk = cn_fk;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCn_fk() {
		return cn_fk;
	}

	public void setCn_fk(int cn_fk) {
		this.cn_fk = cn_fk;
	}
}
