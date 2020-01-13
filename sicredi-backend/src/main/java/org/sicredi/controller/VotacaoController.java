package org.sicredi.controller;

import org.sicredi.dto.ResponseDTO;
import org.sicredi.dto.VotoDTO;
import org.sicredi.service.SessaoVotacaoVotoService;
import org.sicredi.util.exception.SicrediException;
import org.sicredi.util.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("votacao")
public class VotacaoController {

	private SessaoVotacaoVotoService sessaoVotacaoVotoService;
	
	private VotacaoController(SessaoVotacaoVotoService sessaoVotacaoVotoService) {
		this.sessaoVotacaoVotoService = sessaoVotacaoVotoService;
	}

	@PostMapping(value = "/votar", produces = "application/json")
    public ResponseEntity<ResponseDTO> votarNaPauta(@RequestBody VotoDTO votoDTO) {
		try {
			
			sessaoVotacaoVotoService.votar(votoDTO);		
			return ResponseEntity.accepted().body(
					ResponseMessage.votoComputadoSucesso().emptyBody()
			);
		} catch (SicrediException e) {
			return ResponseEntity.badRequest().body(
					ResponseMessage.error(e).emptyBody()
			);
		}
	}
	
}
