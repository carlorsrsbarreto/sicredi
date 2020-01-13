package org.sicredi.controller;


import java.net.URI;

import org.sicredi.dto.ResponseDTO;
import org.sicredi.entity.UserApp;
import org.sicredi.exception.CpfInvalidoException;
import org.sicredi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("uses")
public class UserController {

	private String PARAM_ABLE_TO_VOTE="ABLE_TO_VOTE";
	private String PARAM_UNABLE_TO_VOTE="UNABLE_TO_VOTE";
	private String PARAM_LIST_ALL="ABLE_ROWS";
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@GetMapping(produces = "application/json")
    public ResponseEntity<ResponseDTO> consultaTodos() {
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			responseDTO.setStatus(PARAM_LIST_ALL);
			responseDTO.setBody(userService.findAll());
			return ResponseEntity.accepted().body(responseDTO);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }

	
	@GetMapping(value = "/{cpf}", produces = "application/json")
    public ResponseEntity<ResponseDTO> consultaCpf(@PathVariable("cpf") long cpf) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			
			boolean podeVotar = userService.podeVotar(cpf);
			if (podeVotar) {
				responseDTO.setStatus(PARAM_ABLE_TO_VOTE);
			} else {
				responseDTO.setStatus(PARAM_UNABLE_TO_VOTE);
			}
			return ResponseEntity.ok().body(responseDTO);
			
		} catch (CpfInvalidoException e) {
			return ResponseEntity.notFound().build();
		}
    }
	
	@PostMapping(produces = "application/json")
    public ResponseEntity<ResponseDTO> insert(@RequestBody UserApp associado) {
		
		ResponseDTO responseDTO = new ResponseDTO();
		try {
			userService.save(associado);
			responseDTO.setBody(associado);
			return ResponseEntity.created(new URI(String.valueOf((associado.getNuCpf())))).body(responseDTO);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }
	
	
}
