package org.sicredi.repository;

import java.util.List;

import org.sicredi.entity.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserApp, Integer>{

	public UserApp findByNuCpf(long nuCpf);
	
	public List<UserApp> findAll();
	
}
