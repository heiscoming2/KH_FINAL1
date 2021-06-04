package com.itpro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itpro.model.biz.KakaoPayBiz;
import com.itpro.model.dto.ad.KakaoPayDto;
import com.itpro.model.dto.member.MemberDto;

import lombok.extern.java.Log;

@Log
@Controller
public class KakaoController {
	
	@Autowired
	KakaoPayBiz biz;
	
	

	@RequestMapping(value = "/kakaoApply.do", method = RequestMethod.POST)
	public String getCharge(@RequestParam int ad_price, Model model) {

		model.addAttribute("ad_price", ad_price);

		return "ad/kakaoPay";
	}

////충전하는 페이지( ///////////////////////
	@RequestMapping(value = "/coin_payment_01.do", method = RequestMethod.GET)
	public String getCoin_Payment_01(HttpSession session, HttpServletRequest request, Model model) {

		MemberDto memberdto = (MemberDto) session.getAttribute("dto");

		int point_val = 0;

//포인트 충전 성공시

		model.addAttribute("point_val", memberdto);

		return "redirect:coin_payment.do";
	}

	@RequestMapping(value = "/coin_payment.do", method = RequestMethod.GET)
	public String getCoin_Payment(HttpSession session, HttpServletRequest request, Model model) {

		KakaoPayDto kakaopaydto = (KakaoPayDto) session.getAttribute("dto");

		List<KakaoPayDto> list = biz.selectList();

		int coin_charge = 0;
		int coin_use = 0;
		int coin_use1 = 0;
		int coin_val = 0;

//		coin_charge = coinBiz.coin(userdto.getUserseq(), "충전");
//
//		coin_use = coinBiz.coin(userdto.getUserseq(), "매칭 게시글 작성");
//		coin_use1 = coinBiz.coin(userdto.getUserseq(), "상대방에게 매칭 신청");
//
//		coin_val = ((coin_charge - (coin_use + coin_use1)) / 500);

		model.addAttribute("coinlist", list);
		model.addAttribute("coin", coin_val);
//		model.addAttribute("user_name", userdto.getUsername());

		return "coin_payment";
	}
}
