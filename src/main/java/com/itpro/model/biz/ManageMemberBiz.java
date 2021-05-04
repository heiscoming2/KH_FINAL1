package com.itpro.model.biz;

import java.util.List;

import com.itpro.model.dto.admin.ManageMemberDto;

public interface ManageMemberBiz {

	public static List<ManageMemberDto> selectList() {
		// TODO Auto-generated method stub
		return null;
	}
	public ManageMemberDto selectOne(int m_no);
	public int update();

}
