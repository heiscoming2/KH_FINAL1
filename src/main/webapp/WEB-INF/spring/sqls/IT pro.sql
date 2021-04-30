--은정 드랍
DROP TABLE  BIZ_MEMBER;
DROP SEQUENCE NOTE_SEQ;
DROP TABLE NOTE;
DROP SEQUENCE EDUCATION_SEQ;
DROP TABLE R_EDUCATION;
DROP SEQUENCE LICENCE_SEQ;
DROP TABLE R_LICENCE;
DROP SEQUENCE CAREER_SEQ;
DROP TABLE R_CAREER;
DROP SEQUENCE RESUME_SEQ;
DROP TABLE M_RESUME;
DROP SEQUENCE MEMBER_SEQ;
DROP TABLE IT_MEMBER;


--성민 드랍
DROP TABLE BANNER;
DROP SEQUENCE BANNER_SEQ;
DROP TABLE BANNER_CLICK;
DROP SEQUENCE AD_SEQ;
DROP TABLE AD_request;
DROP TABLE KAKAO_PAY;
DROP SEQUENCE PAY_SEQ;
DROP SEQUENCE REPORT_SEQ; 
DROP TABLE REPORT;


--효준 드랍
DROP TABLE BOARDCATEGORY;
DROP TABLE COMPANYCRAWLING;
DROP TABLE BOARD;
DROP SEQUENCE BOARDSEQ;
DROP TABLE REPLY;
DROP SEQUENCE STUDYSEQ;
DROP TABLE STUDY;
DROP SEQUENCE REPLYSEQ;
DROP TABLE REPLYRECOMMAND;
DROP TABLE REPLYIMAGE;
DROP SEQUENCE REPLYIMAGESEQ;
DROP TABLE BOARDFILE;
DROP SEQUENCE BOARDFILESEQ;
DROP TABLE BOARDIMAGE;
DROP SEQUENCE BOARDIMAGESEQ;
DROP TABLE BOARDRECOMMAND;
DROP SEQUENCE BOARDRECOMMANDSEQ;


--현지 드랍
DROP TABLE  PORTFOLIO;
DROP SEQUENCE PORTFOLIOSEQ;
DROP TABLE PORTFOLIOPROJECT;
DROP SEQUENCE PORTFOLIOPROJECTSEQ;
DROP TABLE  PORTFOLIOCOMPANY;
DROP SEQUENCE PORTFOLIOCOMPANYSEQ;
DROP TABLE  PROIMG;
DROP SEQUENCE PROIMGSEQ;


--은정 생성
--개인회원
CREATE SEQUENCE MEMBERNO_SEQ NOCACHE;
CREATE TABLE IT_MEMBER (
    M_NO   NUMBER, 
   M_ID    VARCHAR2(50) NOT NULL, 
   M_PW   VARCHAR2(50) NOT NULL,
   M_NAME   VARCHAR2(50) NOT NULL, 
   M_PHONE VARCHAR2(15) NOT NULL, 
   M_EMAIL   VARCHAR2(100) NOT NULL, 
   M_USED   VARCHAR2(2)  NOT NULL, 
   M_ACT    VARCHAR2(10)  NOT NULL,
   M_MAIL_CERT VARCHAR2(2) NOT NULL,
   M_TYPE VARCHAR2(14) NOT NULL,
   M_AUTH VARCHAR2(2)  NOT NULL,
   M_IMG_PATH VARCHAR2(255),
   M_IMG   VARCHAR2(255),
   M_REGDATE DATE,
    
    CONSTRAINT MEMBER_PK PRIMARY KEY (M_NO),
    CONSTRAINT M_ID_UQ UNIQUE(M_ID),
    CONSTRAINT M_PHONE_UQ UNIQUE(M_PHONE),
    CONSTRAINT M_EMAIL_UQ UNIQUE(M_EMAIL),
    CONSTRAINT M_USED_VAL CHECK(M_USED IN('Y','N')),
    CONSTRAINT M_ACT_VAL CHECK(M_ACT IN('활동','정지')),
    CONSTRAINT M_MAIL_CERT_VAL CHECK(M_MAIL_CERT IN('Y','N')),
    CONSTRAINT M_TYPE_VAL CHECK(M_TYPE IN('개인회원','기업회원','관리자')),
    CONSTRAINT M_AUTH_VAL CHECK(M_AUTH IN('Y','N'))
);


SELECT * FROM IT_MEMBER;


--기업회원 생성
CREATE TABLE BIZ_MEMBER (
   M_NO NUMBER,
   M_REGNO VARCHAR2(10) NOT NULL,
    M_ADMIN_CERT   VARCHAR2(2) NOT NULL,
    
    CONSTRAINT BIZ_MNO_PK PRIMARY KEY(M_NO),
    CONSTRAINT BIZ_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE,
    CONSTRAINT M_REGNO_UQ UNIQUE(M_REGNO),
    CONSTRAINT M_ADMIN_CERT_VAL CHECK(M_ADMIN_CERT IN('Y','N'))    
);

SELECT * FROM BIZ_MEMBER;

--개인회원 활동3 정지1
INSERT INTO IT_MEMBER VALUES( 1004,'user1','1234','회원일','010-22222-1111','user1@itpro.com','N','활동','Y','개인회원','N','images/testimages/testprofile.jpg',' ',SYSDATE);--개인회원 활동
INSERT INTO IT_MEMBER VALUES( 1005,'user2','1234','회원이','010-22222-2222','user2@itpro.com','N','활동','Y','개인회원','N','images/testimages/testprofile.jpg ',' ',SYSDATE);--개인회원 활동
INSERT INTO IT_MEMBER VALUES( 1006,'user3','1234','회원삼','010-22222-3333','user3@itpro.com','N','활동','Y','개인회원','N','images/testimages/testprofile.jpg',' ',SYSDATE);--개인회원 활동
INSERT INTO IT_MEMBER VALUES( 1007,'user4','1234','회원사','010-22222-4444','user4@itpro.com','N','정지','Y','개인회원','N','images/testimages/testprofile.jpg',' ',SYSDATE);--개인회원 정지

update IT_MEMBER set M_IMG_PATH='images/testimages/testprofile.jpg';
--기업회원 인증 2, 미인증 1 INSERT문
INSERT ALL
INTO IT_MEMBER VALUES(1000,'biz1','1234','samsung','01099998888','samsung@samsung.com','N','활동','Y','기업회원','N',' ',' ',SYSDATE)
INTO BIZ_MEMBER VALUES(1000,'3216549871','Y')
SELECT * FROM DUAL;

INSERT ALL
INTO IT_MEMBER VALUES(1001,'biz2','1234','lg','01099990000','lg@lg.com','N','활동','Y','기업회원','N',' ',' ',SYSDATE)
INTO BIZ_MEMBER VALUES(1001,'2165654456','N')
SELECT * FROM DUAL;

INSERT ALL
INTO IT_MEMBER VALUES(1002,'biz3','1234','lg','01089790000','sk@sk.com','N','활동','Y','기업회원','N',' ',' ',SYSDATE)
INTO BIZ_MEMBER VALUES(1002,'1656540909','N')
SELECT * FROM DUAL;

--관리자 계정 생성
INSERT 
INTO IT_MEMBER VALUES(1003,'admin','1234','admin','01089792300','admin@admin.com','N','활동','Y','관리자','Y',' ',' ',SYSDATE);

--쪽지 생성
CREATE SEQUENCE NOTE_SEQ NOCACHE;
CREATE TABLE NOTE (
   M_NO NUMBER NOT NULL,
    N_NO NUMBER NOT NULL,
   N_SEND   VARCHAR2(100) NOT NULL,
   N_RECEIVER   VARCHAR2(100) NOT NULL,
   N_CONTENT VARCHAR2(100) NOT NULL,
   N_DATE DATE NOT NULL,
    
    CONSTRAINT NOTE_MNO_PK PRIMARY KEY(M_NO),
    CONSTRAINT NOTE_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE    
    );
    
    SELECT * FROM NOTE;

--이력서 생성
CREATE SEQUENCE RESUME_SEQ NOCACHE;
CREATE TABLE M_RESUME (
    M_NO NUMBER,
   R_NO   NUMBER,
   R_TITLE   VARCHAR2(100) NOT NULL,
   R_NAME   VARCHAR2(15) NOT NULL,
   R_BIRTH   VARCHAR2(15) NOT NULL,
   R_GENDER   VARCHAR2(5) NOT NULL,
   R_PHONE VARCHAR2(10) NOT NULL,
   R_ADDR   VARCHAR2(30) NOT NULL,
   R_EDU   NUMBER NOT NULL,
   R_LICENCE   NUMBER,
   R_CAREER   NUMBER,
   R_SELFLETTER VARCHAR2(1000) NOT NULL,
   R_PORTFOLIO   VARCHAR2(500) NOT NULL,
   R_IMG   VARCHAR2(100) NOT NULL,
   R_IMG_PATH VARCHAR2(1000) NOT NULL,   
    
    CONSTRAINT RESUME_MNO_PK PRIMARY KEY(M_NO),
    CONSTRAINT RESUME_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE,
    CONSTRAINT RESUME_RNO_UQ UNIQUE(R_NO)
    );
    
    SELECT * FROM M_RESUME;
--이력서 교육사항 생성
CREATE SEQUENCE EDUCATION_SEQ NOCACHE;
CREATE TABLE R_EDUCATION (
    R_NO NUMBER,
   ED_NO   NUMBER,
   ED_DATE  VARCHAR2(20) NOT NULL,
    ED_SCHOOL    VARCHAR2(20) NOT NULL,
   ED_GRADUATION VARCHAR2(20) NOT NULL,
    
    CONSTRAINT R_EDUCATION_PK PRIMARY KEY(R_NO),
    CONSTRAINT R_EDUCATION_FK FOREIGN KEY(R_NO) REFERENCES M_RESUME(R_NO) ON DELETE CASCADE
    );
    
    SELECT * FROM R_EDUCATION;
--이력서 경력사항 및 생성
CREATE SEQUENCE CAREER_SEQ NOCACHE;
CREATE TABLE R_CAREER (
    R_NO NUMBER,
    CA_NO   NUMBER,
   CA_TITLE VARCHAR2(50) NOT NULL,
   CA_DATE   VARCHAR2(50)   NOT NULL,
   CA_CONTENT   VARCHAR2(50) NOT NULL,
    
    CONSTRAINT R_CAREER_PK PRIMARY KEY(R_NO),
    CONSTRAINT R_CAREER_FK FOREIGN KEY(R_NO) REFERENCES M_RESUME(R_NO) ON DELETE CASCADE
    );
    SELECT * FROM R_CAREER;

--이력서 자격증 생성
CREATE SEQUENCE LICENCE_SEQ NOCACHE;
CREATE TABLE R_LICENCE (
   R_NO NUMBER,
    LI_NO NUMBER,
   LI_TITLE   VARCHAR2(50) NOT NULL,
   LI_DATE   VARCHAR(50) NOT NULL,
   LI_ORGAN   VARCHAR(50) NOT NULL,
    
    CONSTRAINT R_LICENCE_PK PRIMARY KEY(R_NO),
    CONSTRAINT R_LICENCE_FK FOREIGN KEY(R_NO) REFERENCES M_RESUME(R_NO) ON DELETE CASCADE
    );
    
    SELECT * FROM R_LICENCE;
    
    


--성민 생성

------배너 생성-----------------------------------------
CREATE SEQUENCE BANNER_SEQ NOCACHE;

CREATE TABLE BANNER (
   BANNER_ID   NUMBER,
   BANNER_TYPE   VARCHAR2(20),
   COMPANY_NAME VARCHAR2(50),
   BANNER_DATE   DATE DEFAULT SYSDATE,
   BANNER_END   DATE,
   BANNER_PERIOD VARCHAR2(500),
   BANNER_IMAGE VARCHAR2(50),
   BANNER_URL VARCHAR2(50),
   M_NO NUMBER,
    CONSTRAINT BANNER_ID_PK PRIMARY KEY(BANNER_ID),
    CONSTRAINT BANNER_ID_FK FOREIGN KEY(BANNER_ID) REFERENCES BANNER(BANNER_ID),
    CONSTRAINT BANNER_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO)
);

SELECT * FROM BANNER;
DROP TABLE BANNER_CLICK;

------배너클릭수 생성-----------------------------------------
CREATE TABLE BANNER_CLICK (
   BANNER_ID NUMBER,
   BANNER_CLICKCOUNT NUMBER,
   BANNER_ip VARCHAR2(50),
    CONSTRAINT BANNER_CLICK_PK PRIMARY KEY(BANNER_ID),
    CONSTRAINT BANNER_CLICK_FK FOREIGN KEY(BANNER_ID) REFERENCES BANNER(BANNER_ID)
);

SELECT * FROM BANNER_CLICK;



--광고 문의 생성-----------------------------------------
CREATE SEQUENCE AD_SEQ NOCACHE;

CREATE TABLE AD_REQUEST (
   AD_SEQ NUMBER,
   M_NO NUMBER,
   B_AUTH VARCHAR2(5),
   AD_TITLE VARCHAR2(50),
   AD_TYPE VARCHAR2(15),
   AD_NAME VARCHAR2(15),
   AD_STARTDATE DATE,
   AD_ENDDATE DATE,
   AD_PERIOD VARCHAR2(500),
   AD_IMAGE VARCHAR2(50),
   AD_URL VARCHAR2(50),
   AD_PRICE NUMBER,
   AD_STATUS VARCHAR2(50),
    CONSTRAINT AD_SEQ_PK PRIMARY KEY(AD_SEQ),
    CONSTRAINT AD_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO),
    CONSTRAINT B_AUTH_VAL CHECK(B_AUTH IN('Y','N')),
    CONSTRAINT AD_TYPE_VAL CHECK(AD_TYPE IN('COMPUTER','GAME','MOVIE','EDUCATION','MEDICAL','ETC')),
    CONSTRAINT AD_STATUS_VAL CHECK(AD_TYPE IN('결제대기','결제중','결제완료','결제실패'))
);

SELECT * FROM AD_REQUEST;




--카카오페이 결제관리 생성-----------------------------------------
CREATE SEQUENCE PAY_SEQ NOCACHE;
CREATE TABLE KAKAO_PAY (
   AD_SEQ NUMBER,
   M_NO NUMBER,
   PAYMETHOD VARCHAR2(50),
   APPLDATE DATE DEFAULT SYSDATE,
   BUYERNAME VARCHAR2(50),
   BUYERTELL VARCHAR2(50),
   BUYEREMAIL VARCHAR2(50),
    CONSTRAINT KAKAO_PAY_AD_SEQ_PK PRIMARY KEY(AD_SEQ),
    CONSTRAINT KAKAO_PAY_AD_SEQ_FK FOREIGN KEY(AD_SEQ) REFERENCES AD_REQUEST(AD_SEQ),
    CONSTRAINT PAYMETHOD_VAL CHECK(PAYMETHOD IN('신용카드/체크카드','무통장입금','카카오페이'))
);

SELECT * FROM KAKAO_PAY;




--신고관리 DROP-----------------------------------------
CREATE SEQUENCE REPORT_SEQ NOCACHE;
CREATE TABLE REPORT (
   REPORT_SEQ NUMBER,
   M_NO NUMBER,
   REPORT_BOARD VARCHAR2(100),
   REPORT_TYPE VARCHAR2(100),
   CRIMINAL_ID VARCHAR2(50),
   REPORT_REASON VARCHAR2(100),
   REPORT_DATE   DATE DEFAULT SYSDATE,
    CONSTRAINT REPORT_SEQ_PK PRIMARY KEY(REPORT_SEQ),
    CONSTRAINT REPORT_M_NO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO),
    CONSTRAINT REPORT_TYPE_VAL CHECK(REPORT_TYPE IN('게시글','댓글')),
    CONSTRAINT CRIMINAL_ID_FK FOREIGN KEY(CRIMINAL_ID) REFERENCES IT_MEMBER(M_ID)
);

SELECT * FROM REPORT;


--효준 생성

/* BOARDCATEGORY 드랍 및 생성 */

CREATE TABLE BOARDCATEGORY (
    CODE NUMBER,
    NAME VARCHAR2(50)
);

/* BOARDCATEGORY DB 추가*/
INSERT INTO BOARD_CATEGORY VALUES(1,'프로젝트');
/*아래 INSERT 구문 중 Q&A에서 &이 특수문자로 인식되어 ESCAPE 해주기 위해 SET DEFINE OFF & 사용*/
SET DEFINE OFF &; 
INSERT INTO BOARD_CATEGORY VALUES(2,'Q&A');
INSERT INTO BOARD_CATEGORY VALUES(3,'스터디구인');
INSERT INTO BOARD_CATEGORY VALUES(4,'기업 채용정보');
INSERT INTO BOARD_CATEGORY VALUES(5,'공지사항');
/* BOARDCATEGORY 카테고리 종료 */

/* COMPANYCRAWLING; 드랍 및 생성 */

CREATE TABLE COMPANYCRAWLING(
    CC_CODE NUMBER,
    CC_NAME VARCHAR2(100) NOT NULL,
    CC_TITLE VARCHAR2(300) NOT NULL,
    CC_CAREER VARCHAR2(20) NOT NULL,
    CC_EDUCATION VARCHAR2(20) NOT NULL,
    CC_META VARCHAR2(100) NOT NULL,
    CC_ADDR1 VARCHAR2(30) NOT NULL,
    CC_ADDR2 VARCHAR2(30) NOT NULL,
    CC_DEADLINE VARCHAR2(15) NOT NULL,
    CC_CARLEVEL NUMBER NOT NULL,
    CC_EDULEVEL NUMBER NOT NULL
);

/* COMPANYCRAWLING DB 추가 */
/* 채용정보 -> 새로고침 버튼 클릭 시 추가됨 */

/* BOARD 드랍 및 생성 */

CREATE SEQUENCE BOARDSEQ NOCACHE;
CREATE TABLE BOARD (
    BD_NO NUMBER PRIMARY KEY,
    BD_TITLE VARCHAR2(100) NOT NULL,
    BD_CONTENT CLOB NOT NULL,
    BD_CREATEDDATE DATE NOT NULL,
    BD_MODIFYDATE DATE,
    BD_VIEWCOUNT NUMBER,
    BD_RECOMMANDCOUNT NUMBER,
    BD_WRITERIP VARCHAR2(30),
    BC_CODE NUMBER,
    M_NO NUMBER,
    BD_REPLYCOUNT NUMBER
);



/* STUDY 드랍 및 생성 */

CREATE SEQUENCE STUDYSEQ NOCACHE;
CREATE TABLE STUDY (
   BD_NO NUMBER,
   ST_STATUS CHAR(1),
   ST_ADDR1 VARCHAR2(30),
   ST_ADDR2 VARCHAR2(30),
   ST_ADDRDETAIL VARCHAR2(100),
   ST_NOWPERSON NUMBER,
   ST_CLOSEPERSON NUMBER,
   CONSTRAINT STUDY_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO),
   CONSTRAINT STUDY_BDNO_PK PRIMARY KEY(BD_NO)	
);



/* REPLY 테이블,시퀀스 드랍 및 생성 */

CREATE SEQUENCE REPLYSEQ NOCACHE;
CREATE TABLE REPLY (
   RE_NO NUMBER PRIMARY KEY,
   RE_CREATEDDATE DATE NOT NULL,
   RE_MODIFYDATE DATE,
   RE_CONTENT CLOB NOT NULL,
   RE_WRITERIP VARCHAR2(30),
   M_NO NUMBER,
   RE_RECOMMANDCOUNT NUMBER,
   BD_NO NUMBER
);

/* REPLYRECOMMAND 테이블 드랍 및 생성 */

CREATE TABLE REPLYRECOMMAND(
   RE_NO NUMBER,
   M_NO NUMBER,
   RR_RECOMMANDDATE DATE,
   CONSTRAINT REPLYRECOMMAND_RENO_FK FOREIGN KEY(RE_NO) REFERENCES REPLY(RE_NO),
   CONSTRAINT REPLYRECOMMAND_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO),
   CONSTRAINT REPLYRECOMMAND_RENOwithMNO_PK PRIMARY KEY(RE_NO,M_NO)
);

/* REPLYIMAGE 테이블,시퀀스 드랍 및 생성 */

CREATE SEQUENCE REPLYIMAGESEQ NOCACHE;
CREATE TABLE REPLYIMAGE(
   RI_NO NUMBER PRIMARY KEY,
   RI_ORIGINNAME VARCHAR2(100) NOT NULL,
   RI_REALNAME VARCHAR2(100) NOT NULL,
   RI_SIZE NUMBER NOT NULL,
   RI_WIDTH NUMBER NOT NULL,
   RI_HEIGHT NUMBER NOT NULL,
   RI_TYPE VARCHAR2(15) NOT NULL,
   RI_PATH VARCHAR2(50) NOT NULL,
   RE_NO NUMBER
);



/* BOARDFILE 테이블,시퀀스 드랍 및 생성 */

CREATE SEQUENCE BOARDFILESEQ NOCACHE;
CREATE TABLE BOARDFILE(
   BF_NO NUMBER PRIMARY KEY,
   BF_ORIGINNAME VARCHAR2(100),
   BF_REALNAME VARCHAR2(100),
   BF_SIZE NUMBER NOT NULL,
   BF_TYPE NUMBER NOT NULL,
   BF_PATH VARCHAR2(50) NOT NULL,
   BD_NO NUMBER
);


/* BOARDIMAGE 테이블,시퀀스 드랍 및 생성 */

CREATE SEQUENCE BOARDIMAGESEQ NOCACHE;
CREATE TABLE BOARDIMAGE(
   BI_NO NUMBER PRIMARY KEY,
   BI_ORIGIN_NAME VARCHAR2(100) NOT NULL,
   BI_REAL_NAME VARCHAR2(100) NOT NULL,
   BI_SIZE NUMBER NOT NULL,
   BI_WIDTH NUMBER NOT NULL,
   BI_HEIGHT NUMBER NOT NULL,
   BI_TYPE VARCHAR2(15),
   BI_PATH VARCHAR2(50) NOT NULL,
   BD_NO NUMBER
);

/* BOARDRECOMMAND 테이블,시퀀스 드랍 및 생성 */

CREATE SEQUENCE BOARDRECOMMANDSEQ NOCACHE;
CREATE TABLE BOARDRECOMMAND(
   BD_NO NUMBER,
   M_NO NUMBER,
   BR_RECOMMAND_DATE DATE,
   CONSTRAINT BOARDRECOMMAND_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO),
   CONSTRAINT BOARDRECOMMAND_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO),   
   CONSTRAINT BOARDRECOMMAND_BDNOwithMNO_PK PRIMARY KEY(BD_NO,M_NO)
);



--현지생성


--PORTFOLIO 테이블 생성
CREATE SEQUENCE PORTFOLIOSEQ NOCACHE;
CREATE TABLE PORTFOLIO (
   BD_NO NUMBER NOT NULL,
   PORT_PRIZE VARCHAR2(200),
   PORT_DEVELOP VARCHAR2(2000) NOT NULL,
   PORT_NAME VARCHAR2(100) NOT NULL,
   PORT_EDU   VARCHAR2(100),
   PORT_EMAIL VARCHAR2(100) NOT NULL,
   PORT_PHONE   VARCHAR2(100),
   PORT_LINK VARCHAR2(100),
   PORT_TITLE VARCHAR2(100) NOT NULL,
   PORT_EDU_START DATE,
   PORT_EDU_END DATE,
   CONSTRAINT PORTFOLIO_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO),
   CONSTRAINT PORTFOLIO_BDNO_PK PRIMARY KEY(BD_NO)
);

SELECT * FROM PORTFOLIO;



--PORTFOLIOPROJECT 테이블 DROP 


--PORTFOLIOPROJECT 테이블 생성
CREATE SEQUENCE PORTFOLIOPROJECTSEQ NOCACHE;
CREATE TABLE PORTFOLIOPROJECT (
   PRO_NO    NUMBER PRIMARY KEY,
   PRO_TITLE   VARCHAR2(200) NOT NULL,
   PRO_START    DATE NOT NULL,
   PRO_END DATE NOT NULL,
   PRO_LINK VARCHAR2(200),
   PRO_DEVELOP VARCHAR2(200) NOT NULL,
   PRO_GOAL   VARCHAR2(500) NOT NULL,
   PRO_FUNCTION   VARCHAR2(2000) NOT NULL,
   PRO_ERD VARCHAR2(200),
   BD_NO NUMBER
);

SELECT * FROM PORTFOLIOPROJECT;

--PORTFOLIOCOMPANY 테이블 DROP 


--PORTFOLIOCOMPANY 테이블 생성
CREATE SEQUENCE PORTFOLIOCOMPANYSEQ NOCACHE;
CREATE TABLE PORTFOLIOCOMPANY (
    PORT_CO_NO   NUMBER PRIMARY KEY,
   PORT_COMPANY    VARCHAR2(200),
   PORT_CO_START   DATE,
   PORT_CO_END DATE,
   PORT_WORK   VARCHAR2(10) NOT NULL,
    BD_NO NUMBER,
    CONSTRAINT PORT_WORK_VAL CHECK(PORT_WORK IN('Y','N'))
);

SELECT * FROM PORTFOLIOCOMPANY;

--PROIMG 테이블 DROP 


--PROIMG 테이블 생성 
CREATE SEQUENCE PROIMGSEQ NOCACHE;
CREATE TABLE PROIMG (
   PRO_IMG_NO   NUMBER PRIMARY KEY,
   PRO_ORIGIN_NAME   VARCHAR2(100) NOT NULL,
   PRO_REAL_NAME    VARCHAR2(100) NOT NULL,
   PRO_IMG_SIZE NUMBER NOT NULL,
   PRO_IMG_WIDTH NUMBER NOT NULL,
   PRO_IMG_HEIGHT NUMBER NOT NULL,
   PRO_IMG_TYPE  VARCHAR2(15),
   PRO_IMG_PATH   VARCHAR2(50) NOT NULL,
   PRO_NO    NUMBER
);

SELECT * FROM PROIMG;

COMMIT;