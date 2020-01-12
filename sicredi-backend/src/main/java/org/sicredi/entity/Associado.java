package org.sicredi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Associado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAssociado;
	private int nuCpf;
	private String nmAssociado;
	
	public int getNuCpf() {
		return nuCpf;
	}
	public void setNuCpf(int nuCpf) {
		this.nuCpf = nuCpf;
	}
	public int getIdAssociado() {
		return idAssociado;
	}
	public void setIdAssociado(int idAssociado) {
		this.idAssociado = idAssociado;
	}
	public String getNmAssociado() {
		return nmAssociado;
	}
	public void setNmAssociado(String nmAssociado) {
		this.nmAssociado = nmAssociado;
	}
	
	
}
