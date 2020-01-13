package org.sicredi.util.response;

import org.sicredi.dto.MessageDTO;
import org.sicredi.dto.ResponseDTO;
import org.sicredi.util.exception.SicrediException;

public class ResponseMessage {

	private ResponseDTO responseDTO = new ResponseDTO();

	public static ResponseMessage listaSucesso() {
		ResponseMessage responseMessage = new ResponseMessage();
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setCode("I0001");
		messageDTO.setMessage("Lista retornada com sucesso!");
		responseMessage.responseDTO.setMessage(messageDTO);
		return responseMessage;		
	}

	public static ResponseMessage sessaoAbertaSucesso() {
		ResponseMessage responseMessage = new ResponseMessage();
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setCode("I0000");
		messageDTO.setMessage("Sessão aberta com sucesso!");
		responseMessage.responseDTO.setMessage(messageDTO);
		return responseMessage;		
	}

	public static ResponseMessage votoComputadoSucesso() {
		ResponseMessage responseMessage = new ResponseMessage();
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setCode("I0001");
		messageDTO.setMessage("Voto computado com sucesso!");
		responseMessage.responseDTO.setMessage(messageDTO);
		return responseMessage;		
	}

	public static ResponseMessage error(SicrediException e) {
		ResponseMessage responseMessage = new ResponseMessage();
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setCode(e.getCdMessage());
		messageDTO.setMessage(e.getMessage());
		responseMessage.responseDTO.setMessage(messageDTO);
		return responseMessage;		
	}
	
	
	public ResponseDTO body(Object body) {
		responseDTO.setBody(body);
		return responseDTO;
	}

	public ResponseDTO emptyBody() {
		responseDTO.setBody(null);
		return responseDTO;
	}
}
