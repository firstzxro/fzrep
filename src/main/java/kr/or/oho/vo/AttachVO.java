package kr.or.oho.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AttachVO {	
	
	private String afGlocd;		//글로벌 코드
	private int afSeq;			//순서
	private String afNm;		//파일이름
	private long afSz;			//파일크기
	private String afExtnNm;	//확장자명
	private Date afPstdt;		//게시일
	
}
