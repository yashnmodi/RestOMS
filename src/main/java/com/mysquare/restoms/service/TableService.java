package com.mysquare.restoms.service;

import java.time.LocalDateTime;
import java.util.List;
import com.mysquare.restoms.model.*;
import com.mysquare.restoms.repository.AccountantRepo;
import com.mysquare.restoms.repository.OrderDetailsRepo;
import com.mysquare.restoms.repository.TableRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TableService {

	private static Logger logger = LoggerFactory.getLogger(TableService.class);

	@Autowired
	public TableRepo tableRepo;

	@Autowired
	public OrderDetailsRepo odr;

	@Autowired
	private AccountantRepo accountantRepo;

	public List<Menu> getMainRotiImages()
	{
		logger.debug("in tableservice roti");
		List<Menu> Roti= tableRepo.getRotiImages();
		return Roti;
	}
	public List<Menu> getMainSabjiImages()
	{
		logger.debug("in tableservice sabji");
		List<Menu> Sabji= tableRepo.getSabjiImages();
		return Sabji;
	}
	
	public List<Menu> getMainRiceImages()
	{
		logger.debug("in tableservice rice");
		List<Menu> Rice= tableRepo.getRiceImages();
		return Rice;
	}
	
	public List<Menu> getMainSoupImages()
	{
		logger.debug("in tableservice soup");
		List<Menu> Soup= tableRepo.getSoupImages();
		return Soup;
	}
	
	public List<Menu> getStarterImages()
	{
		logger.debug("in service papad");
		List<Menu> starter= tableRepo.starterImagesDao();
		return starter;
		 
	}
	
	public List<Menu> getDessertImages()
	{

		logger.debug("in service dessert");
		List<Menu> dessert= tableRepo.dessertImagesDao();
		return dessert;
		
	}
	public List<Menu> getmainParathaImages()
	{
		logger.debug("in service paratha");
		List<Menu> paratha= tableRepo.parathaImagesDao();
		return paratha;
	}
	
	public List<Menu> getBreakfastImages()
	{
		logger.debug("in service breakfast");
		List<Menu> breakfast= tableRepo.breakfastImagesDao();
		return breakfast;
	}

	@Transactional
	public String insertMenuData(String tid, int mid, int qty) {
		Menu menu = tableRepo.fetchMenuData(mid).get(0);
		CustomerDetails customer = new CustomerDetails();
		customer.setTableNo(tid);
		customer.setItem(menu.getItem());
		customer.setPrice(menu.getPrice());
		customer.setQuantity(qty);
		customer.setPaid(0);
		customer.setOrderSubmit(0);
		customer.setOrderFlag(0);
		accountantRepo.save(customer);
		int orderId = accountantRepo.findFirstByTableNoOrderByOrderIdDesc(tid).getOrderId();
		OrderDetails order = new OrderDetails();
		order.setOrderId(orderId);
		order.setBill((double) menu.getPrice()*qty);
		LocalDateTime ldt = LocalDateTime.now();
		order.setBillDate(ldt);
		odr.save(order);
		return "true";
	}
	
	public List<CustomerDetails> getOrderData(String tableid)
	{
		List<CustomerDetails> custOrder= accountantRepo.getOrderDataDao(tableid);
		return custOrder;
	}

	public String deleteByOid(String tid,int oid)
	{
		accountantRepo.deleteCustbyOid(tid,oid);
		return "deleted";
	}
	
	public List<MusicDetails> getMusics()
	{
		return tableRepo.getMusics();
	}
	public List<MovieDetails> getMovie()
	{
		return tableRepo.getMovieDao();
	}
}
