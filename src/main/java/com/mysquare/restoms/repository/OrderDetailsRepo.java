package com.mysquare.restoms.repository;

import com.mysquare.restoms.model.OrderDetails;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailsRepo extends CrudRepository<OrderDetails, Long> {

    @Query("select o from OrderDetails o")
    public List<OrderDetails> getOrderDetailsDao();
}
