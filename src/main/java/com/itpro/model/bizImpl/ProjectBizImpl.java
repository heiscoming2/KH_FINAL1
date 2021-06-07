package com.itpro.model.bizImpl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.itpro.model.biz.ProjectBiz;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;

@Service
public class ProjectBizImpl implements ProjectBiz{

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	@Autowired
	private LikeDao likeDao;
	

	@Override
	public List<ProjectListDto> selectList(Map<String, Object> projectPageMap) {
		return projectDao.selectList(projectPageMap);
	}

	@Override
	public List<ProjectDetailDto> selectOne(int bd_no) {
		
		return projectDao.selectOne(bd_no);
	}

	@Override
	public List<ProjectInsertDto>  projectInsert(ArrayList<ProjectInsertDto> projectDto, BoardInsertDto boardInsertDto) {
		
		return projectDao.projectInsert(projectDto, boardInsertDto);
	}

	@Override
	public int update(ProjectUpdateDto projectDto) {
		int projectUpdateRes = projectDao.update(projectDto);
		return projectUpdateRes;
	}

	@Override
	@Transactional
	public int delete(int bd_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int projectdeleteres = projectDao.delete(bd_no);
		int boarddeleteres = boardDao.delete(bd_no);
		if(projectdeleteres>0 && boarddeleteres>0 && replydeleteres>0 && likedeleteres>0) {
			deleteres = 1;
		}
		return deleteres; 
	}

	@Override
	public int getProjectListCnt(Map<String, Object> projectPageMap) {
		return projectDao.getProjectListCnt(projectPageMap);
	}


	@Override
	public int update(ProjectUpdateDto projectUpdateDto, BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int projectUpdateRes = projectDao.update(projectUpdateDto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if(projectUpdateRes>0 && boardUpdateRes>0) {
			res = 1;
		}
		return res; 
	}

	@Override
	public int imageuploadupdate(MultipartFile fileName, int pro_no) {
		
		int res = 0;
		if(fileName.getSize()<=0) {
			return 0;
		}
       String originalFile = fileName.getOriginalFilename();
       String originalFileExtension = originalFile.substring(originalFile.lastIndexOf(".")); //확장자
       SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
       String fileServerName= format.format(new Date());

        File file = new File("C:\\workspace\\STS_Spring01\\KH_FINAL\\src\\main\\webapp\\resources\\images\\project" +File.separator, fileServerName+originalFileExtension);
        if(!file.exists()) {
        	file.mkdirs();
        }

        try {
			fileName.transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(originalFile + "은 업로드한 파일이다.");
        System.out.println(file.getAbsolutePath() + "라는 이름으로 업로드 됐다.");
        System.out.println("파일사이즈는 " + fileName.getSize());
        
		return projectDao.imageuploadupdate(pro_no, "\\\\resources\\\\images\\\\project\\\\"+ fileServerName+originalFileExtension);
	}

	@Override
	public ProjectDetailDto projectSelectOne(int bd_no) {
		return projectDao.projectSelectOne(bd_no);
	}

	@Override
	public String selectDetail(int bd_no) {
		List<ProjectDetailDto> detailDtos = projectDao.selectOne(bd_no);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=0;i<detailDtos.size();i++) {
			ProjectDetailDto dto = detailDtos.get(i);
			System.out.println("dto.getPro_start() : "+dto.getPro_start());
			String start_str = format.format(dto.getPro_start());
			System.out.println("start_str : "+start_str);
			dto.pro_start_str = start_str;
			dto.pro_end_str = format.format(dto.getPro_end());
		}
		return new Gson().toJson(detailDtos);
	}

	@Override
	public List<ProjectInsertDto> projectUpdate(ArrayList<ProjectInsertDto> projectDtoList,
			BoardUpdateDto boardupdateDto) {
		
		projectDao.delete(projectDtoList.get(0).bd_no); 
		
		boardDao.update(boardupdateDto);
		
		for (ProjectInsertDto projectInsertDto : projectDtoList) {
			projectDao.insert(projectInsertDto);
		}	
		
		return projectDtoList;
	}

	@Override
	public int imagePathUpdate(int pro_no, String img_path) {
		
		return projectDao.imageuploadupdate(pro_no, img_path);
	}



	
	

}
