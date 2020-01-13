package org.sicredi.repository;

import java.util.List;

import org.sicredi.entity.SessaoVotacao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoRepository extends CrudRepository<SessaoVotacao, Integer>{

	@Modifying
	@Query(value = "UPDATE sessao_votacao SET id_Status_Sessao_Votacao=:idStatusSessaoVotacao WHERE dt_Final_Votacao<=CURRENT_TIMESTAMP and id_status_sessao_votacao=1" ,nativeQuery = true)
	public void encerrarVotacao(@Param("idStatusSessaoVotacao") Integer idStatusSessaoVotacao);
	
	
	@Query(value = "select * from sessao_votacao WHERE dt_Final_Votacao<=CURRENT_TIMESTAMP and id_status_sessao_votacao=1" ,nativeQuery = true)
	public List<SessaoVotacao> findBySessaoVotacaoEncerrada();
}
