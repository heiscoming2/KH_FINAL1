package com.itpro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		// 0 1
		int res = likeBiz.like_check(likeDto);
		System.out.println("res:" + res);

		if (res > 0) {
			int delres = likeBiz.like_delete(likeDto);
			if (delres > 0) {
				System.out.println("like delete");
			}
		} else {
			int insertres = likeBiz.like_insert(likeDto);
			if (insertres > 0) {
				System.out.println("like insert");
			}
			like_check = true;

		}

		return like_check;

	}

}
