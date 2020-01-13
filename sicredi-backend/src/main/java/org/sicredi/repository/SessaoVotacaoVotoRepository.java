package org.sicredi.repository;

import java.util.List;

import org.sicredi.entity.SessaoVotacaoVoto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoVotacaoVotoRepository extends CrudRepository<SessaoVotacaoVoto, Long>{

    @Query(value = 
    		"SELECT "
    		+ "p.nm_pauta,"
    		+ "sv.dt_inicio_votacao,"
    		+ "sv.dt_final_votacao,"
    		+ "sum("
    		+ "   CASE "  
    		+ "      WHEN voto = 'true' THEN 1"  
    		+ "      ELSE 0" 
    		+ "   END"
    		+ ") votosTrue, "
    		+ "sum("
    		+ "   CASE "  
    		+ "      WHEN voto = 'false' THEN 1"  
    		+ "      ELSE 0" 
    		+ "   END"
    		+ ") votosFalse, "    		
    		+ "   CASE "  
    		+ "      WHEN sv.id_status_sessao_votacao = 1 THEN 'Sessão aberta'"  
    		+ "      ELSE 'Sessão encerrada'" 
    		+ "   END"
    		+ " status "    		
    		+ " from pauta p"
    		+ " inner join sessao_votacao sv on p.id_Pauta=sv.id_Pauta "
    		+ " inner join sessao_votacao_voto svv on svv.id_sessao_votacao=sv.id_sessao_votacao "
    		+ " group by p.nm_pauta,dt_inicio_votacao,dt_final_votacao,sv.id_status_sessao_votacao" 
    		+ " order by sv.dt_inicio_votacao,p.nm_pauta",
    		nativeQuery = true)
    public List<Object[]> findAllOrderByDateIniAndPauta();
    
    public SessaoVotacaoVoto findByNuCpfAndIdSessaoVotacao(long nuCpf,long idSessaoVotacao);
    
}
