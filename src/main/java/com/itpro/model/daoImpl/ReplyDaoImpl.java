package com.itpro.model.daoImpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ReplyDao;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
}
