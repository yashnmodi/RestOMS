package com.mysquare.restoms.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.mysquare.restoms.model.Menu;
import com.mysquare.restoms.model.MusicDetails;
import com.mysquare.restoms.repository.TableRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice
public class FileUploadController {
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Value("${upload_image_path}")
	private String imagePath;
	
	@Value("${upload_music_path}")
	private String musicPath; 
	
	@Autowired
	private TableRepo tableRepo;
	
	// Usage of path variable
	@RequestMapping(value = "/{path}")
	public String showForm(@PathVariable String path) {
		logger.debug("in show upload form");
		return path;
	}

	// get list of images under the webapp
	@RequestMapping(value = "/list_images")
	public String listImages(Model map, HttpServletRequest request,HttpSession hs) {
		logger.debug("Value of imagePath in method listImages " + imagePath);
		File uploadLocationDir = new File(imagePath);//image path is dir where contents are upoaded
		logger.debug("Is imagePath in method listImages exists ? = " + uploadLocationDir.exists());
		logger.debug("Is imagePath in method listImages directory ? = " + uploadLocationDir.isDirectory());
		logger.debug("Abosulte imagePath in method listImages = " + uploadLocationDir.getAbsolutePath());
		
		ArrayList<Menu> breakfast=new ArrayList<>();
		breakfast=(ArrayList<Menu>) tableRepo.getStarterImages();
		//String[] files = uploadLocationDir.list();
		//System.out.println("files " + Arrays.toString(files));
		logger.debug("image path is:: {}", imagePath);
		logger.debug("list of breakfast is:: {}", breakfast);
		
		hs.setAttribute("path", imagePath);
		hs.setAttribute("breakfast_list",breakfast);
	
		return "list_images";
	}
   
	@RequestMapping(value="/music")
	public String ShowMusic(Model map,HttpSession hs,HttpServletRequest rq)
	{
		 System.out.println("value of musicPath in method ShowMusic = "+musicPath);
		 File uploadLocationDir = new File(musicPath);//image path is dir where contents are upoaded
		 logger.debug("Is musicPath in method ShowMusic exists ? = " + uploadLocationDir.exists());
		 logger.debug("Is musicPath in method ShowMusic directory ? = " + uploadLocationDir.isDirectory());
		 logger.debug("Abosulte musicPath in method ShowMusic = " + uploadLocationDir.getAbsolutePath());
		 List<MusicDetails> musics=new ArrayList<>();
		 musics=tableRepo.getMusics();
		 logger.debug("musics path after is::"+musicPath);
		 logger.debug("list of musics is::"+musics);
		 hs.setAttribute("Music", musics);
		 hs.setAttribute("Path", musicPath);    
		 return "list_images";	
	}
	
	@RequestMapping(value = "/choose")
	public String chooseImage(Model map, @RequestParam String imgName) {
		logger.debug("in choose img name " + imgName);
		map.addAttribute("img_name", imgName);
		return "show_image";
	}
}
