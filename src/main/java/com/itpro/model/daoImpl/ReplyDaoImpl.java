package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;

@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ReplyListDto> selectList(int bd_no) {
		List<ReplyListDto> replyList = null;
		try {
			replyList = sqlSession.selectList(NAMESPACE+"selectList",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyList;
	}

	@Override
	public int replyCnt(int bd_no) {
		int replyCnt = 0;
		try {
			replyCnt = sqlSession.selectOne(NAMESPACE+"replyCnt", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(replyCnt);
		return replyCnt;
	}

	@Override
	public int insert(ReplyInsertDto replyInsertDto) {
		int replyInsertRes = 0;
		try {
			replyInsertRes = sqlSession.insert(NAMESPACE+"insert",replyInsertDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyInsertRes;
	}

	@Override
	public int update(ReplyUpdateDto replyUpdateDto) {
		
		int replyUpdateRes = 0;
		try {
			replyUpdateRes = sqlSession.update(NAMESPACE+"update",replyUpdateDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyUpdateRes;
	}

	@Override
	public int delete(int re_no) {
		
		int replyDeleteRes = 0;
		try {
			replyDeleteRes = sqlSession.delete(NAMESPACE+"delete",re_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replyDeleteRes;
	}
}
