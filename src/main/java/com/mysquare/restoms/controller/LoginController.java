package com.mysquare.restoms.controller;

import com.mysquare.restoms.model.LoginDetails;
import com.mysquare.restoms.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Restaurant")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public String getLogin()
    {
        return "/Restaurant/login";
    }

    @PostMapping("/login")
    public String processloginForm(@RequestParam String uname, @RequestParam String password, HttpSession hs, RedirectAttributes flashMap, Model map)
    {
        try {
            logger.debug("--- inside login ---");
            LoginDetails lD=loginService.getValidRole(uname,password);
            logger.debug("Role of logged in user = " + lD.getRole());

            if(lD.getRole().equalsIgnoreCase("Admin")) {
                hs.setAttribute("admin", lD);
                return "redirect:/Accountant/ProcessAccData";
            } else if(lD.getRole().equalsIgnoreCase("Kitchen")) {
                hs.setAttribute("kitchen", lD);
                return "redirect:/Kitchen/ProcessOrder";
            } else if(lD.getRole().equalsIgnoreCase("Table")) {
                hs.setAttribute("table", lD);
                return "redirect:/Restaurant/Table";
            }
        } catch(Exception e) {
            logger.debug("Exception occurred -- " + e.getMessage());
        }
        map.addAttribute("msg", "Oops! Login Unsuccessful!");
        return "/Restaurant/login";

    }
}
