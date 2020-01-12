package org.sicredi.controller;

import org.sicredi.dto.ResponseDTO;
import org.sicredi.service.SessaoVotacaoVotoService;
import org.sicredi.util.exception.SicrediException;
import org.sicredi.util.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relatorio")
public class RelatorioVotacaoController {

	private SessaoVotacaoVotoService sessaoVotacaoVotoService;
	
	private RelatorioVotacaoController(SessaoVotacaoVotoService sessaoVotacaoVotoService) {
		this.sessaoVotacaoVotoService = sessaoVotacaoVotoService;
	}

	@GetMapping(value = "/votacao", produces = "application/json")
    public ResponseEntity<ResponseDTO> relatorioVotacao() {
		try {
			
			return ResponseEntity.accepted().body(
					ResponseMessage.listaSucesso().body(sessaoVotacaoVotoService.relatorioDeVotos())
			);
		} catch (SicrediException e) {
			return ResponseEntity.badRequest().body(
					ResponseMessage.error(e).emptyBody()
			);
		}
	}

	@GetMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<ResponseDTO> relatorioTodos() {
		try {
			
			return ResponseEntity.accepted().body(
					ResponseMessage.listaSucesso().body(sessaoVotacaoVotoService.buscarTodos())
			);
		} catch (SicrediException e) {
			return ResponseEntity.badRequest().body(
					ResponseMessage.error(e).emptyBody()
			);
		}
	}

}
