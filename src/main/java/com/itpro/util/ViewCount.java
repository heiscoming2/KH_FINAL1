package com.itpro.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCount {
	
	public boolean viewCount(HttpServletRequest request, HttpServletResponse response, int bd_no) {
		
		//request의 모든 쿠키를 받아온다.
		Cookie[] cookies = request.getCookies();
		
		//쿠키가 null이 아닌 경우
		if(cookies != null) {
			//쿠기를 돌면서 (viewCookie+게시판번호) 라는 cookie가 있는지 확인한다.
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("viewCookie"+bd_no)) {
					//존재하는 경우 fasle를 리턴한다
					System.out.println("쿠키있음");
					return false;
				}
			}
		}
		//위애서 걸러졌다는건
		//쿠키 자체가 없거나 viewCookie+게시판번호 라는 쿠기가 없다는거니까
		//cookie를 만들어서 (쿠키이름,값)
		//쿠키를 심어준다.
		//그리고 true로 리턴하여 조회수 증가 로직을 실행
		System.out.println("쿠기없음/생성");
		Cookie cookie = new Cookie("viewCookie"+bd_no,bd_no+"");
		
		//60*60*24=하루
		//일단 테스트를 위해 60 (1분) 동안만 쿠키가 유효하도록 설정
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		return true;
	}

}
