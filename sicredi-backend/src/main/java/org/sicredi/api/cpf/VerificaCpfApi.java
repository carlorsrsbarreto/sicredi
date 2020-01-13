package org.sicredi.api.cpf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sicredi.api.cpf.dto.ResponseVerificaCpfDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VerificaCpfApi {

	private static final Logger logger = LogManager.getLogger(VerificaCpfApi.class);

	//private String URL = "http://127.0.0.1:8080/sicredi-verifica-cpf/uses";
	private String URL = "http://sicredi-verifica-cpf:8080/sicredi-verifica-cpf/uses";

	private String  PARAM_ABLE_TO_VOTE = "ABLE_TO_VOTE";
	
	public boolean verificaSeCpfPodeVotar(long nuCpf) {

		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ResponseVerificaCpfDTO> response  = restTemplate.getForEntity(URL + "/"+nuCpf, ResponseVerificaCpfDTO.class);
			
			if (PARAM_ABLE_TO_VOTE.equals(response.getBody().getStatus())){
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			logger.error("Ocorreu um erro ao consultar o serviço de CPF:" + e.getMessage());
			return false;
		}
				
	}
}
