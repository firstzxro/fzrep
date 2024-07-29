package kr.or.oho.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AlarmVO {
	private String alrGlocd;	//글로벌 코드
	private int alrSeq;			//순서
	private String alrSrc;		//알림출처
	private String alrIdnty;	//알림화면
	private String alrInfo;		//알림정보
	private Date alrTm;			//알림시간
	private String alrTg;		//
	private String alrSd;
}
