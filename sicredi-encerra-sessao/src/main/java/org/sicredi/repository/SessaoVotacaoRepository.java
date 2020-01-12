package org.sicredi.repository;

import org.sicredi.entity.SessaoVotacao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoRepository extends CrudRepository<SessaoVotacao, Integer>{

	@Modifying
	@Query(value = "UPDATE Sessao_Votacao SET id_Status_Sessao_Votacao=:idStatusSessaoVotacao WHERE dt_Final_Votacao>=CURRENT_TIMESTAMP" ,nativeQuery = true)
	public void encerrarVotacao(@Param("idStatusSessaoVotacao") Integer idStatusSessaoVotacao);
}
