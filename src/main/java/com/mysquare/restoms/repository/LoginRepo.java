package com.mysquare.restoms.repository;

import com.mysquare.restoms.model.LoginDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends CrudRepository<LoginDetails, Long> {

	@Query("select l from LoginDetails l where l.uname= ?1 and l.password= ?2")
	public LoginDetails getValidRoleDao(String uname, String password);
}
