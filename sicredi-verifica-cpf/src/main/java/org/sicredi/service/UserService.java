package org.sicredi.service;

import java.util.List;

import org.sicredi.entity.UserApp;
import org.sicredi.exception.CpfInvalidoException;
import org.sicredi.repository.UserRepository;
import org.sicredi.util.cpf.GeraValidarCpf;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

	private UserRepository associadoRepository;
	private GeraValidarCpf geraValidarCpf;
	
	public UserService(UserRepository associadoRepository,GeraValidarCpf geraValidarCpf) {
		this.associadoRepository = associadoRepository;
		this.geraValidarCpf =geraValidarCpf;
	}
	
	@Transactional
	public UserApp save(UserApp associado) {
		associadoRepository.save(associado);
		return associado;
	}
	
	@Transactional
	public boolean podeVotar(long cpf) {
		
		if (!geraValidarCpf.isCPF(String.valueOf(cpf))) {
			throw new CpfInvalidoException();
		}

		UserApp user = associadoRepository.findByNuCpf(cpf);
		if (user==null) {
			throw new CpfInvalidoException();
		}

		if (user.getStPodeVotar()==1) {
			return true;
		}

		return false;
	}
	
	public List<UserApp> findAll() {
		
		return associadoRepository.findAll();
	}
}
