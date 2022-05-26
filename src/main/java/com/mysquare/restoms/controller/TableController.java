package com.mysquare.restoms.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import com.mysquare.restoms.model.*;
import com.mysquare.restoms.service.TableService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/Restaurant")
public class TableController {
	
	private static Logger logger = LoggerFactory.getLogger(TableController.class);
	
	//Dependency Injection of image path
	@Value("${upload_image_path}")
	private String imagePath;

	@Value("${upload_music_path}")
	private String musicPath;

	@Value("${upload_movie_path}")
	private String moviePath;

	@Autowired
	public TableService ts;

	@GetMapping("/Table")
	public String ProcessTableData(HttpSession hs) {
		logger.debug("----- Route=Table -----");
		logger.debug("Value of upload_image_path = {}", imagePath);
		LoginDetails ld=(LoginDetails)hs.getAttribute("table");
		if(ld.getRole().equalsIgnoreCase("Table")) {
//			File uploadLocationDir = new File(imagePath);
//
//			logger.debug("Is imagePath exists ? = {}", uploadLocationDir.exists());
//			logger.debug("Is imagePath directory ? = {}", uploadLocationDir.isDirectory());
//			logger.debug("Absolute imagePath = {}", uploadLocationDir.getAbsolutePath());

			List<Menu> breakfast = new ArrayList<>();
			breakfast = (ArrayList<Menu>) ts.getBreakfastImages();
			logger.debug("List of Breakfast :: {}", breakfast);

			List<Menu> starterSoup = new ArrayList<>();
			starterSoup = (ArrayList<Menu>) ts.getMainSoupImages();
			logger.debug("List of Soup :: {}",starterSoup);

			List<Menu> starter = new ArrayList<>();
			starter = (ArrayList<Menu>) ts.getStarterImages();

			List<Menu> mainRoti = new ArrayList<>();
			mainRoti = (ArrayList<Menu>) ts.getMainRotiImages();
			logger.debug("List of Roti :: {}",mainRoti);

			List<Menu> mainParatha = new ArrayList<>();
			mainParatha = (ArrayList<Menu>) ts.getmainParathaImages();

			List<Menu> mainSabji = new ArrayList<>();
			mainSabji=(ArrayList<Menu>) ts.getMainSabjiImages();

			List<Menu> mainRice = new ArrayList<>();
			mainRice = (ArrayList<Menu>) ts.getMainRiceImages();

			List<Menu> dessert = new ArrayList<>();
			dessert = (ArrayList<Menu>) ts.getDessertImages();

			ArrayList<CustomerDetails> orderData=new ArrayList<>();
			orderData=(ArrayList<CustomerDetails>)ts.getOrderData(ld.getUname());

			hs.setAttribute("breakfastImages", breakfast);
			hs.setAttribute("soupImages", starterSoup);
			hs.setAttribute("starterImages", starter);
			hs.setAttribute("rotiImages", mainRoti);
			hs.setAttribute("parathaImages", mainParatha);
			hs.setAttribute("sabjiImages", mainSabji);
			hs.setAttribute("riceImages", mainRice);
			hs.setAttribute("dessertImages", dessert);
			hs.setAttribute("order", orderData);

			//Load Music
			File uploadLocationDirm = new File(musicPath);//music path is dir where contents are uploaded

			logger.debug("Is musicPath exists ? = {}", uploadLocationDirm.exists());
			logger.debug("Is musicPath directory ? ={}", uploadLocationDirm.isDirectory());
			logger.debug("Absolute musicPath = {}", uploadLocationDirm.getAbsolutePath());

			List<MusicDetails> musics=new ArrayList<>();
			musics=ts.getMusics();
			logger.debug("musics path after is::{}",musicPath);
			logger.debug("list of musics is::{}",musics);
			hs.setAttribute("Music", musics);
			hs.setAttribute("Path", musicPath);

			//Load Movie
			File uploadLocationDirmovie=new File(moviePath);

			logger.debug("Is moviePath exists ? ={}", uploadLocationDirmovie.exists());
			logger.debug("Is moviePath directory ? = {}", uploadLocationDirmovie.isDirectory());
			logger.debug("Absolute moviePath = {}", uploadLocationDirmovie.getAbsolutePath());

			List<MovieDetails> movie=new ArrayList<>();
			movie=ts.getMovie();
			hs.setAttribute("Movie", movie);
			hs.setAttribute("MoPath", moviePath);

			return "/Restaurant/Table";
		}
		return "redirect:/Restaurant/login";
	}

	@GetMapping("/ProcessOrder")
	public String ProcessOrderData(@RequestParam String tid,@RequestParam int mid,@RequestParam String qty,HttpSession hs,RedirectAttributes flashMap) {
		LoginDetails ld=(LoginDetails)hs.getAttribute("table");
		if(ld.getRole().equals("Table")) {
			if(!qty.equals("")) {
				logger.debug("Table ID = {} | mid = {}", tid, mid);
				String s=ts.insertMenuData(tid, mid, Integer.parseInt(qty));
			} else {
				flashMap.addFlashAttribute("notselectedmenu", "Please select quantity!");
			}
			return "redirect:/Restaurant/Table";
		}
		return "redirect:/Restaurant/login";
	}

	@GetMapping("/DeleteOrderByOrderId")
	public String DeleteOrderByOrderId(@RequestParam String tid,@RequestParam int oid,HttpSession hs) {
		LoginDetails ld=(LoginDetails)hs.getAttribute("table");
		if(ld.getRole().equals("Table")) {
			String msg=null;
			try {
				msg=ts.deleteByOid(tid,oid);
			}catch (Exception e) {
				msg="failure";
			}
			return "redirect:/Restaurant/Table";
		}
		return "redirect:/Restaurant/login";
	}
}