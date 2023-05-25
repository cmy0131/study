package com.study.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.Cust;
import com.study.dto.Rank;
import com.study.service.CustService;

@RestController
public class AController {
	
	@Autowired
	CustService cservice;
	
	@RequestMapping("/time")
	public Object time() {
		Date data=new Date();
		return data.toString();
	}
	
	@RequestMapping("/cnt")
	public Object cnt() {
		Random r=new Random();
		int i=r.nextInt(100);
		return i;
	}
	
	@RequestMapping("/rank")
	public Object rank() {
		List<Rank> list=new ArrayList<Rank>();
		list.add(new Rank(1,"전쟁","u"));
		list.add(new Rank(2,"경제","d"));
		list.add(new Rank(3,"드라마","u"));
		list.add(new Rank(4,"k-pop","d"));
		list.add(new Rank(5,"새해인사","u"));
		
		JSONArray ar=new JSONArray();
		
		for(Rank r:list) {
			JSONObject obj=new JSONObject();
			obj.put("rank", r.getRank());
			obj.put("title", r.getTitle());
			obj.put("updown", r.getUpdown());
			ar.add(obj);
		}
		
		return ar;
		
	}
	
	@RequestMapping("/checkid")
	public Object checkid(String cid) {
		int result=0;
		Cust cust=null;
		
		try {
			cust=cservice.get(cid);
			if(cust==null) {
				result=1;
			}else {
				result=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
