package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.dto.Cust;
import com.study.frame.MyService;
import com.study.mapper.CustMapper;

@Service
public class CustService implements MyService<String, Cust> {
	
	@Autowired
	CustMapper mapper;

	@Override
	public void register(Cust v) throws Exception {
		mapper.insert(v);
		
	}

	@Override
	public void remove(String k) throws Exception {
		mapper.delete(k);
		
	}

	@Override
	public void modify(Cust v) throws Exception {
		mapper.update(v);
		
	}

	@Override
	public Cust get(String k) throws Exception {
		return mapper.select(k);
	}

	@Override
	public List<Cust> get() throws Exception {
		return mapper.selectall();
	}
	
	
	
}
