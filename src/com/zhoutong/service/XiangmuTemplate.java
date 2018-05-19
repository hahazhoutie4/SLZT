package com.zhoutong.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zhoutong.dao.XiangmuDao;
import com.zhoutong.model.Xiangmu;

@Service("xiangmuService")
public class XiangmuTemplate  implements XiangmuDao{
	
	@Resource(name="xiangmuDao")
	public XiangmuDao xiangmuDao;
	
	public Xiangmu getX(String name,String password) {
		return xiangmuDao.getX(name,password);
	}
	
}
