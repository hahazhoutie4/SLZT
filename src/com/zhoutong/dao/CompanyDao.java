package com.zhoutong.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import com.zhoutong.model.Company;

@MapperScan
@Repository(value="companyDao")
public interface CompanyDao {
	
	public List<Company> getC(String coname_);
	
}