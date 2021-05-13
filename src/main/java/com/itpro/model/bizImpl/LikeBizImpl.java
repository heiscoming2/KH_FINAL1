package com.itpro.model.bizImpl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itpro.model.biz.LikeBiz;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dto.like.LikeDto;

@Service
public class LikeBizImpl implements LikeBiz {
	
	@Autowired
	public LikeDao LikeDao;



	  @Override
	  public int like_check(LikeDto likeDto) {
	    int count = LikeDao.like_check(likeDto);
	    return count;
	  }



	@Override
	public int like_delete(LikeDto likeDto) {
		return LikeDao.like_delete(likeDto);
	}



	@Override
	public int like_insert(LikeDto likeDto) {
	
		return LikeDao.like_insert(likeDto);
	} 

}
