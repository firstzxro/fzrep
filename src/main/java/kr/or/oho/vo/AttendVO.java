package kr.or.oho.vo;

import java.util.Date;

import lombok.Data;

@Data
public class AttendVO {
	
	private String waNo;		//근태번호
	private String waDt;		//출근시간
	private String EaOutTime;	//퇴근시간
	private Date waYmd;			//일자
	private String waRsn;		//사유
	private String waStatus;	//상태
	private String empNo;		//사원번호
	private String backColor;	//배경색상
	private String gubun;		//구분
}
