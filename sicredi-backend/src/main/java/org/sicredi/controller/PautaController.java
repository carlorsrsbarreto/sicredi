package org.sicredi.controller;

import org.sicredi.dto.ResponseDTO;
import org.sicredi.entity.Pauta;
import org.sicredi.service.PautaService;
import org.sicredi.util.exception.SicrediException;
import org.sicredi.util.response.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pauta")
public class PautaController {

	private PautaService pautaService;
	
	private PautaController(PautaService pautaService) {
		this.pautaService = pautaService;
	}

	@GetMapping(produces = "application/json")
    public ResponseEntity<ResponseDTO> listPautaAll() {
		try {
			return ResponseEntity.accepted().body(
					ResponseMessage.listaSucesso().body(
					pautaService.listPauta()
					)
			);
		} catch (SicrediException e) {
			return ResponseEntity.badRequest().body(
					ResponseMessage.error(e).emptyBody()
			);
		}

    }
	
	@PostMapping(produces = "application/json")
    public Pauta insert(@RequestBody Pauta pauta) {
        return pautaService.save(pauta);
    }
	
}
