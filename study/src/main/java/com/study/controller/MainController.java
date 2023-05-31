package com.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.Cust;
import com.study.service.CustService;

@Controller
public class MainController {

	@Autowired
	CustService cservice;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("center", "login");
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session!=null) {
			session.invalidate();
		}
		return "main";
	}
	
	@RequestMapping("loginimpl")
	public String loginimpl(Model model, HttpSession session, String id, String pwd) {
		Cust cust=null;
		String result="loginfail";
		try {
			cust=cservice.get(id);
			if(cust!=null) {
				if(cust.getPwd().equals(pwd)) {
					//성공
					result="loginok";
					session.setAttribute("logincust", cust);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("center", result);
		
		return "main";
	}
}
