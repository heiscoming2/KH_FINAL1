package com.itpro.model.bizImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.ManageMemberBiz;
import com.itpro.model.dao.ManageMemberDao;
import com.itpro.model.dto.admin.ManageMemberDto;

@Service
public class ManageMemberBizImpl implements ManageMemberBiz{

	@Autowired
	private ManageMemberDao dao;

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

	
	


}
