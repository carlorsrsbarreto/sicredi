package org.sicredi.service;

import java.util.ArrayList;
import java.util.List;

import org.sicredi.entity.Pauta;
import org.sicredi.repository.PautaRepository;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

	private PautaRepository pautaRepository;
	
	public PautaService(PautaRepository pautaRepository) {
		this.pautaRepository = pautaRepository;
	}
	
	public List<Pauta> listPauta(){
		List<Pauta> result = new ArrayList<Pauta>();
		pautaRepository.findAll().iterator().forEachRemaining(result::add);
		return result;
	}
	
	public Pauta save(Pauta pauta){
		return pautaRepository.save(pauta);
	}
	
}
