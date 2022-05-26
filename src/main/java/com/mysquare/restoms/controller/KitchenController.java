package com.mysquare.restoms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysquare.restoms.model.CustomerDetails;
import com.mysquare.restoms.model.LoginDetails;
import com.mysquare.restoms.service.KitchenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/Kitchen")
public class KitchenController {
	
	private static Logger logger = LoggerFactory.getLogger(KitchenController.class);
	
	@Autowired
	private KitchenService ks;
	
	@GetMapping("/placeOrderOrGetBill")				//being called from table.jsp - place order btn or get bill btn
	public String placeOrderOrGetBill(@RequestParam String tid, @RequestParam String button, Model map, HttpServletResponse rs, HttpServletRequest rq, HttpSession hs, RedirectAttributes flashMap) {
		logger.debug("----- inside route=placeOrderOrGetBill -----");
		LoginDetails ld=(LoginDetails)hs.getAttribute("table");
		if(ld.getRole().equalsIgnoreCase("Table")) {
			logger.debug("inside placeOrderOrGetBill - button - {} ", button);
			if(button.equals("Place an Order")) {
				logger.debug("kitchen"+tid);
				String placeOrderMsg=ks.setPlaceOrderFlag(tid);
				logger.debug("msg:: {}", placeOrderMsg);
				flashMap.addFlashAttribute("placeOrderMsg",placeOrderMsg);
				map.addAttribute("placeOrderMsg", placeOrderMsg);
				return "redirect:/Restaurant/Table";
			} else if(button.equals("Get Bill")) {
				double totBill=0.0;
				List<CustomerDetails> li=ks.getBillService(tid);
				for(CustomerDetails cust:li) {
					totBill+=cust.getPrice();
				}
				map.addAttribute("bill",totBill);
				map.addAttribute("Cust",li);
                String paidMsg =ks.setPaidFlag(tid);
                flashMap.addFlashAttribute("placeOrderMsg",paidMsg);
                map.addAttribute("placeOrderMsg", paidMsg);
				rs.setHeader("refresh", "5;url="+rq.getContextPath()+"/Restaurant/Table");
				return "/Restaurant/Bill";
			}
		}
		return "redirect:/Restaurant/login";
	}
	
	@GetMapping("/ProcessOrder")					//being called from table.jsp - add to cart
	public String ProcessOrderInKitchen(HttpSession hs) {
		logger.debug("----- inside route=ProcessOrder -----");
		LoginDetails ld=(LoginDetails)hs.getAttribute("kitchen");
		if(ld.getRole().equalsIgnoreCase("Kitchen")) {
			logger.debug("in kitchen process order");
			List<CustomerDetails> cust=ks.ProcessOrderService();
			hs.setAttribute("OrderList", cust);
			return "/Kitchen";
		}
		return "redirect:/Restaurant/login";
	}

	@GetMapping("/deleteOrderFromKitchen")             //being called from kitchen.jsp - Ready
	public String deleteOrderFromKitchen(@RequestParam int oid,HttpSession hs, Model map, RedirectAttributes flashMap) {
		logger.debug("----- inside route=deleteOrderFromKitchen -----");
		LoginDetails ld=(LoginDetails)hs.getAttribute("kitchen");
		if(ld.getRole().equalsIgnoreCase("Kitchen")) {
			logger.debug("in delete from kitchen");
			String msg=ks.deleteOrderFromKitchenService(oid);
			flashMap.addFlashAttribute("orderPrepared",msg);
			map.addAttribute("orderPrepared", msg);
			return "redirect:/Kitchen/ProcessOrder";
		}
		return "redirect:/Restaurant/login";
	}
}
