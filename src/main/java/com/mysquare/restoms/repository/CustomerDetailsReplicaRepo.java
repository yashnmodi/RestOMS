package com.mysquare.restoms.repository;

import com.mysquare.restoms.model.CustomerDetailsReplica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDetailsReplicaRepo extends CrudRepository<CustomerDetailsReplica, Long> {

    @Query("select c from CustomerDetailsReplica c")
    public List<CustomerDetailsReplica> getCustReplicaDetailsDao();
}
