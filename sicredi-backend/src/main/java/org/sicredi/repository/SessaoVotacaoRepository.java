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
	@Query(value = "UPDATE Sessao_Votacao SET idStatusSessaoVotacao=:idStatusSessaoVotacao WHERE idSessaoVotacao=:idSessaoVotacao" ,nativeQuery = true)
	public void encerrarVotacao(Integer idStatusSessaoVotacao,Integer idSessaoVotacao );
	
    @Query(value = 
    		"SELECT sv.*"
    		+ " from pauta p"
    		+ " inner join sessao_votacao sv on p.id_Pauta=sv.id_Pauta "
    		//+ " where sv.id_status_sessao_votacao = 0",
    		+ " where p.id_pauta =:idPauta",
    		nativeQuery = true)
    public SessaoVotacao findByIdPauta(@Param("idPauta") int idPauta);

}
