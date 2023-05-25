package com.study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.study.dto.Cust;
import com.study.frame.MyMapper;

@Mapper
@Repository
public interface CustMapper extends MyMapper<String, Cust>{

}
