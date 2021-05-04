package com.itpro.model.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ManageMemberDao;
<<<<<<< HEAD
import com.itpro.model.dao.QnaDao;
=======
>>>>>>> e9448abb9498f01a69b4d0bf1574638569e52cd9
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.qna.QnaDto;

@Repository
public class ManageMemberDaoImpl implements ManageMemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ManageMemberDto> selectList() {
		List<ManageMemberDto> list = new ArrayList<ManageMemberDto>();
		
		try {
			list=sqlSession.selectList(NAMESPACE+"selectList");
		} catch (Exception e) {
			System.out.println("[error] : select list");
			e.printStackTrace();
		}
		return list;
	}
	
	

	@Override
	public ManageMemberDto selectOne(int m_no) {
		ManageMemberDto dto =null;
		
		try {
			dto=sqlSession.selectOne(NAMESPACE+"selectOne",m_no);
		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}
		
		return dto;
	}


	@Override
	public int update(ManageMemberDto dto) {
		int res=0;
		
		try {
			res=sqlSession.update(NAMESPACE+"update",dto);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		return res;
	}





}
