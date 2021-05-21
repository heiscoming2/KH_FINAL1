package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.dao.ManageMemberDao;
import com.itpro.model.dto.admin.ManageMemberDto;
import com.itpro.model.dto.admin.ManageMemberDto_com;

@Service
public class ManageMemberBizImpl implements ManageMemberBiz{

	@Autowired
	private ManageMemberDao dao;

	
		//개인회원 + 관리자
	@Override
	public List<ManageMemberDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ManageMemberDto selectOne(int m_no) {
		return dao.selectOne(m_no);
	}

	@Override
	public int update(ManageMemberDto dto) {
		return dao.update(dto);
	}

	
		//기업회원
	@Override
	public List<ManageMemberDto_com> selectList_com() {
		System.out.println("list_com biz");
		return dao.selectList_com();
	}

	@Override
	public ManageMemberDto_com selectOne_com(int m_no) {
		return dao.selectOne_com(m_no);
	}

	@Override
	@Transactional
	public int update_com(ManageMemberDto_com dto) {
		int res=0;
		int memberDtoAResA=dao.update_comA(dto);
		int memberDtoAResB=dao.update_comB(dto);
		if(memberDtoAResA>0 && memberDtoAResB>0) {
			res=1;
		}
		
		return res;
	}

	

}
