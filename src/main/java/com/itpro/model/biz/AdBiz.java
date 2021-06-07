package com.itpro.model.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.itpro.model.dto.ad.AdDto;
import com.itpro.model.dto.board.BoardInsertDto;
import com.itpro.model.dto.board.BoardUpdateDto;

public interface AdBiz {

	public List<AdDto> selectList(Map<String,Object> adPageMap);
	public AdDto selectOne(int bd_no);
	public List<AdDto> adinsert(ArrayList<AdDto> adDto, BoardInsertDto boardInsertDto);
	public int addelete(int bd_no);
	public int update(AdDto dto, BoardUpdateDto boardUpdateDto);
	public int getAdListCnt();
	public int adimageuploadupdate(MultipartFile fileName, int parseInt);
	public int adimagePathUpdate(int ad_no, String img_path);
}
