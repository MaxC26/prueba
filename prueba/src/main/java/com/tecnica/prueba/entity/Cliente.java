package com.tecnica.prueba.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private int id;
	private String nombres;
	private String apellidos;
	private String correo;
	
	@OneToMany(targetEntity = Direccion.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_fk", referencedColumnName = "id")
	private List<Direccion> direcciones;
	
	@OneToMany(targetEntity = Documento.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "cn_fk", referencedColumnName = "id")
	private List<Documento> documentos;

	public Cliente() {
		super();
	}

	public Cliente(int id, String nombres, String apellidos, String correo, List<Direccion> direcciones,
			List<Documento> documentos) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.direcciones = direcciones;
		this.documentos = documentos;
	}

	public Cliente(int id, String nombres, String apellidos, String correo) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}	
}
