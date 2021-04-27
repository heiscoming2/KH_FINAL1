package com.itpro.model.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.itpro.model.dao.CompanyCrawlingDao;
import com.itpro.model.dto.CompanyCrawlingDto;

@Repository
public class CompanyCrawlingDaoImpl implements CompanyCrawlingDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CompanyCrawlingDto> selectList(int page) {
		int start = 1+(page-1)*10;
		int end = 10*page;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("start", start);
		map.put("end", end);
		List<CompanyCrawlingDto> companyCrawlingList = sqlSession.selectList(NAMESPACE+"selectList",map);
		return companyCrawlingList;
	}

	@Override
	public int updatelist(List<CompanyCrawlingDto> companyCrawlingList) {
		int res = sqlSession.insert(NAMESPACE+"updatelist",companyCrawlingList);
		return res;
	}

	@Override
	public int deletelist() {
		int res=0;
		try {
			res = sqlSession.delete(NAMESPACE+"deletelist");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int getCompanyCrawlingContentCnt() {
		int CompanyCrawlingContentCnt=0;
		try {
			CompanyCrawlingContentCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
			//selectlist를 통해 총 게시물의 갯수를 가져오는데 object가 리턴되어 toString으로 변환해준다.
			//그런데 [] 이상한 붙자가 붙어있어서 제거한 후에 int로 형변환해서
			//res에 담아준다.
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return CompanyCrawlingContentCnt;
	}

}
