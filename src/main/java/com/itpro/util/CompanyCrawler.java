package com.itpro.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itpro.model.dto.CompanyCrawlingDto;

public class CompanyCrawler {
	
	private Logger logger = LoggerFactory.getLogger(CompanyCrawler.class);
	
	//채용 정보 디테일 URL의 주소 앞부분 뒤에 NNNNNNN 식별 값만 붙여주는 주소 패턴
	//리스트 뿌려줄때, 이거를 컨트롤러에서 호출해서 MODEL에 담아서 JSP단에서 ${DETAILURL}${NNNN패턴} 이런 식으로 주소값을 주어서 처리한다.
	String Detail_URL="https://www.saramin.co.kr/zf_user/jobs/relay/view?isMypage=no&rec_idx=";
	
	//순서대로 총 채용 공고수 , 페이지당 채용 공고수, 총 페이지수
	private int all_of_post_cnt;
	private int post_of_page;
	private int all_of_page_cnt;
	
	//URL을 통해 전체 채용 공고수, 페이지당 공고수, 총 페이지수를 계산하여 필드에 저장하는 메서드
	public void updateUrlInfo() {
		
		//DOCUMENT를 가져올 URL 주소
		String url = "https://www.saramin.co.kr/zf_user/jobs/list/job-category?page=1&"
				   + "cat_cd=404%2C407%2C408%2C402%2C409%2C416%2C413%2C412%2C411%2C410&"
				   + "search_optional_item=n&"
				   + "search_done=y&"
				   + "panel_count=y%5Cr%5Cn&isAjaxRequest=0&"
				   + "page_count=50&"
				   + "sort=RL&type=job-category&"
				   + "is_param=1&"
				   + "isSearchResultEmpty=1&"
				   + "isSectionHome=0&"
				   + "searchParamCount=1#searchTitle";
		//URL을 Jsoup 커넥트 메서드한테 전달해서 Document를 받는다.
		Document doc;
		try {
			doc = (Document) Jsoup.connect(url).get();
			//document에서 total_count 클래스를 부여받은 태그에서 자식 em 태그의 text를 가져오는데 ,를 빼고 가져온다.
			all_of_post_cnt = Integer.parseInt(doc.select(".total_count > em").text().replaceAll(",",""));
			//페이지당 게시글을 직접 설정할 수 있다. 230개 이상도 가능한거 같은데 크롤링시 오류가나서 페이지당 230개씩만 조회를 한다.
			post_of_page = 230;
			//전체 페이지수를 계산하는데, 전체공고수/230(페이지당 공고수)가 0으로 맞아 떨어지면 총 페이지는 그대로고 0이 아닌 경우 +1을 해주면 총 페이지가 나온다
			all_of_page_cnt = all_of_post_cnt%post_of_page==0? all_of_post_cnt/post_of_page:all_of_post_cnt/post_of_page+1;
		} catch (IOException e) {
			System.out.println("updateUrlInfo()");
			e.printStackTrace();
		}
		
	}
	
	//필드값을 이용해서 모든 페이지를 돌면서 채용정보를 LIST로 담아둔당
	public List<CompanyCrawlingDto> getCompanyCrawlingList() {
		//필드값 초기화를 먼저 수행
		updateUrlInfo();
		//채용정보 1건을 담을 dto 생성
		CompanyCrawlingDto companycrawlingdto = new CompanyCrawlingDto();
		//채용정보들을 담을 list 생성
		List<CompanyCrawlingDto> companycrawlinglist = new ArrayList<CompanyCrawlingDto>();
		//이중 for문을 도는데 첫 for문은 페이지 수이다.
		//매 페이지마다 url의 document를 가지고
		//채용정보와 관련된 엘리먼트만을 추출한다.
		//그리고 추출한 엘리먼트를 for문을 통해서(각 건의 채용정보를) DTO에 담아서 LIST에 담는다.
		for(int i=1; i<all_of_page_cnt; i++) {
			String url = "https://www.saramin.co.kr/zf_user/jobs/list/job-category?page"+i+"&"
					   + "cat_cd=404%2C407%2C408%2C402%2C409%2C416%2C413%2C412%2C411%2C410&"
					   + "search_optional_item=n&search_done=y&"
					   + "panel_count=y%5Cr%5Cn&isAjaxRequest=0&"
					   + "page_count="+post_of_page+"&"
					   + "sort=RL&"
					   + "type=job-category&"
					   + "is_param=1&"
					   + "isSearchResultEmpty=1&"
					   + "isSectionHome=0&"
					   + "searchParamCount=1#searchTitle";
			try {
				Document doc=Jsoup.connect(url).get();
				
				
				
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		}
		
		return companycrawlinglist;
	}
	


}
