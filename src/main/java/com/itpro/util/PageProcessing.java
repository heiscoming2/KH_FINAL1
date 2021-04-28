package com.itpro.util;

public class PageProcessing {
	
    /** 한 페이지당 게시글 수 **/
    private int pageSize = 10;
    /** 한 블럭(range)당 페이지 수 **/
    private int rangeSize = 10;
    /** 현재 페이지 **/
    private int curPage = 1;
    /** 현재 블럭(range) **/
    private int curRange = 1;
    /** 총 게시글 수 **/
    private int listCnt;
    /** 총 페이지 수 **/
    private int pageCnt;
    /** 총 블럭(range) 수 **/
    private int rangeCnt;
    /** 시작 페이지 **/
    private int startPage = 1;
    /** 끝 페이지 **/
    private int endPage = 1;
    /** 보여줄 페이지의 시작할 글 번호 **/
    private int startIndex = 0;
    /** 보여줄 페이지의 마지막 글 번호 **/
    private int endIndex = 0;
    /** 이전 페이지 **/
    private int prevPage;
    /** 다음 페이지 **/
    private int nextPage;
    
    public PageProcessing() {

	}
    
    public PageProcessing(int listCnt, int curPage) {
        /**
         * 페이징 처리 순서
         * 1. 총 페이지수
         * 2. 총 블럭(range)수
         * 3. range setting
         */
        
        // 총 게시물 수와 현재 페이지를 Controller로 부터 받아온다.
        /** 현재페이지 **/
        setCurPage(curPage);
        /** 총 게시물 수 **/
        setListCnt(listCnt);
        
        /** 1. 총 페이지 수 **/
        setPageCnt(listCnt);
        /** 2. 총 블럭(range)수 **/
        setRangeCnt(pageCnt);
        /** 3. 블럭(range) setting **/
        rangeSetting(curPage);
        
        /** DB 질의를 위한 startIndex/endIndex 설정 **/
        setStartIndex(curPage);
        setEndIndex(curPage);
    }
    
    
    

    public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public void setPageCnt(int listCnt) {
        this.pageCnt = (int) Math.ceil(listCnt*1.0/pageSize);
    }
    public void setRangeCnt(int pageCnt) {
        this.rangeCnt = (int) Math.ceil(pageCnt*1.0/rangeSize);
    }
    public void rangeSetting(int curPage){
        setCurRange(curPage);        
        this.startPage = (curRange - 1) * rangeSize + 1;
        this.endPage = startPage + rangeSize - 1;
        
        if(endPage > pageCnt){
            this.endPage = pageCnt;
        }
        
        //현재 1블럭이라면, 이전 버튼은 1블럭을 반환아니면
        //현재 블럭에서 1을 빼고(이전 블럭)에서 *10을 해서 10 20 30 단위로 만들고
        //가장 첫번째 page 글 부터 조회하기 위해 -9를 해준다.
        this.prevPage = curRange==1? 1: ((curRange-1)*10)-9;
        
        //현재 블럭이 마지막 블럭이라면
        //현재 블럭에서 +1 하지말고, *10 -9 적용시켜야됨
        this.nextPage = curRange==rangeCnt? ((curRange)*10)-9:((curRange+1)*10)-9;

    }
    public void setCurRange(int curPage) {
        this.curRange = (int)((curPage-1)/rangeSize) + 1;
    }
    
    public void setStartIndex(int curPage) {
        this.startIndex = ((curPage-1)*pageSize)+1;
    }
    
    public void setEndIndex(int curPage) {
    	this.endIndex = curPage*pageSize;
    }

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getCurRange() {
		return curRange;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public int getRangeCnt() {
		return rangeCnt;
	}

	public int getStartIndex() {
		return startIndex;
	}
	
	public int getEndIndex() {
		return endIndex;
	}
    
    
    

}
