package org.sicredi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserApp {
	@Id
	private long nuCpf;
	private String nmUser;
	private int stPodeVotar;
	
	public long getNuCpf() {
		return nuCpf;
	}
	public void setNuCpf(long nuCpf) {
		this.nuCpf = nuCpf;
	}
	
	public String getNmUser() {
		return nmUser;
	}
	public void setNmUser(String nmUser) {
		this.nmUser = nmUser;
	}
	public int getStPodeVotar() {
		return stPodeVotar;
	}
	public void setStPodeVotar(int stPodeVotar) {
		this.stPodeVotar = stPodeVotar;
	}
	
	
	
}
