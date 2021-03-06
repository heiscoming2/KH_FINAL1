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
	public String projectList(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page, 
			@RequestParam(value="key", required=false, defaultValue="") String key,
			HttpSession session) {
		
		logger.info("Project LIST");
		if(session.getAttribute("login")!=null) {
			MemberDto login = (MemberDto) session.getAttribute("login");
		}
		
		Map<String,Object> projectPageMap = new HashMap<String,Object>();
		projectPageMap.put("key", key);
		
		//???????????? ?????? ??? ???????????? count
		int projectListCnt = projectBiz.getProjectListCnt(projectPageMap);
		System.out.println("projectListCnt : "+projectListCnt);
		
		//??????????????? ?????????????????? ???????????? ????????? ???????????? dto??? ????????????.
		PageProcessing pageProcessing = new PageProcessing(projectListCnt,page);
			
		//???????????? select ????????????, startindex??? endindex??? ??????????????? ?????? ????????????.
		//(??? ????????? ????????? PageProcessing ??????????????? map??? ?????? ???????????? ????????? ??????????????? ?????????)
		projectPageMap.put("start", pageProcessing.getStartIndex());
		projectPageMap.put("end", pageProcessing.getEndIndex());
		System.out.println(pageProcessing.getStartIndex());
		System.out.println(pageProcessing.getEndIndex());
		List<ProjectListDto> projectList = projectBiz.selectList(projectPageMap);
		
		//????????? ?????? model??? ????????? (_page.jspf?????? ????????? ?????????)
		model.addAttribute("pageProcessing",pageProcessing);
			
		//???????????? ??? ????????? ?????? model??? ????????????.
		model.addAttribute("projectList",projectList);
		
		model.addAttribute("key",key);
		
		//????????? ??? ????????? ??????
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
	
	//text ?????? ???
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
			//res 0?????? ????????? ??? ??????
			//res 1?????? ????????? ??????
			System.out.println("res:" +res);
			model.addAttribute("likecheck", res);
			model.addAttribute("login", loginDto);
			System.out.println("login: " + new Gson().toJson(loginDto));
		}
		
		//????????? ?????? ?????? (?????? ????????? ????????? ?????? ????????? ?????? ?????? ???????????? ??????)
		if(new ViewCount().viewCount(request, response, bd_no)) {
			boardBiz.updateviewcount(bd_no);
		}
		
		
		List<ProjectDetailDto> list = projectBiz.selectOne(bd_no);
		model.addAttribute("list", list);
		System.out.println("list : "+new Gson().toJson(list) );
		
		//selectone reply ????????? ??????
		/*
		 * ProjectDetailDto projectDetailDto = projectBiz.projectSelectOne(bd_no);
		 * model.addAttribute("dto",projectDetailDto);
		 */

		ProjectDetailDto projectDetailDto = new ProjectDetailDto();
		projectDetailDto.setBd_no(bd_no);
		projectDetailDto.setM_no(list.get(0).getM_no());
		
		model.addAttribute("dto",projectDetailDto);
		
		//?????? list????????? model??? ????????????.
		List<ReplyListDto> replyListDto = replyBiz.selectList(bd_no);
		model.addAttribute("replyListDto", replyListDto);
		
		//?????? ??? ????????? ????????? model??? ????????????.
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
		
		//????????? int????????? ????????? alert ??????
		return "redirect:projectlist.do";
	}
	
	@RequestMapping(value="/multipart.do", method=RequestMethod.POST)                                                         
    public @ResponseBody String multipart(@RequestParam("pro_no") String pro_no, @RequestParam("file") MultipartFile fileName) throws IOException {   
		logger.info("multipart.do");
		
        int res = projectBiz.imageuploadupdate(fileName, Integer.parseInt(pro_no));
        return "{result:"+res+"}";
    }
	
	
	//????????? ?????? ???????????? ??????
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
		//return type??? byte ??????
		//?????? String return??? views(.jsp) ???????????????! ????????? byte??? views return??? ?????? -> ????????? ????????? ?????? ????????? ?????? ?????????
		//String name??? ?????? ????????? ????????? ???????????? ???
		
		
		//?????? ??????????????? ?????? ?????? ????????? ??????
		String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
		
		//file ?????? ?????????
		File file = new File(path + "/" + name);
		
		//FileCopyUtils 
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName());
		
		//attachment: ???????????? ??? ????????? ?????? ???????????? ????????? ????????? ???
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fn + "\"");
		
		response.setContentLength(bytes.length); //?????? ??????
		response.setContentType("image/jpeg"); //?????? ??????
		
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
