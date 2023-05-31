package com.study.cust;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.dto.Cust;
import com.study.service.CustService;

@SpringBootTest
class InsertTests {

	@Autowired
	CustService cservice;
	
	@Test
	void contextLoads() {
		Cust cust=new Cust("id00", "pwd00", "james");
		
		try {
			cservice.register(cust);
			System.out.print("OK");
		} catch (Exception e) {
			System.out.print("Fail");
			e.printStackTrace();
		}
		
	}
}
