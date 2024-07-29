package kr.or.oho.vo;

import lombok.Data;

@Data
public class IntervieweeVO {
	private String itveeNo;			//지원번호
	private String itveeEmlAddr;	//이메일
	private String itveeNm;			//이름
	private int itveeZip;			//우편번호
	private String itveeAddr;		//주소
	private String itveeDaddr;		//상세주소
	private String itveeTelno;		//전화번호
	private String itveeGen;		//성별
	private String itveeProfImg;	//프로필사진
	
}
