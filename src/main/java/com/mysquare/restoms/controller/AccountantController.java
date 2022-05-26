package com.mysquare.restoms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.mysquare.restoms.model.CustomerDetails;
import com.mysquare.restoms.model.CustomerDetailsReplica;
import com.mysquare.restoms.model.LoginDetails;
import com.mysquare.restoms.model.Menu;
import com.mysquare.restoms.service.AccountantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/Accountant")
public class AccountantController {

	private static Logger logger = LoggerFactory.getLogger(AccountantController.class);
	
	@Autowired
	private AccountantService ac;
	
	@GetMapping("/Acc")
	public String Acc(HttpServletRequest rq,HttpSession hs) {
		LoginDetails ld=(LoginDetails)hs.getAttribute("admin");
		if(ld.getRole().equals("Admin")){
			return "redirect:/Accountant/ProcessAccData";
		}
		return "redirect:/Restaurant/login";
	}
	
	@GetMapping("/ProcessAccData")
	public String ProcessAccData(HttpSession hs) {
		logger.debug("----- inside route=ProcessAccData -----");
		LoginDetails ld=(LoginDetails)hs.getAttribute("admin");
		if(ld.getRole().equalsIgnoreCase("Admin"))
		{
			List<CustomerDetails> custDetails=ac.getCurrentCustDetails();
			List<CustomerDetailsReplica> custReplicaDetails =ac.getCustReplicaDetails();
			/*List<OrderDetails> order=ac.getOrderDetails(); */
			logger.debug("in ProcessAccData - accountant - {}", custReplicaDetails);
			hs.setAttribute("CustReplica",custReplicaDetails);
			hs.setAttribute("custlist",custDetails);
			/*hs.setAttribute("Order",order);*/
			return "/Accountant";
		}
		return "redirect:/Restaurant/login";
	}
	
	@GetMapping("/AddMenu")
	public String AddMenu(@RequestParam String menuName,@RequestParam double price,@RequestParam String category ,@RequestParam String specification,HttpSession hs) {
		logger.debug("----- inside route=AddMenu -----");
		LoginDetails ld=(LoginDetails)hs.getAttribute("admin");
		if(ld.getRole().equalsIgnoreCase("Admin")) {
			ac.addMenuDetailsService(new Menu(menuName,price,category,specification));
			return "/Accountant/ProcessAccData";
		}
		return "redirect:/Restaurant/login";
	}
	
	@GetMapping("/AddTable")
	public String AddTable(@RequestParam String tableName,@RequestParam String pwd,@RequestParam String role,HttpSession hs) {
		logger.debug("----- inside route=AddTable -----");
		LoginDetails ld=(LoginDetails)hs.getAttribute("admin");
		if(ld.getRole().equalsIgnoreCase("Admin")) {
			logger.info("addNewTable | tableName - {} pwd - {}", tableName, pwd);
			try {
				ac.addNewTable(new LoginDetails(tableName,pwd,role));
			}catch (Exception e) {
				logger.error("Unable to add new table.");
				e.printStackTrace();
			}
			return "redirect:/Accountant/ProcessAccData";
		}
		return "redirect:/Restaurant/login";
	}
}