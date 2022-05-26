package com.mysquare.restoms.service;

import java.util.List;

import com.mysquare.restoms.model.*;
import com.mysquare.restoms.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountantService {

	@Autowired
	private AccountantRepo accountantRepo;

	@Autowired
	private LoginRepo loginRepo;

	@Autowired
	private TableRepo tableRepo;

	@Autowired
	private CustomerDetailsReplicaRepo cdrr;

	@Autowired
	private OrderDetailsRepo odr;

	public List<CustomerDetails> getCurrentCustDetails() {
		return accountantRepo.getCurrentCustDetailsDao();
	}

	public List<CustomerDetailsReplica> getCustReplicaDetails() {
		return cdrr.getCustReplicaDetailsDao();
	}

	public List<OrderDetails> getOrderDetails() {
		return odr.getOrderDetailsDao();
	}
	
	@Transactional
	public void addMenuDetailsService(Menu m) {
		tableRepo.save(m);
	}

	@Transactional
	public void addNewTable(LoginDetails ld) {
		loginRepo.save(ld);
	}
}
