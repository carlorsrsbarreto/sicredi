package org.sicredi.controller;

import org.sicredi.dto.ResponseDTO;
import org.sicredi.dto.SessaoVotacaoDTO;
import org.sicredi.service.SessaoVotacaoService;
import org.sicredi.util.exception.SicrediException;
import org.sicredi.util.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sessao")
public class SessaoPautaController {

	private SessaoVotacaoService sessaoVotacaoService;
	
	private SessaoPautaController(SessaoVotacaoService sessaoVotacaoService) {
		this.sessaoVotacaoService = sessaoVotacaoService;
	}

	@PostMapping(value = "/abrir", produces = "application/json")
    public ResponseEntity<ResponseDTO> abrirSessaoVotacao(@RequestBody SessaoVotacaoDTO sessaoVotacaoDTO) {
		try {
			sessaoVotacaoService.abrirSessao(sessaoVotacaoDTO);		
			return ResponseEntity.accepted().body(
					ResponseMessage.sessaoAbertaSucesso().emptyBody()
			);
		} catch (SicrediException e) {
			return ResponseEntity.badRequest().body(
					ResponseMessage.error(e).emptyBody()
			);
		}
	}

	
}
