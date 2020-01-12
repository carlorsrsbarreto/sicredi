package org.sicredi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.sicredi.entity.Pauta;
import org.sicredi.repository.PautaRepository;

public class PautaServiceTest {

	@Mock
	private PautaRepository pautaRepository;

	private PautaService pautaService;
	
	 @Before
	  public void init(){
	    MockitoAnnotations.initMocks(this);
		Mockito.when(pautaRepository.findAll()).thenReturn(creatMockList());
	    pautaService = Mockito.spy(new PautaService(pautaRepository));

	 }
	
	@Test
	public void findAllTest() {		
		int qtdList = pautaService.listPauta().size();
		assertEquals(3, qtdList);
	}
	
	private Iterable<Pauta> creatMockList(){

		Pauta pauta1 = new Pauta();
		pauta1.setIdPauta(1);
		pauta1.setNmPauta("Colocar toldo na entrada");

		Pauta pauta2 = new Pauta();
		pauta2.setIdPauta(2);
		pauta2.setNmPauta("Trocar portão da garagem");
		
		Pauta pauta3 = new Pauta();
		pauta3.setIdPauta(3);
		pauta3.setNmPauta("Comprar nova geladeira");

		Iterable<Pauta> iterable = Arrays.asList(pauta1, pauta2, pauta3);
		
		return iterable;
		
	}
	
}
