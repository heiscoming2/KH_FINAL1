package com.itpro.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itpro.model.dto.upload.UploadImageDto;


@Controller
public class UploadController {

	private Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="/uploadsummernoteimage.do", produces = "application/json")
	@ResponseBody
	public Map<String,String> uploadsummernoteimage(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request) {
		
		logger.info("SUMMERNOTE IMAGE UPLOAD");
		Map<String,String> map = new HashMap<String,String>();
		
		//경로설정
		//*여기 경로에 저장시 서버 클린하면 이미지 다 지워지는 단점이있음
		//실제 서비스를 한다고하면 외부경로로 변경하고 톰캣에서 설정해서 사용하는게 좋을듯
		String path = request.getSession().getServletContext().getRealPath("/resources/images/boardimages/");
		//파일 실제이름
		String origin_name = multipartFile.getOriginalFilename();
		//파일 확장자
		String type = origin_name.substring(origin_name.lastIndexOf("."));
		//저장될 파일명 = UUID(랜덤으로 ID만드는거) + 확장자
		String real_name = UUID.randomUUID()+type;
		//파일사이즈
		long size = multipartFile.getSize();
		//이미지 가로,세로 얻어오기
		BufferedImage bufferedImage;
		int width = 0;
		int height = 0;
		try {
			bufferedImage = ImageIO.read(multipartFile.getInputStream());
			width = bufferedImage.getWidth();
			height = bufferedImage.getHeight();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//파일 객체 생성, 경로와 이름을 준다. 아직 실제 파일 연결은 안됨
		File targetFile = new File(path+real_name);
		logger.info("경로+이미지명 : " + path+real_name);
		//실제 파일의 스트림을 열어서 위에 만든 file과 연결해서 복사해준다.
		try {
			//파일 객체와 연결하기 위해 stream을 열고
			InputStream fileStream = multipartFile.getInputStream();
			//위에 생성한 객체 타겟 파일과 연결시켜 복사한다.
			FileUtils.copyInputStreamToFile(fileStream, targetFile);
		
		} catch (IOException e) {
			logger.info("SUMMERNOTE IMAGE UPLOAD ERROR");
			//오류가 난 경우 targetFile을 지워준다.
			FileUtils.deleteQuietly(targetFile);
			e.printStackTrace();
		}
		
		//map에 파일 경로 url 보내준다 resources~~ 부터 보내야하는데 앞에꺼 servlet context에 맵핑해놔서 생략 가능
		map.put("url", "boardimages/"+real_name);
		return map;
	}
	
	
}
