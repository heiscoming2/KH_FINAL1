package com.itpro.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itpro.model.biz.BoardBiz;
import com.itpro.model.biz.LikeBiz;
import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.biz.ReplyBiz;
import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.like.LikeDto;
import com.itpro.model.dto.member.MemberDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.util.ClientInfo;
import com.itpro.util.PageProcessing;
import com.itpro.util.ViewCount;

@Controller
public class ProjectController {

private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private ProjectBiz projectBiz;
	
	@Autowired
	private ReplyBiz replyBiz;
	
	@Autowired
	private BoardBiz boardBiz;
	
	@Autowired
	private LikeBiz likeBiz;
	
	@RequestMapping(value="/projectlist.do")
	public String projectList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page, HttpSession session) {
		logger.info("Project LIST");
		if(session.getAttribute("login")!=null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
		}
		
		//페이징을 위해 총 게시물수 count
		int projectListCnt = projectBiz.getProjectListCnt();
		System.out.println("projectListCnt : "+projectListCnt);
		
		//게시물수와 선택페이지에 해당하는 페이지 정보값을 dto로 담아둔다.
		PageProcessing pageProcessing = new PageProcessing(projectListCnt,page);
			
		//리스트를 select 해오는데, startindex와 endindex를 매개변수로 주어 받아온다.
		//(이 부분은 나중에 PageProcessing 클래스에서 map을 바로 리턴받는 형태로 변경하는게 나을듯)
		Map<String,Object> projectPageMap = new HashMap<String,Object>();
		projectPageMap.put("start", pageProcessing.getStartIndex());
		projectPageMap.put("end", pageProcessing.getEndIndex());
		System.out.println(pageProcessing.getStartIndex());
		System.out.println(pageProcessing.getEndIndex());
		List<ProjectListDto> projectList = projectBiz.selectList(projectPageMap);
		
		//페이징 처리 model에 담아줌 (_page.jspf에서 받아서 사용됨)
		model.addAttribute("pageProcessing",pageProcessing);
			
		//프로젝트 글 목록을 받아 model에 담아준다.
		model.addAttribute("projectList",projectList);
		
		//시간이 안 찍혀서 확인
		/*for(int i=0; i<projectList.size(); i++) {
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
			System.out.println(format1.format(projectList.get(i).getBd_createddate()));
		}*/
		
		return "project/projectlist";
	}
	
	@RequestMapping(value="/projectinsertform.do")
	public String projectInsertForm() {
		logger.info("PROJECT INSERT FORM");
		return "project/projectinsertform";
	}
	
	//text 받는 거
	@PostMapping(value="/projectinsert.do")
	public @ResponseBody String projectInsert(HttpServletRequest request, HttpServletResponse response
//			, @RequestBody String data
			) {
		String data = null;
		try {
			data = request.getReader().readLine();
			logger.info("PROJECT INSERT : "+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ProjectInsertDto> projectDtoList = new Gson().fromJson(data, new TypeToken<List<ProjectInsertDto>>(){}.getType());
		ArrayList<BoardInsertDto> boardDtoList = new Gson().fromJson(data, new TypeToken<List<BoardInsertDto>>(){}.getType());

		boardDtoList.get(0).bd_writerip = (new ClientInfo().getClientIp(request));
		
		logger.info("PROJECT INSERT : "+projectDtoList.size());
		logger.info("PROJECT INSERT : "+boardDtoList.size());
		List<ProjectInsertDto> resultDtos = projectBiz.projectInsert(projectDtoList, boardDtoList.get(0));
		return new Gson().toJson(resultDtos);
	}
	
	
	
	@RequestMapping(value="/projectdetail.do")
	public String projectDetail(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value="bd_no") int bd_no, HttpSession session) {
		logger.info("PROJECT DETAIL");
		
		if(session.getAttribute("login")!=null) {
			MemberDto loginDto = (MemberDto) session.getAttribute("login");
			int m_no = loginDto.getM_no();
			LikeDto likeDto = new LikeDto();
			likeDto.setBd_no(bd_no);
			likeDto.setM_no(m_no);
			int res = likeBiz.like_check(likeDto);
			//res 0이면 추천을 안 한거
			//res 1이면 추천을 한거
			System.out.println("res:" +res);
			model.addAttribute("likecheck", res);
			model.addAttribute("login", loginDto);
			System.out.println("login: " + new Gson().toJson(loginDto));
		}
		
		//조회수 증가 실행 (중복 카운트 방지를 위해 쿠키에 값이 없는 경우에만 증가)
		if(new ViewCount().viewCount(request, response, bd_no)) {
			boardBiz.updateviewcount(bd_no);
		}
		
		
		List<ProjectDetailDto> list = projectBiz.selectOne(bd_no);
		model.addAttribute("list", list);
		System.out.println("list : "+new Gson().toJson(list) );
		
		//selectone reply 때문에 만듦
		/*
		 * ProjectDetailDto projectDetailDto = projectBiz.projectSelectOne(bd_no);
		 * model.addAttribute("dto",projectDetailDto);
		 */

		ProjectDetailDto projectDetailDto = new ProjectDetailDto();
		projectDetailDto.setBd_no(bd_no);
		projectDetailDto.setM_no(list.get(0).getM_no());
		
		model.addAttribute("dto",projectDetailDto);
		
		//댓글 list받아와 model에 담아준다.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto", replyListDto);
		
		//댓글 총 갯수를 받아와 model에 담아준다.
		int replyCnt = replyBiz.replyCnt(bd_no);
		model.addAttribute("replyCnt",replyCnt);
		
		
		
		return "project/projectdetail";
	}	
	
	
	@RequestMapping(value="/getprojectdetail.do",produces = "application/json;")
	public @ResponseBody String getProjectDetail(@RequestParam(value="bd_no") int bd_no) { 
		logger.info(projectBiz.selectDetail(bd_no).toString());
		return projectBiz.selectDetail(bd_no);
	}
	
	
	
	@RequestMapping(value="/projectupdateform.do")
	public String projectUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		
		
		logger.info("PROJECT UPDATE FORM");
		model.addAttribute("bd_no", bd_no);
		return "project/projectupdateform";
	}
	
	
	@RequestMapping(value="/projectdelete.do")
	public String projectDelete(Model model, int bd_no) {
		logger.info("PROJECT DELETE");
		int projectDeleteRes = projectBiz.delete(bd_no);
		
		//나중에 int값으로 실패시 alert 처리
		return "redirect:projectlist.do";
	}
	
	@RequestMapping(value="/multipart.do", method=RequestMethod.POST)                                                         
    public @ResponseBody String multipart(@RequestParam("pro_no") String pro_no, @RequestParam("file") MultipartFile fileName) throws IOException {   
		logger.info("multipart.do");
		
        int res = projectBiz.imageuploadupdate(fileName, Integer.parseInt(pro_no));
        return "{result:"+res+"}";
    }
	
	
	//이미지 경로 업데이틑 위해
	@RequestMapping(value="/imagepathupdate.do")
	public @ResponseBody String imagePathUpdate(@RequestParam("pro_no") int pro_no, @RequestParam("img_path") String img_path) {
		
		
		HashMap<String, Integer> res = new HashMap<String, Integer>();
		
		int rs = projectBiz.imagePathUpdate(pro_no, img_path);
		res.put("result", rs);
		
		return new Gson().toJson(res);
	}
	
	
	
	@RequestMapping(value="/download.do")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {
		//return type이 byte 배열
		//원래 String return은 views(.jsp) 이름이었음! 하지만 byte는 views return이 아님 -> 페이지 전환이 아닌 데이터 응답 처리임
		//String name에 파일 이름이 담겨서 넘어오는 거
		
		
		//파일 업로드하는 절대 경로 가지고 오기
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		
		//file 객체 만들기
		File file = new File(path + "/" + name);
		
		//FileCopyUtils 
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName());
		
		//attachment: 다운로드 시 무조건 파일 다운로드 상자가 뜨도록 함
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		
		response.setContentLength(bytes.length); //파일 길이
		response.setContentType("image/jpeg"); //파일 타입
		
		return bytes;
	}
	
	
	@PostMapping(value="/projectupdate.do")
	public @ResponseBody String projectUpdate(HttpServletRequest request, HttpServletResponse response) {
		String data = null;
		try {
			data = request.getReader().readLine();
			logger.info("PROJECT INSERT : "+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<ProjectInsertDto> projectDtoList = new Gson().fromJson(data, new TypeToken<List<ProjectInsertDto>>(){}.getType());
		ArrayList<BoardUpdateDto> boardDtoList = new Gson().fromJson(data, new TypeToken<List<BoardUpdateDto>>(){}.getType());
		
		logger.info("PROJECT INSERT : "+projectDtoList.size());
		logger.info("PROJECT INSERT : "+boardDtoList.size());
		List<ProjectInsertDto> resultDtos = projectBiz.projectUpdate(projectDtoList, boardDtoList.get(0));
		return new Gson().toJson(resultDtos);
	}
	
	
	
	
	
	
	
}
