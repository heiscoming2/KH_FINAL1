package com.itpro.model.daoImpl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itpro.model.dao.ProjectDao;
import com.itpro.model.dto.project.ProjectDetailDto;
import com.itpro.model.dto.project.ProjectInsertDto;
import com.itpro.model.dto.project.ProjectListDto;
import com.itpro.model.dto.project.ProjectUpdateDto;

@Repository
public class ProjectDaoImpl implements ProjectDao {

	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<ProjectListDto> selectList(Map<String,Object> projectPageMap) {
		List<ProjectListDto> projectList = null;
		
		try {
			projectList = sqlSession.selectList(NAMESPACE+"selectlist",projectPageMap);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[error]: select list");
		}
		
		return projectList;
	}

	
	@Override
	public ProjectDetailDto selectOne(int bd_no) {
		ProjectDetailDto projectDetailDto = null;
		
		
		try {
			projectDetailDto = sqlSession.selectOne(NAMESPACE + "selectone", bd_no);
		} catch (Exception e) {
			System.out.println("[error]: select one");
			e.printStackTrace();
		}
		
		return projectDetailDto;
	}

	@Override
	public int projectInsert(ProjectInsertDto projectDto) {
		int projectInsertres = 0;
		
		try {
			projectInsertres = sqlSession.insert(NAMESPACE+"insert", projectDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return projectInsertres;
	}

	
	@Override
	public int update(ProjectUpdateDto projectDto) {
		int projectUpdateRes = 0;
		
		try {
			projectUpdateRes = sqlSession.update(NAMESPACE+"delete", projectDto);
		} catch (Exception e) {
			System.out.println("[error]: update");
			e.printStackTrace();
		}
		
		return projectUpdateRes; //bizImpl에게 res값 돌려주기
	}

	
	@Override
	public int delete(int bd_no) {
		int projectDeleteRes = 0;
		
		try {
			projectDeleteRes = sqlSession.delete(NAMESPACE+"delete",bd_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return projectDeleteRes;
	}


	@Override
	public int getProjectListCnt() {
		int ProjectListCnt = 0;
		try {
			ProjectListCnt = Integer.parseInt(sqlSession.selectList(NAMESPACE+"selectlistcnt").toString().replace("[","").replace("]", ""));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ProjectListCnt;
	}

	


}
