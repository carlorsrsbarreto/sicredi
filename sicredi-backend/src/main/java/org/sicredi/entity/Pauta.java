package org.sicredi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPauta;
	private String nmPauta;
	public long getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(long idPauta) {
		this.idPauta = idPauta;
	}
	public String getNmPauta() {
		return nmPauta;
	}
	public void setNmPauta(String nmPauta) {
		this.nmPauta = nmPauta;
	}
 
	

}
