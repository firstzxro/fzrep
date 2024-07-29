package kr.or.oho.vo;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import lombok.Data;

@Data
public class FreeBbsVO {
	private String fbNo;		//공지사항 번호
	private String fbTtl;		//제목
	private String fbCn;		//내용	
	private Date fbPstdt;		//게시일
	private String empNo;		//사원번호
	private String fbDelYn;		//삭제여부
	private int fbCount;		//공지사항 수
	private int displayNo;		//게시글 수
	
	private String empNm;		//사원명
	private String string;
	private String empJbgdNm;	//직위
	
	@Valid
	private List<FreeBbsVO> freeBbsList;	//공지사항 목록
	
	@Valid
	private List<ComentVO> comentList;		//댓글 목록


	
}
