package com.itpro.model.daoImpl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dto.member.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 회원탈퇴
	@Override
	public String deleteMember(String m_id) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "memberDelete", m_id);

		} catch (Exception e) {
			System.out.println("[error]:memberDelete");
			e.printStackTrace();
		}

		return Integer.toString(res);
	}

	// 탈퇴 아이디 체크
	@Override
	public boolean checkPw(String m_id, String m_pw) {
		boolean res = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("m_id", m_id);
		map.put("m_pw", m_pw);
		int count = sqlSession.selectOne(NAMESPACE + "checkPw", map);
		if (count == 1) {
			res = true;
		}
		return res;
	}
	
	// 회원정보 조회
		@Override
		public MemberDto selectOne(int m_no) {
			MemberDto updateDto = null;

			try {
				updateDto = sqlSession.selectOne(NAMESPACE + "selectOne", m_no);

			} catch (Exception e) {
				System.out.println("[error] : select one");
				e.printStackTrace();
			}

			return updateDto;
		}


}
