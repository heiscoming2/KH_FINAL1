package com.itpro.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
import com.itpro.model.dto.project.ProjectUpdateDto;
import com.itpro.model.dto.reply.ReplyListDto;
import com.itpro.model.dto.study.StudyDetailDto;
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
	
	
	@RequestMapping(value="/projectupdateform.do")
	public String projectUpdateForm(Model model,@RequestParam(value="bd_no") int bd_no) {
		logger.info("PROJECT UPDATE FORM");
		List<ProjectDetailDto> projectDetailDto = projectBiz.selectOne(bd_no);
		model.addAttribute("projectDetailDto", projectDetailDto);
		return "projectboard/projectupdateform";
	}
	
	
	@RequestMapping(value="/projectupdate.do")
	public String projectUpdate(Model model, ProjectUpdateDto projectUpdateDto, BoardUpdateDto boardUpdateDto) {
		logger.info("PROJECT UPDATE");
		
		int projectUpdateRes = projectBiz.update(projectUpdateDto,boardUpdateDto);
		logger.info(Integer.toString(projectUpdateRes));
		if(projectUpdateRes>0) {
			int bd_no = projectUpdateDto.getBd_no();
			return "redirect:projectdetail.do?bd_no="+bd_no;
		}
		
		List<ProjectDetailDto> projectDetailDto = projectBiz.selectOne(projectUpdateDto.getBd_no()); 
		/*
		 * projectDetailDto.setBd_title(boardUpdateDto.getBd_title());
		 * projectDetailDto.setBd_content(boardUpdateDto.getBd_content());
		 * 
		 * projectDetailDto.setPro_title(projectUpdateDto.getPro_title());
		 * projectDetailDto.setPro_start(projectUpdateDto.getPro_start());
		 * projectDetailDto.setPro_end(projectUpdateDto.getPro_end());
		 * projectDetailDto.setPro_link(projectUpdateDto.getPro_link());
		 * projectDetailDto.setPro_develop(projectUpdateDto.getPro_develop());
		 * projectDetailDto.setPro_goal(projectUpdateDto.getPro_goal());
		 * projectDetailDto.setPro_function(projectUpdateDto.getPro_function());
		 * projectDetailDto.setPro_erd(projectUpdateDto.getPro_erd());
		 */

		model.addAttribute("projectDetailDto",projectDetailDto);
		logger.info("업데이트 실패");
		return "projectboard/projectupdateform";
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
		int res = 0;
		if(fileName.getSize()<=0) {
			return "{result:"+res+"}";
		}
       String originalFile = fileName.getOriginalFilename();
       String originalFileExtension = originalFile.substring(originalFile.lastIndexOf(".")); //확장자
       SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
       String fileServerName= format.format(new Date());

        File file = new File("project" +File.separator, fileServerName+originalFileExtension);
        if(!file.exists()) {
        	file.mkdirs();
        }

        fileName.transferTo(file);
        
        System.out.println(originalFile + "은 업로드한 파일이다.");
        System.out.println(file.getAbsolutePath() + "라는 이름으로 업로드 됐다.");
        System.out.println("파일사이즈는 " + fileName.getSize());
        
        res = projectBiz.imageuploadupdate(Integer.parseInt(pro_no), file.getAbsolutePath());
        return "{result:"+res+"}";
    }
	
	
	/*
	 * @RequestMapping(value="/imageupload.do", method= RequestMethod.POST) public
	 * String upload(MultipartHttpServletRequest request) { MultipartFile file =
	 * request.getFile("pro_file");
	 * 
	 * System.out.println(file.getName()); System.out.println(file.getSize());
	 * String extention = file.getOriginalFilename().split(".")[1];
	 * System.out.println(file.getOriginalFilename());
	 * 
	 * SimpleDateFormat image_upload = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
	 * image_upload+"."+extention;
	 * 
	 * 
	 * return null; }
	 */
	
	
	
	
	
	
	
	
	
	/*
	 * @RequestMapping(value="/projectcategory.do") public String
	 * projectcategory(@RequestParam(value="bd_no") int bd_no, Model model ) {
	 * return null;
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	
	
}
