package kr.or.oho.vo;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import lombok.Data;

@Data
public class NtcBbsVO {
	private String nbNo;		//공지사항게시판 번호
	private String nbTtl;		//제목
	private String nbCn;		//내용
	private Date nbPstdt;		//게시일
	private String nbImp;		//중요도
	private String empNo;		//사원번호
	private String nbDelYn;		//삭제여부
	private int nbCount;		//공지사항 수
	private int displayNo;		//조회수
	private String deptNo;		//사원번호
	private String empNm;		//사원명
	
	@Valid
	private List<NtcBbsVO> ntcBbsList;	//공지사항 목록
		
	@Valid
	private List<ComentVO> comentList;	//댓글 목록

}

