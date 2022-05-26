package com.mysquare.restoms.service;

import java.util.List;

import com.mysquare.restoms.model.CustomerDetails;
import com.mysquare.restoms.repository.AccountantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KitchenService {

	@Autowired
	private AccountantRepo accountantRepo;

	public String setPlaceOrderFlag(String tid)
	{
		accountantRepo.setPlaceOrderFlag(tid);
		return "Your order has been placed successfully! Please wait for sometime.";
	}

	public String setPaidFlag(String tid)
	{
		accountantRepo.setPaidFlag(tid);
		return "Payment done!";
	}
	
	public List<CustomerDetails> ProcessOrderService()
	{
		List<CustomerDetails> cust = accountantRepo.getProcessOrderDao();
		return cust; 
	}

	public String deleteOrderFromKitchenService(int oid)
	{
		accountantRepo.deleteFromKitchenDao(oid);
		return "Order Prepared Successfully!";
	}

	public List<CustomerDetails> getBillService(String tid)
	{
		System.out.println("called --- getBillService");
		return accountantRepo.getBillDao(tid);
	}
}
