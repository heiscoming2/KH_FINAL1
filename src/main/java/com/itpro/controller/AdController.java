package com.itpro.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itpro.file.validate.FileValidator;
import com.itpro.model.biz.AdBiz;
import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.resume.ResumeImgDto;
import com.itpro.model.dto.upload.UploadFile;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

@Controller
public class AdController {

private static final Logger logger = LoggerFactory.getLogger(AdController.class);
	
	@Autowired
	private AdBiz adBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Autowired
	private BoardBiz boardBiz;
	
	@Autowired
	private LikeBiz likeBiz;
	
	@Autowired
	private FileValidator fileValidator;
	
	
	@RequestMapping(value="/adlist.do")
		public String adList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page, HttpSession session) {
			logger.info("AD LIST");
			
		
			
			
			//페이징을 위해 총 게시물수 count
			int adListCnt = adBiz.getAdListCnt();
			System.out.println("adListCnt : "+ adListCnt);
			
			//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
			PageProcessing pageProcessing = new PageProcessing(adListCnt,page);
				
			//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
			Map<String,Object> adPageMap = new HashMap<String,Object>();
			adPageMap.put("start", pageProcessing.getStartIndex());
			adPageMap.put("end", pageProcessing.getEndIndex());
			System.out.println(pageProcessing.getStartIndex());
			System.out.println(pageProcessing.getEndIndex());
			List<AdDto> adList = adBiz.selectList(adPageMap);
			
			//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
			model.addAttribute("pageProcessing",pageProcessing);
				
			//ad 글 목록을 받아 model에 담아준다.
			model.addAttribute("adList", adList);
			
			return "ad/adlist";
		}
		
	
	@RequestMapping(value="/adinsertform.do")
	public String adInsertForm(HttpServletRequest request) {
		logger.info("AD INSERT FORM");
		return "ad/adinsertform";
	}
	
	@PostMapping(value="/adinsert.do")
	public String adinsert(HttpServletRequest request, HttpServletResponse response, AdDto adDto
		) throws Exception {
		logger.info("AD INSERT");

		adDto.setBd_writerip(new ClientInfo().getClientIp(request));
		int res = adBiz.adinsert(adDto);
		
		if(res==0) {
			
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('등록에 실패했습니다');");
			out.print("location.href='adlist.do';");
			out.print("</script>");
			return null;
		}
		
		return "redirect:adlist.do";
	}	
	
	@RequestMapping(value="/adfileupload.do")
	@ResponseBody
	public Map<String,String> adfileupload(HttpServletRequest request, MultipartHttpServletRequest mtf) throws IllegalStateException, IOException {
		logger.info("adfileupload");
		
		// 넘어오는 파일 받음
		MultipartFile file = mtf.getFile("ad_file");
		// 파일 실제 이름
		String originName = file.getOriginalFilename();
		// 파일 확장자타입
		String fileType = originName.substring(originName.lastIndexOf("."));
		
		// 저장될 파일명
		String ad_file = UUID.randomUUID() + fileType;
		// 파일 저장경로
		String realPath = request.getSession().getServletContext().getRealPath("/resources/images/ad/");
		
		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		file.transferTo(new File(realPath, ad_file));
		logger.info("==============================");
		logger.info("경로:" + realPath + ad_file);
		
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("ad_img", ad_file);
		map.put("ad_img_path", "/resources/images/ad/");
		
		return map;
		
	}
	
	
	@RequestMapping(value="/addetail.do")
	public String adDetail(HttpServletRequest request,  HttpServletResponse response, Model model, @RequestParam(value="bd_no") int bd_no, HttpSession session) {
		logger.info("AD DETAIL");
		
		//로그인 세션이있으면 회원번호를 꺼내서 해당 게시물 추천여부를 model에 담아준다. 
		if(session.getAttribute("login")!=null) {
			MemberDto loginDto = (MemberDto) session.getAttribute("login");
			int m_no = loginDto.getM_no();
			LikeDto likeDto = new LikeDto();
			likeDto.setBd_no(bd_no);
			likeDto.setM_no(m_no);
			int res = likeBiz.like_check(likeDto);
			model.addAttribute("likecheck",res);
		}
		
		//조회수 증가 실행 (중복 카운트 방지를 위해 쿠키에 값이 없는 경우에만 증가)
		if(new ViewCount().viewCount(request, response, bd_no)) {
			boardBiz.updateviewcount(bd_no);
		}
		
		
		//selectOne 해서 model에 담아준다.
		AdDto dto = adBiz.selectOne(bd_no);
		model.addAttribute("dto",dto);
		
		
		//댓글 list받아와 model에 담아준다.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto",replyListDto);
		
		
		//댓글 총 갯수를 받아와 model에 담아준다.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt", replyCnt);
		
		return "ad/addetail";
	}
	
	@RequestMapping(value="/adupdateform.do")
	public String adUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		logger.info("AD UPDATE FORM");
		AdDto dto = adBiz.selectOne(bd_no);
		model.addAttribute("dto", dto);
		return "ad/adupdateform";
	}
	
	@RequestMapping(value="/adupdate.do")
	public String adUpdate(Model model, AdDto dto, BoardUpdateDto boardUpdateDto) {
		logger.info("AD UPDATE");
		
		int adUpdateRes = adBiz.update(dto, boardUpdateDto);
		logger.info(Integer.toString(adUpdateRes));
		if(adUpdateRes>0) {
			int bd_no = dto.getBd_no();
			return "redirect:addetail.do?bd_no="+bd_no;
		}
		
		dto = adBiz.selectOne(dto.getBd_no()); 
		dto.setBd_title(boardUpdateDto.getBd_title());
		dto.setBd_content(boardUpdateDto.getBd_content());
		/* qnaDetailDto.setBf_originname(boardUpdateDto.getBf_originname()); */
		
		model.addAttribute("dto", dto);
		logger.info("업데이트 실패");
		return "ad/adupdateform";
	}	
	
	@RequestMapping(value="/addelete.do")
	public String adDelete(Model model, int bd_no,HttpServletResponse response) throws IOException {
		logger.info("AD DELETE");
		int adDeleteRes = adBiz.addelete(bd_no);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<script>");
		out.print("alert('삭제 되었습니다.');");
		out.print("location.href='adlist.do';");
		out.print("</script>");
		return null;
	}
	
	///////파일 업로드 관련 ////////////////////////
	
	@RequestMapping(value="/admultipart.do", method=RequestMethod.POST)                                                         
    public @ResponseBody String multipart(@RequestParam("ad_no") String ad_no, @RequestParam("file") MultipartFile fileName) throws IOException {   
		logger.info("admultipart.do");
		
        int res = adBiz.adimageuploadupdate(fileName, Integer.parseInt(ad_no));
        return "{result:"+res+"}";
    }
	
	
	//이미지 경로 업데이틑 위해
	@RequestMapping(value="/adimagepathupdate.do")
	public @ResponseBody String imagePathUpdate(@RequestParam("ad_no") int ad_no, @RequestParam("img_path") String img_path) {
		
		
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		
		int rs = adBiz.adimagePathUpdate(ad_no, img_path);
		res.put("result", rs);
		
		return new Gson().toJson(res);
	}
	
	
	
	@RequestMapping(value="/addownload.do")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, HttpServletResponse response, @RequestParam("name") String name) throws IOException {
		//return type이 byte 배열
		//원래 String return은 views(.jsp) 이름이었음! 하지만 byte는 views return이 아님 -> 페이지 전환이 아닌 데이터 응답 처리임
		//String name에 파일 이름이 담겨서 넘어오는 거
		
		logger.info("name : "+name);
		//파일 업로드하는 절대 경로 가지고 오기
		String path = request.getSession().getServletContext().getRealPath(name);	//file 객체 만들기
		logger.info("path : "+path);
		File file = new File(path);
		
		//FileCopyUtils 
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName());
		
		//attachment: 다운로드 시 무조건 파일 다운로드 상자가 뜨도록 함
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		
		response.setContentLength(bytes.length); //파일 길이
		response.setContentType("image/jpeg"); //파일 타입
		
		return bytes;
	}
	
	   @RequestMapping(value="/kakaopay.cls", method = RequestMethod.POST)
	   @ResponseBody
	   public String kakaopay() {
	      try {
	         URL url = new URL("http://kapi.kakao.com/v1/payment/ready");
	         HttpURLConnection con = (HttpURLConnection) url.openConnection();
	         con.setRequestMethod("POST");
	         con.setRequestProperty("Authorization", "KakaoAK c1011b15c30c998efa86e461b4aa0995");
	         con.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	         con.setDoOutput(true);
	         
	         String param = "cid=TC0ONETIME&"
	                      + "partner_order_id=partner_order_id&"
	                      + "partner_user_id=partner_user_id&"
	                      + "item_name=초코파이&"
	                      + "quantity=1&"
	                      + "total_amount=2200&"
	                      + "vat_amount=200&"
	                      + "tax_free_amount=0&"
	                      + "approval_url=https://developers.kakao.com/success&"
	                      + "fail_url=https://developers.kakao.com/fail&"
	                      + "cancel_url=https://developers.kakao.com/cancel";
	         OutputStream giver = con.getOutputStream();
	         DataOutputStream datagiver = new DataOutputStream(giver);
	         datagiver.writeBytes(param);
	         datagiver.close();
	         int result = con.getResponseCode();
	         
	         InputStream taker;
	         if(result==200) {
	            taker = con.getInputStream();
	         }else {
	            taker = con.getErrorStream();
	         }
	         InputStreamReader reader= new InputStreamReader(taker);
	         BufferedReader changer = new BufferedReader(reader);
	         return changer.readLine();
	               
	         
	      } catch (MalformedURLException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return "{\"result\":\"NO\"}";
	   }
	   

}
