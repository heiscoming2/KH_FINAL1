package com.itpro.model.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ManageMemberDao;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.admin.ManageMemberDto_com;

@Repository
public class ManageMemberDaoImpl implements ManageMemberDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	//개인회원 + 관리자
	
	@Override
	public List<ManageMemberDto> selectList(String search_option, String keyword) {
		List<ManageMemberDto> list = new ArrayList<ManageMemberDto>();
		
		try {
			list=sqlSession.selectList(NAMESPACE+"selectList");
			System.out.println("list_com dao: "+list );
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
			System.out.println("seletOne: "+ dto);
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
			System.out.println("update: "+res);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		return res;
	}

	
	@Override
	public List<ManageMemberDto> search(String userName) {
		List<ManageMemberDto> userList= new ArrayList<ManageMemberDto>();
		

		try {
			userList=sqlSession.selectList(NAMESPACE+"search");
			System.out.println("userName list dao: "+userList );
		} catch (Exception e) {
			System.out.println("[error] : select userlist");
			e.printStackTrace();
		}
		return userList;
		
	}


	
	
	

	//////////////////////////////기업회원///////////////////////////////////////
	
	@Override
	public List<ManageMemberDto_com> selectList_com() {
		List<ManageMemberDto_com> list_com = new ArrayList<ManageMemberDto_com>();
		
		try {
			list_com=sqlSession.selectList(NAMESPACE+"selectList_com");
			System.out.println("list: "+list_com );
		} catch (Exception e) {
			System.out.println("[error] : select list");
			e.printStackTrace();
		}
		return list_com;
		
	}



	@Override
	public ManageMemberDto_com selectOne_com(int m_no) {
		ManageMemberDto_com dto_com =null;
		
		try {
			dto_com=sqlSession.selectOne(NAMESPACE+"selectOne_com",m_no);
			System.out.println("seletOne: "+ dto_com);
		} catch (Exception e) {
			System.out.println("[error] : select one");
			e.printStackTrace();
		}
		
		return dto_com;
	}



	@Override
	public int update_comA(ManageMemberDto_com dto) {
		int res_comA=0;
		System.out.println("DAO: "+dto.getM_act());
		try {
			res_comA=sqlSession.update(NAMESPACE+"update_comA",dto);
			System.out.println("update: "+res_comA);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		return res_comA;
	}


	@Override
	public int update_comB(ManageMemberDto_com dto) {
		int res_comB=0;
		
		try {
			res_comB=sqlSession.update(NAMESPACE+"update_comB",dto);
			System.out.println("update: "+res_comB);
		} catch (Exception e) {
			System.out.println("[error] : update");
			e.printStackTrace();
		}
		return res_comB;
	}



	
}
