package kr.or.oho.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ComentVO {
	
	private String cmntNo;		//댓글번호
	private String cmntCd;		//게시판코드
	private String cmntCn;		//댓글내용
	private Date cmntWrtDt;		//작성일
	private String empNo;		//사원번호
	private String cmntDelYn;	//삭제여부
	
	private String empNm;		//사원명
}
