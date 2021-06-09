package com.itpro.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.itpro.model.biz.KakaoPayBiz;

import lombok.extern.java.Log;

@Log
@Controller
public class KakaoController {

	@Autowired
	KakaoPayBiz biz;

	@RequestMapping("/jq.cls")
	public ModelAndView main(ModelAndView mv, HttpSession s, RedirectView rv) {
		mv.setViewName("jq/test");
		return mv;
	}

	@RequestMapping("/pay.cls")
	public ModelAndView serve(ModelAndView mv, HttpSession s, RedirectView rv) {
		mv.setViewName("jq/serve");
		return mv;
	}

	@RequestMapping(value = "/kakaopay.cls", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public String kakaopay() {
		try {
			URL url = new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "KakaoAK c1011b15c30c998efa86e461b4aa0995");
			con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			con.setDoOutput(true);

			String param = "cid=TC0ONETIME&" + "partner_order_id=partner_order_id&" + "partner_user_id=partner_user_id&"
					+ "item_name=ad cost&" + "quantity=1&" + "total_amount=100000&" + "vat_amount=10000&"
					+ "tax_free_amount=0&" + "approval_url=http://localhost:8787/upgrade/test1.do&" + "fail_url=http://localhost:8787/upgrade/test1.do&"
					+ "cancel_url=http://localhost:8787/upgrade/test1.do";
			OutputStream giver = con.getOutputStream();
			DataOutputStream datagiver = new DataOutputStream(giver);
			datagiver.writeBytes(param);
			datagiver.close();
			int result = con.getResponseCode();
			System.out.println(con.getResponseCode());
			InputStream taker;
			if (result == 200) {
				taker = con.getInputStream();
			} else {
				taker = con.getErrorStream();
			}
			InputStreamReader reader = new InputStreamReader(taker);
			BufferedReader changer = new BufferedReader(reader);
			return changer.readLine();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:kakaoapprove.cls";
	}

	@RequestMapping(value = "/test1.do")
	@ResponseBody
	public String test(@RequestParam(value="pg_token",required=false) String str, HttpServletResponse response) throws IOException {
		PrintWriter out =response.getWriter();
		out.print("<script>");
		out.print("alert('결제 완료되었습니다.');");
		out.print("opener.parent.adstatusChange();");		
		out.print("opener.location.reload();");		
		out.print("self.close();");
		out.print("</script>");
		return null;
	}
	
	@RequestMapping(value = "/adstatuschange.do")
	@ResponseBody
	public int adStatusChange(@RequestParam("bd_no")int bd_no) {
		
		int res = biz.adStatusChange(bd_no);
		
		
		
		return res;
	}	
	

}
