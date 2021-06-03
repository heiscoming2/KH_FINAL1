package com.itpro.model.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.MemberDao;
import com.itpro.model.dao.NoteDao;
import com.itpro.model.dao.ResumeDao;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.member.ProfileDto;
import com.itpro.model.dto.note.NoteDto;
import com.itpro.model.dto.resume.ResumeDto;
import com.itpro.model.dto.study.StudyListDto;

@Repository
public class NoteDaoImpl implements NoteDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 내가 받은 쪽지 목록 조회
	public List<NoteDto> receiveList(int n_receiver) {

		List<NoteDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "receiveList", n_receiver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 보낸쪽지 목록
	public List<NoteDto> sendList(int n_sender) {
		List<NoteDto> list = null;
		try {
			list = sqlSession.selectList(NAMESPACE + "sendList", n_sender);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	// 내가 받은쪽지 하나 읽기
	public NoteDto receiveDetail(Map map) {
		NoteDto detail = null;
		try {
			detail = sqlSession.selectOne(NAMESPACE + "receiveDetail", map);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return detail;
	}

	// 내가 보낸 쪽지 하나 읽기
	public NoteDto sendDetail(Map map) {
		NoteDto detail = null;
		try {
			detail = sqlSession.selectOne(NAMESPACE + "sendDetail", map);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return detail;

	}

	// 쪽지 보내기(insert)
	@Override
	public int noteSend(NoteDto noteDto) {
		int res = 0;

		try {
			res = sqlSession.insert(NAMESPACE + "noteSend", noteDto);

		} catch (Exception e) {
			System.out.println("[error] : noteSend");
			e.printStackTrace();
		}

		return res;
	}

	// 쪽지 삭제
	@Override
	public int noteDelete(int n_no) {
		int res = 0;

		try {
			res = sqlSession.delete(NAMESPACE + "noteDelete", n_no);
		} catch (Exception e) {
			System.out.println("[error]:note Delete");
			e.printStackTrace();
		}

		return res;
	}

	// 새로 받은 쪽지가 있는지 확인(매번)
	@Override
	public Integer countNewNote() {
		Integer count = 0;
		try {
			count = sqlSession.selectOne(NAMESPACE + "countNewNote");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	// 읽은 쪽지 읽은 시간 표시 UPDATE
	public int updateReadDate() {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE + "updateReadDate");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@Override
	public int companyApplicationSendNote(Map<String, Object> map) {
		int res = 0;
		try {
			res = sqlSession.update(NAMESPACE + "companyapplicationsendnote",map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}

}
