package org.sicredi.schedulle;

import org.sicredi.service.EncerraSessaoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Component
public class EncerraSessaoSchedulle {
	
	private static final Logger logger = LogManager.getLogger(EncerraSessaoSchedulle.class);
	   
	private EncerraSessaoService encerraSessaoService;
	
	public EncerraSessaoSchedulle(EncerraSessaoService encerraSessaoService) {
		this.encerraSessaoService = encerraSessaoService;
	}

	@Scheduled(cron = "0/20 * * * * *")
	public void scheduleFixedDelayTask() {

		logger.info(
	  	      "Inicio do processo de encerramento de sessao - " + System.currentTimeMillis() / 1000);
		encerraSessaoService.encerrarSessao();
		logger.info(
	      "Final do processo de encerramento de sessao - " + System.currentTimeMillis() / 1000);
	}	
}
