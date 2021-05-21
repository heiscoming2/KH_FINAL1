package com.itpro.model.bizImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.reply.ReplyInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.reply.ReplyUpdateDto;

@Service
public class ReplyBizImpl implements ReplyBiz {
	
	@Autowired
	public ReplyDao replyDao;
	
	@Override
	public List<ReplyListDto> selectList(int bd_no) {
		return replyDao.selectList(bd_no);
	}

	@Override
	public int replyCnt(int bd_no) {
		return replyDao.replyCnt(bd_no);
	}

	@Override
	@Transactional
	public int insert(ReplyInsertDto replyInsertDto) {
		
		
		//부모 댓글이 0이면 원본 댓글이니까 그냥 INSERT 하면 된다.
		if(replyInsertDto.getRe_parentno()==0) {
			return replyDao.insert(replyInsertDto);
		} else {
			//부모 댓글이 0이 아니면 부모에 달린
			//형제 댓글들이 있는지 (있으면 맨 마지막 형제 RE_NO를 가져옴)
			int lastsiblingno = replyDao.lastsiblingno(replyInsertDto.getRe_parentno());
			//형제 댓글이 없는 경우 부모 밑으로 들어가면 되는데, 부모보다 큰 ORDER를 가진 댓글들을 +1씩 해서 밀어주고
			//부모ORDER+1해서 INSERT 해준다.
			if(lastsiblingno==0) {
				replyDao.updateOrderBigThanParent(replyInsertDto.getRe_parentno());
				int insertUnderParentRes = replyDao.insertUnderParent(replyInsertDto);
				return insertUnderParentRes;
			} else {
				//형제 댓글이 존재하는 경우
				//형제의 마지막 자손 댓글을 찾아야 하는데
				//WHILE문을 이용하여
				//마지막 형제 댓글 RE_NO를 부모로 하는 댓글을 찾고, 해당 댓글의 RE_NO를 부모로 하는
				//댓글을 찾는다. 이러다가 0값을 만나게되면 WHILE문을 빠져 나오게되고
				//최종적으로 형제의 마지막 자손의 RE_NO를 구할 수 있다.
				//이제 이 값을 통해 UPDATE와 INSERT를 해주면된다.
				
				int tmp = 1;
				
				//myupperno가 마지막 자손값이 담길 변수임, 일단 형제 값으로 초기화를 먼저 시킨 후 돌림
				int myupperno = lastsiblingno;
				while(tmp!=0) {
					tmp = replyDao.getLastChildrenNo(myupperno);
					if(tmp!=0) {
						myupperno = tmp;
					}
				}
				
				//while문이 끝나면 막내 형제의 마지막 자손 re_no가(myupperno) 나온다.
				//막내 형제의 자손이 없다면 lastsiblingno가 re_no가 될것이다.
				//이제 이 값에 해당하는 같은 그룹의 order보다 큰 애들을 뒤로 밀어주고
				//이 값을 기준으로 update와 insert를 처리해주면 끝
				//insert를 하는데 매개변수로 myupperno를 함께 넘겨준다.
				replyDao.updateOrderBigThanMyUpper(myupperno);
				replyInsertDto.setMyupperno(myupperno);
				int insertUnderSiblingChildren = replyDao.insertUnderSiblingChildren(replyInsertDto);
				
				if(insertUnderSiblingChildren!=0) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	@Override
	public int update(ReplyUpdateDto replyUpdateDto) {
		return replyDao.update(replyUpdateDto);
	}

	@Override
	public int delete(int re_no) {
		
		//자식이 있는 경우 hidden 필드를 y로 업데이트
		//자식이 없으면 삭제
		int res = replyDao.childrenCheck(re_no);
		if(res>0) {
			return replyDao.updateHidden(re_no);
		}
		return replyDao.delete(re_no);
	}

}
