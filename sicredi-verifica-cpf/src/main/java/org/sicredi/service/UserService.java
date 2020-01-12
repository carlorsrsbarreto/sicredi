package org.sicredi.service;

import java.util.List;

import org.sicredi.entity.UserApp;
import org.sicredi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	private UserRepository associadoRepository;
	
	public UserService(UserRepository associadoRepository) {
		this.associadoRepository = associadoRepository;
	}
	
	@Transactional
	public UserApp save(UserApp associado) {
		associadoRepository.save(associado);
		return associado;
	}
	
	@Transactional
	public boolean podeVotar(long cpf) {
		
		UserApp associado = associadoRepository.findByNuCpf(cpf);
		if (associado==null) {
			
		}
		
		if (associado.getStPodeVotar()==1) {
			return true;
		}

		return false;
	}
	
	public List<UserApp> findAll() {
		
		return associadoRepository.findAll();
	}
}
