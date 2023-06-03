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

	@RequestMapping("/getmarker2")
	public Object getmarker2(String loc) {
		JSONArray ja=new JSONArray();
		
		if(loc.equals("s")) {
			JSONObject jo1=new JSONObject();
			jo1.put("title", "국밥집");
			jo1.put("target", "http://www.naver.com");
			jo1.put("lat", 37.5286891);
			jo1.put("lng", 127.061432);
			jo1.put("img", "b01.jpg");
			ja.add(jo1);
			
			JSONObject jo2 = new JSONObject();
			jo2.put("title", "짬뽕집");
			jo2.put("target", "http://www.daum.net");
			jo2.put("lat", 37.5386891);
			jo2.put("lng", 127.021432);
			jo2.put("img", "b02.jpg");
			ja.add(jo2);
			
			JSONObject jo3 = new JSONObject();
			jo3.put("title", "닭발집");
			jo3.put("target", "http://www.google.com");
			jo3.put("lat", 37.5186891);
			jo3.put("lng", 127.031432);
			jo3.put("img", "b03.jpg");
			ja.add(jo3);
		}else if(loc.equals("b")) {
            
			JSONObject jo1 = new JSONObject();
			jo1.put("title", "국밥집");
			jo1.put("target", "http://www.naver.com");
			jo1.put("lat", 35.1233984);
			jo1.put("lng", 129.0906448);
			jo1.put("img", "b01.jpg");
			ja.add(jo1);
			
			JSONObject jo2 = new JSONObject();
			jo2.put("title", "짬뽕집");
			jo2.put("target", "http://www.daum.net");
			jo2.put("lat", 35.1243984);
			jo2.put("lng", 129.0936448);
			jo2.put("img", "b02.jpg");
			ja.add(jo2);
			
			JSONObject jo3 = new JSONObject();
			jo3.put("title", "닭발집");
			jo3.put("target", "http://www.google.com");
			jo3.put("lat", 35.1253984);
			jo3.put("lng", 129.0966448);
			jo3.put("img", "b03.jpg");
			ja.add(jo3);
		}else if(loc.equals("j")) {
			
			JSONObject jo1 = new JSONObject();
			jo1.put("title", "국밥집");
			jo1.put("target", "http://www.naver.com");
			jo1.put("lat", 33.5239183);
			jo1.put("lng", 126.6162571);
			jo1.put("img", "b01.jpg");
			ja.add(jo1);
			
			JSONObject jo2 = new JSONObject();
			jo2.put("title", "짬뽕집");
			jo2.put("target", "http://www.daum.net");
			jo2.put("lat", 33.5119183);
			jo2.put("lng", 126.6252571);
			jo2.put("img", "b02.jpg");
			ja.add(jo2);
			
			JSONObject jo3 = new JSONObject();
			jo3.put("title", "닭발집");
			jo3.put("target", "http://www.google.com");
			jo3.put("lat", 33.5109183);
			jo3.put("lng", 126.6242571);
			jo3.put("img", "b03.jpg");
			ja.add(jo3);
		};
		
		
		return ja;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
