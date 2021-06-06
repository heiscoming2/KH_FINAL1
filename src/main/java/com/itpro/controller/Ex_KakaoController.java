package com.itpro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itpro.model.biz.Ex_KakaoPay;


import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

@Log
@Controller
public class Ex_KakaoController {

	//@Log4j
	@Controller
	@SessionAttributes("user_id")
	@AllArgsConstructor

	public class KakaoPayController {
		private Ex_KakaoPay kakaopay;
		// private KakaoPayService kakaoPayService;

		@GetMapping("kakaoPay")
		public void kakaoPayGet() {
		}

		@PostMapping("kakaoPay")
		public String kakaoPay(HttpSession httpSession) {
			String user_id = (String) httpSession.getAttribute("user_id");
			log.info(user_id);
			log.info(kakaopay.kakaoPayReady(user_id));
			return "redirect:" + kakaopay.kakaoPayReady(user_id);
		}

		@GetMapping("kakaoPaySuccess")
		public void kakaoPaySuccess(@RequestParam(value = "pg_token") String pg_token, Model model,
				HttpSession httpSession) {
			String user_id = (String) httpSession.getAttribute("user_id");
			log.info("kakaoPaySuccess get............................................");
			log.info("kakaoPaySuccess pg_token : " + pg_token);

			model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token, user_id));
			//log.info(model);
		}
	}

	@RequestMapping(value = "/main2.do")
	public String getMain2(Model model, HttpServletRequest request) {
		log.info("main.do");

		return "ad/Ex_kakaoPay";
	}

}
