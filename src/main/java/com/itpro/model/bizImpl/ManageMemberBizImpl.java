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
	private ManageMemberDao ManageMemberDaoImpl;

	@Override
	public List<ManageMemberDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManageMemberDto selectOne(int m_no) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	


}
