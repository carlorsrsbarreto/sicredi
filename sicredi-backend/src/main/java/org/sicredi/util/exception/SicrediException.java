package org.sicredi.util.exception;

public class SicrediException extends RuntimeException{

	private String cdMessage;
	public SicrediException(String cdMessage,String message) {
		super(message);
		this.cdMessage = cdMessage;
	}
	public String getCdMessage() {
		return cdMessage;
	}
	public void setCdMessage(String cdMessage) {
		this.cdMessage = cdMessage;
	}
	
}
