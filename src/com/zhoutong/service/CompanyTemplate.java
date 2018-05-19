package com.zhoutong.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhoutong.dao.CompanyDao;
import com.zhoutong.model.Company;

@Service("companyService")
public class CompanyTemplate implements CompanyDao{
	
	@Resource(name="companyDao")
	public CompanyDao companyDao;

	public List<Company> getC(String coname_) {
		return companyDao.getC(coname_);
	}

}