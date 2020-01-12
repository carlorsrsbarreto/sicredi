package org.sicredi.api;

import org.sicredi.api.dto.ResponseVerificaCpfDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VerificaCpfApi {
	private String URL = "http://127.0.0.1:8080/sicredi-verifica-cpf/uses";
	private String  PARAM_ABLE_TO_VOTE = "ABLE_TO_VOTE";
	private String  PARAM_UNABLE_TO_VOTE = "UNABLE_TO_VOTE";
	
	
	public boolean verificaSeCpfPodeVotar(long nuCpf) {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseVerificaCpfDTO> response  = restTemplate.getForEntity(URL + "/"+nuCpf, ResponseVerificaCpfDTO.class);
		
		if (PARAM_ABLE_TO_VOTE.equals(response.getBody().getStatus())){
			return true;
		} else if (PARAM_UNABLE_TO_VOTE.equals(response.getBody().getStatus())){
			return false;
		} else {
			return false;
		}
				
	}
}
