package kr.or.oho.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MngVO {
	private String empNo;		//사원번호
	private String frcsNo;		//가맹점코드
	private String mngNo;		//관리번호
	private Date mngDt;			//관리일자
	private String mngYn;		//관리수정처리
	private String mngPp;		//관리 완료
	
	private int total;			//전체수
	private int success;		//성공수
	private int ing;			//진행중
	
	private String empNm;		//사원명
	private String frcsNm;		//가맹점명
	private String frcsAddr;	//가맹점주소
	private String loc;			//가맹점위치
}
