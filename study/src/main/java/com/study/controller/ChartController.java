package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class ChartController {

	String dir="chart/";
	
	@RequestMapping("")
	public String chart(Model model) {
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		
		return "main";
	}
	
	@RequestMapping("/ch1")
	public String ch1(Model model) {
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch1");
		
		return "main";
	}
	
	@RequestMapping("/ch2")
	public String ch2(Model model) {
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch2");
		
		return "main";
	}
	
	@RequestMapping("/ch3")
	public String ch3(Model model) {
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch3");
		
		return "main";
	}
	
	@RequestMapping("/ch4")
	public String ch4(Model model) {
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"ch4");
		
		return "main";
	}
	
	
	
}
