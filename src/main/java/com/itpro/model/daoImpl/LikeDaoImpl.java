package com.itpro.model.daoImpl;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.LikeDao;
import com.itpro.model.dto.like.LikeDto;

@Repository
public class LikeDaoImpl implements LikeDao {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	String boardLike;

	

	  @Override
	  public int like_check(LikeDto likeDto) {
		  System.out.println(likeDto.getM_no());
		  System.out.println(likeDto.getBd_no());
	    int count = Integer.parseInt(mybatis.selectList("liketo.countbyLike", likeDto).toString().replace("[", "").replace("]", ""));
	    System.out.println("daoimpl like check"+count);
	    return count;
	  }

//	@Override
//	public int update(LikeDto likeDto) {
//		int likeUpdateRes = 0;
//		try {
//			likeUpdateRes = mybatis.update(NAMESPACE+"like_check",likeDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return likeUpdateRes;
//	}

	@Override
	public int like_delete(LikeDto likeDto) {
		int delres = 0;
		try {
			delres = mybatis.delete(NAMESPACE+"like_del",likeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return delres;
	}

	@Override
	public int like_insert(LikeDto likeDto) {
		int insertres = 0;
		
		try {
			insertres = mybatis.insert(NAMESPACE + "like_insert" , likeDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return insertres;
}

	@Override
	public int deleteWithBoard(int bd_no) {
		int likedeleteres = 0;
		try {
			likedeleteres = mybatis.delete(NAMESPACE+"deletebyBoardno",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return likedeleteres;
	}



	

}
