
--현지 드랍
DROP TABLE  PORTFOLIO;
DROP SEQUENCE PORTFOLIOSEQ;
DROP TABLE PROJECT;
DROP SEQUENCE PROJECTSEQ;
DROP TABLE  PROIMG;
DROP SEQUENCE PROIMGSEQ;


--성민 드랍 (신고 게시글/댓글)
DROP TABLE REPORT_REPLY;
DROP SEQUENCE REPORT_SEQ;
DROP TABLE REPORT;

--효준 드랍
DROP TABLE REPLYRECOMMAND;
DROP TABLE STUDY;
DROP SEQUENCE STUDYSEQ;
DROP TABLE COMPANYAPPLICATIONINFO;
DROP TABLE COMPANY;
DROP TABLE REPLYIMAGE;
DROP SEQUENCE REPLYIMAGESEQ;
DROP TABLE REPLY;
DROP SEQUENCE REPLYSEQ;
DROP SEQUENCE GROUPNOSEQ;
DROP TABLE BOARDFILE;
DROP SEQUENCE BOARDFILESEQ;
DROP TABLE BOARDIMAGE;
DROP SEQUENCE BOARDIMAGESEQ;
DROP TABLE BOARDRECOMMAND;
DROP TABLE BOARD;
DROP SEQUENCE BOARDSEQ;
DROP TABLE BOARDCATEGORY;
DROP TABLE COMPANYCRAWLING;

--성민 드랍
DROP TABLE BANNER_CLICK;
DROP TABLE KAKAO_PAY;
DROP SEQUENCE PAY_SEQ;
DROP TABLE BANNER;
DROP SEQUENCE BANNER_SEQ;
DROP SEQUENCE AD_SEQ;
DROP TABLE AD_request;
DROP SEQUENCE REPORT_REPLY_SEQ ;


--은정 드랍
DROP TABLE NOTE;
DROP SEQUENCE NOTE_SEQ;
DROP SEQUENCE EDUCATION_SEQ;
DROP TABLE EDUCATION;
DROP SEQUENCE LICENCENO_SEQ;
DROP TABLE LICENCE;
DROP SEQUENCE CAREERNO_SEQ;
DROP TABLE CAREER;
DROP SEQUENCE M_RESUME_IMG_SEQ;
DROP TABLE M_RESUME_IMG;
DROP SEQUENCE RESUMENO_SEQ;
DROP TABLE M_RESUME;
DROP TABLE  BIZ_MEMBER;
DROP SEQUENCE MEMBERNO_SEQ;
DROP TABLE IT_MEMBER;



--개인회원
CREATE SEQUENCE MEMBERNO_SEQ NOCACHE;
CREATE TABLE IT_MEMBER (
    M_NO   NUMBER, 
    M_ID    VARCHAR2(50) NOT NULL, 
    M_PW   VARCHAR2(50) NOT NULL,
    M_NICKNAME   VARCHAR2(50) NOT NULL, 
    M_PHONE VARCHAR2(15) NOT NULL, 
    M_EMAIL   VARCHAR2(100) NOT NULL,     
    M_USED   VARCHAR2(2)  NOT NULL, 
    M_ACT    VARCHAR2(10)  NOT NULL,
    M_MAIL_CERT VARCHAR2(20) NOT NULL,
    M_TYPE VARCHAR2(14) NOT NULL,
    M_AUTH VARCHAR2(2)  NOT NULL,    
    M_IMG_PATH VARCHAR2(255),
    M_IMG   VARCHAR2(255),
    M_REGDATE DATE NOT NULL,
    M_NAME VARCHAR2(20),
    M_BIRTH DATE,
    M_GENDER VARCHAR2(50),
    M_RESUMECHK VARCHAR2(10), --이력서 작성 여부 작성Y 미작성N
   
    
    CONSTRAINT MEMBER_PK PRIMARY KEY (M_NO),
    CONSTRAINT M_ID_UQ UNIQUE(M_ID),
    CONSTRAINT M_PHONE_UQ UNIQUE(M_PHONE),
    CONSTRAINT M_EMAIL_UQ UNIQUE(M_EMAIL),
    CONSTRAINT M_NICKNAME_UQ UNIQUE(M_NICKNAME),
    CONSTRAINT M_USED_VAL CHECK(M_USED IN('Y','N')),
    CONSTRAINT M_ACT_VAL CHECK(M_ACT IN('활동','정지')),
    CONSTRAINT M_TYPE_VAL CHECK(M_TYPE IN('개인회원','기업회원','관리자')),
    CONSTRAINT M_AUTH_VAL CHECK(M_AUTH IN('Y','N')),
    CONSTRAINT M_GENDER_VAL CHECK(M_GENDER IN('남','여')),
    CONSTRAINT M_RESUMECHK_VAL CHECK(M_RESUMECHK IN('Y','N'))
);

SELECT * FROM IT_MEMBER;




--기업회원 생성
CREATE TABLE BIZ_MEMBER (
   M_NO NUMBER,
   M_REGNO VARCHAR2(14) NOT NULL,
   M_ADMIN_CERT   VARCHAR2(2) NOT NULL,
    
    CONSTRAINT BIZ_MNO_PK PRIMARY KEY(M_NO),
    CONSTRAINT BIZ_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE,
    CONSTRAINT M_REGNO_UQ UNIQUE(M_REGNO),
    CONSTRAINT M_ADMIN_CERT_VAL CHECK(M_ADMIN_CERT IN('Y','N'))    
);

SELECT * FROM BIZ_MEMBER;

        
commit;

--쪽지 생성
CREATE SEQUENCE NOTE_SEQ NOCACHE;
CREATE TABLE NOTE (
    N_NO NUMBER NOT NULL, --쪽지 번호
   N_SENDER   NUMBER NOT NULL, --보낸 사람 회원번호
   N_RECEIVER   NUMBER NOT NULL, --받는 사람 회원번호
   N_TITLE VARCHAR2(100) NOT NULL,--제목
   N_CONTENT VARCHAR2(1000) NOT NULL, --내용
   N_SENDDATE DATE NOT NULL, --보낸시간
    N_READDATE DATE ,--읽은시간
    
    CONSTRAINT NOTE_NNO_PK PRIMARY KEY(N_NO),
    CONSTRAINT NOTE_N_SENDER_FK FOREIGN KEY( N_SENDER) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE,    
    CONSTRAINT NOTE_N_RECEIVER_FK FOREIGN KEY(N_RECEIVER) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE
    );
    
    SELECT * FROM NOTE;


--이력서 생성
CREATE SEQUENCE RESUMENO_SEQ NOCACHE;
CREATE TABLE M_RESUME (
    M_NO NUMBER,
    R_NO   NUMBER,
    R_TITLE   VARCHAR2(100) NOT NULL,
    R_POSTCODE VARCHAR2(50), --우편번호
    R_ROADADDRESS VARCHAR2(50), --도로명주소
    R_JIBUNADDRESS VARCHAR2(50), --지번주소
    R_DETAILADDRESS VARCHAR2(50), --상세주소
    R_EXTRAADDRESS VARCHAR2(50), --참고항목
    R_SELFLETTER LONG NOT NULL,
    R_PORTFOLIO   VARCHAR2(500) NOT NULL,
    R_IMG   VARCHAR2(100) NOT NULL,
    R_IMG_PATH VARCHAR2(1000) NOT NULL,  
    R_REGDATE DATE NOT NULL,
    
    CONSTRAINT RESUME_MNO_PK PRIMARY KEY(R_NO),
    CONSTRAINT RESUME_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE
    );
    
    SELECT * FROM M_RESUME;
   
    --이력서 이미지 저장 테이블
    CREATE SEQUENCE M_RESUME_IMG_SEQ NOCACHE;
    CREATE TABLE M_RESUME_IMG (   
    R_NO   NUMBER,    
    R_IMG   VARCHAR2(100) NOT NULL,
    R_IMG_PATH VARCHAR2(1000) NOT NULL,  
    
    CONSTRAINT M_RESUME_IMG_PK PRIMARY KEY(R_NO));
    
    SELECT * FROM M_RESUME_IMG;
    
   
--경력사항 및 생성

CREATE SEQUENCE CAREERNO_SEQ NOCACHE;
CREATE TABLE CAREER (
    M_NO NUMBER,
    CA_NO   NUMBER,
    CA_TITLE VARCHAR2(50) NOT NULL,
    CA_CONTENT   VARCHAR2(50) NOT NULL,
    CA_START_DATE DATE NOT NULL,
    CA_END_DATE DATE,
    
    CONSTRAINT CAREER_PK PRIMARY KEY(CA_NO),
    CONSTRAINT CAREER_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE
    );
    
    SELECT * FROM CAREER;    
 
    
--자격증 생성

CREATE SEQUENCE LICENCENO_SEQ NOCACHE;
CREATE TABLE LICENCE (
    M_NO NUMBER,
    LI_NO NUMBER,
    LI_TITLE   VARCHAR2(50) NOT NULL,
    LI_DATE  DATE NOT NULL,
    LI_ORGAN   VARCHAR(50) NOT NULL,
    
    CONSTRAINT LICENCE_PK PRIMARY KEY(LI_NO),
    CONSTRAINT LICENCE_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE
    );
    
    SELECT * FROM LICENCE;
    

 DROP SEQUENCE EDUCATION_SEQ;
DROP TABLE EDUCATION;
--학력사항 생성
CREATE SEQUENCE EDUCATION_SEQ NOCACHE;
CREATE TABLE EDUCATION (
    M_NO NUMBER,
    ED_NO NUMBER,
    ED_STARTDATE DATE NOT NULL,
    ED_GRADUDATE  DATE,
    ED_SCHOOLNAME VARCHAR2(100) NOT NULL,
    ED_GRADUATION VARCHAR2(50) NOT NULL, --1-졸업 / 2-휴학 / 3-중퇴 / 4-재학
    ED_MAJOR VARCHAR2(50) NOT NULL,
    ED_SCHOOL VARCHAR2(20) NOT NULL,
    
    CONSTRAINT EDUCATION_PK PRIMARY KEY(ED_NO),
    CONSTRAINT EDUCATION_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO) ON DELETE CASCADE,
    CONSTRAINT ED_GRADUATION_VAL CHECK(ED_GRADUATION IN('졸업','휴학','중퇴','재학')),
     CONSTRAINT ED_SCHOOL_VAL CHECK(ED_SCHOOL IN('대학원','대학교','고등학교'))
    );
    

    
  SELECT * FROM EDUCATION;
        
        

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
   BD_NO NUMBER,
   AD_TITLE VARCHAR2(50),
   AD_TYPE VARCHAR2(15),
   AD_NAME VARCHAR2(15),
   AD_STARTDATE DATE,
   AD_ENDDATE DATE,
   AD_IMAGE VARCHAR2(50),
   AD_URL VARCHAR2(50),
   AD_PRICE NUMBER,
   AD_STATUS VARCHAR2(50),
    CONSTRAINT AD_SEQ_PK PRIMARY KEY(AD_SEQ)
);

SELECT * FROM AD_REQUEST;




--카카오페이 결제관리 생성-----------------------------------------
CREATE SEQUENCE PAY_SEQ NOCACHE;
CREATE TABLE KAKAO_PAY (
   AD_SEQ NUMBER,
   M_NO NUMBER,
   PAYMETHOD VARCHAR2(50),
   REGDATE DATE DEFAULT SYSDATE,

    CONSTRAINT KAKAO_PAY_AD_SEQ_PK PRIMARY KEY(AD_SEQ)
);

SELECT * FROM KAKAO_PAY;







--효준 생성

/* CATEGORY 드랍 및 생성 */

    CREATE TABLE BOARDCATEGORY (
        CODE NUMBER,
        NAME VARCHAR2(50)
);

/* BOARDCATEGORY DB 추가*/
select * from boardcategory;



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
    BD_WRITERIP VARCHAR2(30),
    BC_CODE NUMBER,
    M_NO NUMBER
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


/* COMPANY 생성 */
CREATE TABLE COMPANY (

    BD_NO NUMBER,
    CP_NAME VARCHAR2(100),
    CP_META VARCHAR2(300),
    CP_CAREER VARCHAR2(50),
    CP_EDUCATION VARCHAR2(50),
    CP_ADDR1 VARCHAR2(50),
    CP_ADDR2 VARCHAR2(50),
    CP_ADDRDETAIL VARCHAR2(50),
    CP_DEADLINE VARCHAR2(50),
    CP_STATUS CHAR(1),
    CP_IMG VARCHAR2(200),
    CP_IMG_PATH VARCHAR2(200),
    
    CONSTRAINT COMPANY_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO),
    CONSTRAINT COMPANY_BDNO_PK PRIMARY KEY(BD_NO)   
    
);


CREATE TABLE COMPANYAPPLICATIONINFO (
    BD_NO NUMBER,
    R_NO NUMBER,
    CA_DATE DATE,
    CA_STATUS CHAR(1),
    CONSTRAINT CAINFO_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES COMPANY(BD_NO),
    CONSTRAINT CAINFO_RNO_FK FOREIGN KEY(R_NO) REFERENCES M_RESUME(R_NO),
    CONSTRAINT CAINFO_BDNOwithRNO_PK PRIMARY KEY(BD_NO,R_NO)       
);




/* REPLY 테이블,시퀀스 드랍 및 생성 */
CREATE SEQUENCE GROUPNOSEQ NOCACHE;
CREATE SEQUENCE REPLYSEQ NOCACHE;
CREATE TABLE REPLY (
   RE_NO NUMBER PRIMARY KEY,
   RE_CREATEDDATE DATE NOT NULL,
   RE_MODIFYDATE DATE,
   RE_CONTENT CLOB NOT NULL,
   RE_WRITERIP VARCHAR2(30),
   M_NO NUMBER,
   BD_NO NUMBER,
   RE_GROUPNO NUMBER,
   RE_GROUPORDERNO NUMBER,
   RE_DEPTH NUMBER,
   RE_PARENTNO NUMBER,
   RE_ISHIDDEN CHAR
);

SELECT*FROM REPLY;
/* REPLYRECOMMAND 테이블 생성 */
SELECT A.RE_NO, D.NAME, C.BD_TITLE, A.RE_CONTENT 
		FROM REPLY A 
        INNER JOIN IT_MEMBER B
        ON A.M_NO= B.M_NO
        INNER JOIN BOARD C
        ON A.BD_NO=C.BD_NO
        INNER JOIN BOARDCATEGORY D
		ON C.BC_CODE=D.CODE
        WHERE A.RE_NO=3;	


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

CREATE TABLE BOARDRECOMMAND(
   BD_NO NUMBER,
   M_NO NUMBER,
   BR_RECOMMAND_DATE DATE,
   CONSTRAINT BOARDRECOMMAND_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO),
   CONSTRAINT BOARDRECOMMAND_MNO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO),   
   CONSTRAINT BOARDRECOMMAND_BDNOwithMNO_PK PRIMARY KEY(BD_NO,M_NO)
);

--신고관리_게시글-----------------------------------------
CREATE SEQUENCE REPORT_SEQ NOCACHE;
CREATE TABLE REPORT (
   REPORT_NO NUMBER,
   M_NO NUMBER,
   BD_NO NUMBER,
   NAME VARCHAR2(20),
   BD_TITLE VARCHAR2(100),
   REPORT_REASON VARCHAR2(100),
   REPORT_DATE   DATE DEFAULT SYSDATE,
   
    CONSTRAINT M_NO_PK PRIMARY KEY(REPORT_NO,M_NO),
    CONSTRAINT REPORT_M_NO_FK FOREIGN KEY(M_NO) REFERENCES IT_MEMBER(M_NO),
    CONSTRAINT REPORT_BD_NO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO)
);

SELECT * FROM REPORT;

 


--신고관리_댓글-----------------------------------------
CREATE SEQUENCE REPORT_REPLY_SEQ NOCACHE;
CREATE TABLE REPORT_REPLY (
   REPORT_REPLY_NO NUMBER PRIMARY KEY,
   M_NO NUMBER,
   BD_NO NUMBER,
   RE_NO NUMBER,
   NAME VARCHAR2(20),
   BD_TITLE VARCHAR2(100),
   REPORT_REASON VARCHAR2(100),
   REPORT_DATE DATE DEFAULT SYSDATE
);


SELECT * FROM REPORT_REPLY;


--현지생성




--PORTFOLIO 테이블 생성
CREATE SEQUENCE PORTFOLIOSEQ NOCACHE;
CREATE TABLE PORTFOLIO (
   BD_NO NUMBER NOT NULL,
   PORT_PRIZE VARCHAR2(200),
   PORT_DEVELOP VARCHAR2(2000) NOT NULL,
   PORT_LINK VARCHAR2(100),
   CONSTRAINT PORTFOLIO_BDNO_FK FOREIGN KEY(BD_NO) REFERENCES BOARD(BD_NO),
   CONSTRAINT PORTFOLIO_BDNO_PK PRIMARY KEY(BD_NO)
);

SELECT * FROM PORTFOLIO;



--PROJECT 테이블 DROP 


--PROJECT 테이블 생성
CREATE SEQUENCE PROJECTSEQ NOCACHE;
CREATE TABLE PROJECT (
   PRO_NO NUMBER PRIMARY KEY,
   PRO_TITLE VARCHAR2(200) NOT NULL,
   PRO_START DATE NOT NULL,
   PRO_END DATE NOT NULL,
   PRO_FILE_PATH VARCHAR2(200),
   PRO_LINK VARCHAR2(200),
   PRO_DEVELOP VARCHAR2(200) NOT NULL,
   PRO_GOAL VARCHAR2(500) NOT NULL,
   PRO_FUNCTION VARCHAR2(2000) NOT NULL,
   PRO_ERD VARCHAR2(200),
   BD_NO NUMBER
);

SELECT * FROM PROJECT;




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


select * from BIZ_MEMBER;

----------------------------------------------------------------------------------------------------------------


-- DB INSERT 영역


--개인회원 활동3 정지1                      
INSERT INTO IT_MEMBER VALUES( 1004, 'user1', '1234', '회원일','010-22222-1111','user1@itpro.com','N','활동','Y','개인회원','N','profileimages/','testprofile.jpg',SYSDATE, '김회원',to_date('2010-03-05','yyyy-mm-dd'),'남','Y');--개인회원 활동
INSERT INTO IT_MEMBER VALUES( 1005,'user2','1234','회원이','010-22222-2222','user2@itpro.com','N','활동','Y','개인회원','N','profileimages/','testprofile.jpg',SYSDATE,'이회원',to_date('2010-05-05','yyyy-mm-dd'),'남','N');--개인회원 활동
INSERT INTO IT_MEMBER VALUES( 1006,'user3','1234','회원삼','010-22222-3333','user3@itpro.com','N','활동','Y','개인회원','N','profileimages/','testprofile.jpg',SYSDATE,'박회원',to_date('2008-06-05','yyyy-mm-dd'),'남','Y');--개인회원 활동
INSERT INTO IT_MEMBER VALUES( 1007,'user4','1234','회원사','010-22222-4444','user4@itpro.com','N','정지','Y','개인회원','N','profileimages/','testprofile.jpg',SYSDATE,'유회원',to_date('2009-07-05','yyyy-mm-dd'),'남','N');--개인회원 정지


SELECT * FROM STUDYJOININFO;
		SELECT S.M_NO,S.BD_NO,S.SJ_JOINDATE,S.SJ_MESSAGE,
			   S.SJ_ISJOIN, S.SJ_ACCEPTDATE, M.M_IMG_PATH, M.M_IMG, M.M_NICKNAME 
	    FROM STUDYJOININFO S, IT_MEMBER M
	    WHERE S.M_NO = M.M_NO
	      AND BD_NO=1000
		  AND SJ_ISJOIN = 'y';
          
          
update studyjoininfo set sj_isjoin='y';
--기업회원 인증 2, 미인증 1 INSERT문
INSERT ALL
INTO IT_MEMBER VALUES(1000,'biz1','1234','samsung','01099998888','samsung@samsung.com','N','활동','Y','기업회원','N',' ',' ',SYSDATE,'','','','')
INTO BIZ_MEMBER VALUES(1000,'3216549871','Y')
SELECT * FROM DUAL;

INSERT ALL
INTO IT_MEMBER VALUES(1001,'biz2','1234','lg','01099990000','lg@lg.com','N','활동','Y','기업회원','N',' ',' ',SYSDATE,'','','','')
INTO BIZ_MEMBER VALUES(1001,'2165654456','N')
SELECT * FROM DUAL;

INSERT ALL
INTO IT_MEMBER VALUES(1002,'biz3','1234','sk','01089790000','sk@sk.com','N','활동','Y','기업회원','N',' ',' ',SYSDATE,'','','','')
INTO BIZ_MEMBER VALUES(1002,'1656540909','N')
SELECT * FROM DUAL;

--관리자 계정 생성
INSERT 
INTO IT_MEMBER VALUES(1003,'admin','1234','admin','01089792300','admin@admin.com','N','활동','Y','관리자','Y','profileimages/','testprofile.jpg',SYSDATE,'관리자',to_date('2010-03-05','yyyy-mm-dd'),'남','');


update IT_MEMBER set M_IMG_PATH='profileimages/';
update IT_MEMBER set M_IMG = 'testprofile.jpg';

SELECT * FROM IT_MEMBER;



--BOARD CATEGORY INSERT

INSERT INTO BOARDCATEGORY VALUES(1,'프로젝트');
/*아래 INSERT 구문 중 Q&A에서 &이 특수문자로 인식되어 ESCAPE 해주기 위해 SET DEFINE OFF & 사용*/
SET DEFINE OFF &; 
INSERT INTO BOARDCATEGORY VALUES(2,'Q&A');
INSERT INTO BOARDCATEGORY VALUES(3,'스터디구인');
INSERT INTO BOARDCATEGORY VALUES(4,'기업 채용정보');
INSERT INTO BOARDCATEGORY VALUES(5,'공지사항');
INSERT INTO BOARDCATEGORY VALUES(6,'광고문의');
INSERT INTO BOARDCATEGORY VALUES(7,'포트폴리오');


-- STUDY LIST
INSERT ALL
INTO BOARD VALUES(1000,'서울 강남구 자바 스터디 모집합니다.','자바 초보 스터디 입니다.',SYSDATE,NULL,0,'192.168.0.1',3,1000)
INTO STUDY VALUES(1000,'Y','서울','강남구','근처 스터디룸',1,5)
SELECT * FROM DUAL;

--공지사항 LIST
INSERT INTO BOARD
  VALUES(2650,'광고문의','먼저 관리자의 허락을 받아야 합니다.',SYSDATE,NULL,0,'192.168.3.4',5,1003);


--신고 - 게시글 LIST
INSERT INTO REPORT
VALUES(1000,1001, 1000,'공지사항','1213','되라~',SYSDATE);

select * from studyjoininfo;
DELETE FROM STUDYJOININFO;

--BOARDRECOMMAND (게시글 추천)
INSERT INTO BOARDRECOMMAND VALUES (1000,1001,SYSDATE);

--REPLY (댓글)
INSERT INTO REPLY VALUES (REPLYSEQ.NEXTVAL,SYSDATE,NULL,'테스트댓글입니다','192.168.0.1',1004,1000,GROUPNOSEQ.NEXTVAL,0,0,NULL,'N');


--스터디 참여 인원
INSERT INTO STUDYJOININFO VALUES (1007,1000,SYSDATE,'프론트엔드 개발자 입니다','y',SYSDATE);

--광고문의
INSERT INTO AD_REQUEST 
VALUES (AD_SEQ.NEXTVAL,1003,'광고게시','무역','종합상사','2021/5/21','2021/6/20','IMG1','IMGS/IMG',500000,'대기중');

--이력서
 INSERT INTO M_RESUME
    VALUES(1004,RESUMENO_SEQ.NEXTVAL,'테스트자소서자소서자소서','123456','서울시 강남구','강남구 590번지','강남빌딩 4층','301호','자소서자소서자소서자소서자소서자소서자소서자소서','www.itpro.com','testprofile.jpg','profileimages/',SYSDATE);
    INSERT INTO M_RESUME
    VALUES(1004,RESUMENO_SEQ.NEXTVAL,'테스트자소서','123456','서울시 강남구','강남구 590번지','강남빌딩 4층','301호','자소서자소서자소서자소서자소서자소서자소서자소서','www.itpro.com','testprofile.jpg','profileimages/',SYSDATE);
    
--학력사항
     INSERT INTO EDUCATION
    VALUES(1004,EDUCATION_SEQ.NEXTVAL,to_date('20210305'),NULL,'서울대학교 대학원','재학','컴퓨터공학과','대학원');
      INSERT INTO EDUCATION
    VALUES(1004,EDUCATION_SEQ.NEXTVAL,to_date('2020-03-05'),to_date('2021-03-05'),'서울대학교','졸업','컴퓨터공학과','대학교');
    
--경력사항   
  INSERT INTO CAREER
 VALUES(1004,CAREERNO_SEQ.NEXTVAL,'KH정보교육원','웹개발어쩌구 저쩌구',to_date('2021-03-05'), to_date('2021-10-06'));
   INSERT INTO CAREER
 VALUES(1004,CAREERNO_SEQ.NEXTVAL,'카카오','웹개발어쩌구 저쩌구',to_date('2021-03-05'),to_date('2021-10-06'));
   INSERT INTO CAREER
 VALUES(1004,CAREERNO_SEQ.NEXTVAL,'네이버','웹개발어쩌구 저쩌구',to_date('2021-03-05'),to_date('2021-10-06'));
    
--자격사항
   INSERT INTO LICENCE
    VALUES(1004,LICENCENO_SEQ.NEXTVAL,'사무자동화기사',to_date('2020-03-05'),'한국산업인력공단');

/* 기업회원 생성 및 기업 정보 INSERT */

INSERT ALL
INTO BOARD VALUES(30000,'자바 백엔드 개발자','업무소개 커머스 결제 금융 관련.. 자격조건 나이 성별 학력 무관 전공우대.. 우대사항 각종 장애 극복, 
                        대규모 트래픽 처리 경험이 있으신분.. 이런분들과 일하고 싶어요 품질 좋은 소프트웨어.. 개발 팀 환경 기술 스택 JAVA....',
                        SYSDATE,NULL,15,'192.111.123.444',4,2000)
INTO COMPANY VALUES(30000,'도우테크','서버/백엔드/,안드로이드 앱,시스템/네트워크','5~7년','학력무관','서울 금천구 디지털로 9길 32, (가산동)',
                           NULL,'A동 402호','상시채용','Y',NULL,NULL)
INTO IT_MEMBER VALUES(2000,'doutech','1234','doutech','01099918888','doutech@doutech.com','N','활동','Y','기업회원','N','resources/images/companyimages/','doutech.png',SYSDATE,'도우테크',null,null,null)
INTO BIZ_MEMBER VALUES(2000,'6216149871','Y')
SELECT * FROM DUAL;


COMMIT;