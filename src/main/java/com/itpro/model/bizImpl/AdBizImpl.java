package com.itpro.model.bizImpl;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.itpro.model.biz.AdBiz;
import com.itpro.model.dao.AdDao;
import com.itpro.model.dao.BoardDao;
import com.itpro.model.dao.LikeDao;
import com.itpro.model.dao.ReplyDao;
import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.board.BoardUpdateDto;
import com.itpro.model.dto.qna.QnaDetailDto;
import com.itpro.model.dto.qna.QnaInsertDto;
import com.itpro.model.dto.qna.QnaUpdateDto;

@Service
public class AdBizImpl implements AdBiz {

	@Autowired
	private AdDao adDao;

	@Autowired
	private BoardDao boardDao;

	@Autowired
	private ReplyDao replyDao;

	@Autowired
	private LikeDao likeDao;

	@Override
	public List<AdDto> selectList(Map<String, Object> adPageMap) {
		return adDao.selectList(adPageMap);
	}

	@Override
	public AdDto selectOne(int bd_no) {
		return adDao.selectOne(bd_no);
	}

	@Override
	public int insert(AdDto dto) {
		return adDao.insert(dto);
	}

	@Override
	@Transactional
	public int delete(int bd_no) {
		int deleteres = 0;
		int replydeleteres = replyDao.deleteWithBoard(bd_no);
		int likedeleteres = likeDao.deleteWithBoard(bd_no);
		int qnadeleteres = adDao.delete(bd_no);
		int boarddeleteres = boardDao.delete(bd_no);
		if (qnadeleteres > 0 && boarddeleteres > 0 && replydeleteres > 0 && likedeleteres > 0) {
			deleteres = 1;
		}
		return deleteres;
	}

	@Override
	@Transactional
	public int update(AdDto dto, BoardUpdateDto boardUpdateDto) {
		int res = 0;
		int qnaUpdateRes = adDao.update(dto);
		int boardUpdateRes = boardDao.update(boardUpdateDto);
		if (qnaUpdateRes > 0 && boardUpdateRes > 0) {
			res = 1;
		}
		return res;
	}

	@Override
	public int getAdListCnt() {
		return adDao.getAdListCnt();
	}

	
	@Override
	public int imageuploadupdate(MultipartFile fileName, int ad_seq) {
		
		int res = 0;
		if(fileName.getSize()<=0) {
			return 0;
		}
       String originalFile = fileName.getOriginalFilename();
       String originalFileExtension = originalFile.substring(originalFile.lastIndexOf(".")); //확장자
       SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
       String fileServerName= format.format(new Date());

        File file = new File("C:\\workspace\\STS_Spring01\\KH_FINAL\\src\\main\\webapp\\resources\\images\\ad" +File.separator, fileServerName+originalFileExtension);
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
        
		return adDao.imageuploadupdate(ad_seq, "\\\\resources\\\\images\\\\ad\\\\"+ fileServerName+originalFileExtension);
	}
}
