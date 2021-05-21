package com.itpro.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itpro.model.biz.LikeBiz;
import com.itpro.model.dto.like.LikeDto;

@Controller
public class LikeController {

	private Logger logger = LoggerFactory.getLogger(LikeController.class);

	@Autowired
	private LikeBiz likeBiz;

	@RequestMapping(value = "like.do", method = RequestMethod.POST)
	@ResponseBody
	public Boolean likeUpdate(@RequestBody LikeDto likeDto) {

		logger.info("LIKE UPDATE");
		boolean like_check = false;
		
		//DTO에는 회원번호와 게시글번호가 있다
		//추천 테이블에서 COUNT(*)을 이용해
		//해당 게시물에 해당 회원번호로 추천을 누른 이력이 있는지 확인한다.
		//res가 1이면 추천 내역이 있다는것 이니 delete 로직을 수행하고
		//1이 아니라면 추천 내역이 없다는거니까 insert 로직을 수행한다.
		
		//그리고 boolean을 리턴 해주는데
		//delete (추천  취소) 시 false
		//insert (추천 성공) 시 true를 반환한다.
		
		//ajax에서는 boolean을 리턴받아
		//추천 취소, 성공에 맞는 로직을 수행한다.
		
		int res = likeBiz.like_check(likeDto);
		System.out.println("res:" + res);

		if (res > 0) {
			int delres = likeBiz.like_delete(likeDto);
			if (delres > 0) {
				logger.info("LIKE DELETE");
			} else {
				logger.info("오류 발생");
			}
		} else {
			int insertres = likeBiz.like_insert(likeDto);
			if (insertres > 0) {
				logger.info("LIKE INSERT");
			} else {
				logger.info("오류 발생");
			}
			like_check = true;
		}
		return like_check;

	}
	


}
