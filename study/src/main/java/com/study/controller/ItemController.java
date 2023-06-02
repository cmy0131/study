package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.dto.Item;
import com.study.frame.ImgUtil;
import com.study.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	String dir="item/";
	
	@Value("${custdir}")
	String custdir;
	
	@Autowired
	ItemService iservice;
	
	@RequestMapping("")
	public String main(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		return "main";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"add");
		return "main";
	}
	
	@RequestMapping("/getall")
	public String getall(Model model) {
		List<Item> list=null;
		try {
			list=iservice.get();
			model.addAttribute("plist", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("center", dir+"getall");
		model.addAttribute("left", dir+"left");
		return "main";
	}
	
	@RequestMapping("/get")
	public String get(Model model, int id) {
		Item item=null;
		try {
			item=iservice.get(id);
			model.addAttribute("obj", item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("center", dir+"get");
		model.addAttribute("left", dir+"left");
		
		return "main";
	}
	
	@RequestMapping("/register")
	public String register(Model model, Item item) {
	
		String imgname=item.getImg().getOriginalFilename();
		item.setImgname(imgname);
		
		try {
			ImgUtil.saveFile(item.getImg(), custdir);
			iservice.register(item);
			model.addAttribute("center", dir+"registerok");
		} catch (Exception e) {
			model.addAttribute("center", dir+"registerok");
			e.printStackTrace();
		}
		
		model.addAttribute("left", dir+"left");
		
		return "main";
	}
	
	@RequestMapping("/update")
	public String update(Model model, Item item) {
		String imgname=item.getImg().getOriginalFilename();
		if(imgname.equals("") || imgname==null) {
			try {
				iservice.modify(item);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			imgname=item.getImg().getOriginalFilename();
			item.setImgname(imgname);
			try {
				iservice.modify(item);
				ImgUtil.saveFile(item.getImg(), custdir);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
		
		model.addAttribute("left", dir+"left");
		model.addAttribute("center", dir+"center");
		
		return "redirect:get?id="+item.getId();
	}
	
	@RequestMapping("/delete")
	public String delete(Model model, int id) {
		try {
			iservice.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:getall";
	}
}














