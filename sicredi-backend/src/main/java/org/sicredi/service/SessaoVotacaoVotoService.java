package org.sicredi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sicredi.api.VerificaCpfApi;
import org.sicredi.dto.RelatorioVotacaoDTO;
import org.sicredi.dto.VotoDTO;
import org.sicredi.entity.SessaoVotacao;
import org.sicredi.entity.SessaoVotacaoVoto;
import org.sicredi.exception.UsuarioNaoAutorizadoVotarException;
import org.sicredi.repository.SessaoVotacaoRepository;
import org.sicredi.repository.SessaoVotacaoVotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessaoVotacaoVotoService {

	private SessaoVotacaoVotoRepository sessaoVotacaoVotoRepository;
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	private VerificaCpfApi verificaCpfApi;
	public SessaoVotacaoVotoService(
			SessaoVotacaoVotoRepository sessaoVotacaoVotoRepository,
			SessaoVotacaoRepository sessaoVotacaoRepository,
			VerificaCpfApi verificaCpfApi) {
		this.sessaoVotacaoVotoRepository = sessaoVotacaoVotoRepository;
		this.sessaoVotacaoRepository=sessaoVotacaoRepository;
		this.verificaCpfApi= verificaCpfApi;
	}
	
	@Transactional
	public SessaoVotacaoVoto votar(VotoDTO votoDTO){
		
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.findByIdPauta(votoDTO.getIdPauta());
		SessaoVotacaoVoto sessaoVotacaoVoto = new SessaoVotacaoVoto();
		
		boolean podeVotar = verificaCpfApi.verificaSeCpfPodeVotar(votoDTO.getNuCpf());
		if (podeVotar) {
			sessaoVotacaoVoto.setIdSessaoVotacao(sessaoVotacao.getIdSessaoVotacao());
			sessaoVotacaoVoto.setVoto(votoDTO.getVoto());
			sessaoVotacaoVoto.setNuCpf(votoDTO.getNuCpf());
			return sessaoVotacaoVotoRepository.save(sessaoVotacaoVoto);
			
		} else {
			throw new UsuarioNaoAutorizadoVotarException();	
		}
		
	}
	
	public List<RelatorioVotacaoDTO> relatorioDeVotos(){
		
		List<RelatorioVotacaoDTO> list = new ArrayList<RelatorioVotacaoDTO>();

		List<Object[]> listOb = sessaoVotacaoVotoRepository.findAllOrderByDateIniAndPauta();
		for (Object[] object : listOb) {
			RelatorioVotacaoDTO relatorioVotacaoDTO = new RelatorioVotacaoDTO();
			relatorioVotacaoDTO.setNmPauta(object[0].toString()) ;
			relatorioVotacaoDTO.setDtInicioVotacao(new Date());
			relatorioVotacaoDTO.setDtFinalVotacao(new Date());
			relatorioVotacaoDTO.setQtdVotosFalse(Integer.valueOf(object[3].toString()));
			relatorioVotacaoDTO.setQtdVotosTrue(Integer.valueOf(object[4].toString()));
			relatorioVotacaoDTO.setStatus(object[5].toString());
			list.add(relatorioVotacaoDTO);
		}
		return list;
	}
	
	
	public Iterable<SessaoVotacaoVoto> buscarTodos(){
		

		return sessaoVotacaoVotoRepository.findAll();
	}
	
}
