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
		int replycnt = 0;
		try {
			replycnt = sqlSession.selectOne(NAMESPACE+"replyCnt", bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return replycnt;
	}

	@Override
	public int insert(ReplyInsertDto replyInsertDto) {
		
		if(replyInsertDto.getRe_parentno()==0) {
			int res = 0;
			try {
				res = sqlSession.insert(NAMESPACE+"insert",replyInsertDto);
				return res;
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}
		return 0;
	}

	@Override
	public int update(ReplyUpdateDto replyUpdateDto) {
		
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"update",replyUpdateDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(int re_no) {
		
		int res = 0;
		try {
			res = sqlSession.delete(NAMESPACE+"delete",re_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateOrder(int re_parentno) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"updateorder",re_parentno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int childrenCheck(int re_no) {
		int res = 0;
		try {
			res = sqlSession.selectOne(NAMESPACE+"childrenchk",re_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int updateHidden(int re_no) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"updatehidden",re_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int deleteWithBoard(int bd_no) {
		int res = 0;
		try {
			res = sqlSession.delete(NAMESPACE+"deletewithboard",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int lastsiblingno(int re_parentno) {
		
		int lastsiblingno = 0;
		try {
			lastsiblingno = sqlSession.selectOne(NAMESPACE+"lastsibling",re_parentno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastsiblingno;
	}
	
	@Override
	public int updateOrderBigThanParent(int re_parentno) {
		
		int res = 0;
		System.out.println("re_parentno : "+re_parentno);
		try {
			res = sqlSession.update(NAMESPACE+"updateOrderBigThanParent",re_parentno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int insertUnderParent(ReplyInsertDto replyInsertDto) {
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"insertUnderParent",replyInsertDto);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return res;
	}

	@Override
	public int getLastChildrenNo(int lastchildrenno) {
		int myupperno = 0;
		try {
			myupperno = sqlSession.selectOne(NAMESPACE+"getLastChildrenNo",lastchildrenno);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return myupperno;
	}

	@Override
	public int updateOrderBigThanMyUpper(int myupperno) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE+"updateOrderBigThanMyUpper",myupperno);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return res;
	}

	@Override
	public int insertUnderSiblingChildren(ReplyInsertDto replyInsertDto) {
		int res =0;
		try {
			res = sqlSession.insert(NAMESPACE+"insertUnderSiblingChildren",replyInsertDto);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return res;
	}
	
	
	
	
	
	
}
