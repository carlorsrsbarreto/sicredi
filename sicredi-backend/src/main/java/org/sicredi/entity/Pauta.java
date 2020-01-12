package org.sicredi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPauta;
	private String nmPauta;
	public int getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(int idPauta) {
		this.idPauta = idPauta;
	}
	public String getNmPauta() {
		return nmPauta;
	}
	public void setNmPauta(String nmPauta) {
		this.nmPauta = nmPauta;
	}
 
	

}
