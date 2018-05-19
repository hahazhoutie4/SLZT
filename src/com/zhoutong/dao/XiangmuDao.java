package com.zhoutong.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.zhoutong.model.Xiangmu;

@MapperScan
@Repository(value="xiangmuDao")
public interface XiangmuDao {
	/**
	 * @param name_	 more than one Parameter must add annotation  @Param("???") or Throw an exception
	 * @param pwd_   more than one Parameter must add annotation  @Param("???") or Throw an exception
	 */
	public Xiangmu getX(@Param("name_")String name_,@Param("pwd_")String pwd_);
}