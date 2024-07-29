package kr.or.oho.vo;

import lombok.Data;

@Data
public class CnptVO {
	private String cnptNo;		//거래처번호
	private String cnptNm;		//거래처명
	private String cnptRprsv;	//거래처대표지
	private String cnptAddr;	//거래처주소
	private String cnptDaddr;	//거래처상세주소
	private int cnptZip;		//거래처우편번호
	private String cnptTelno;	//거래처전화번호
	private String cnptBzstat;	//업태
	private String cnptCls;		//종목
	private String cnptBzmnNo;	//거래처사업자번호
	private String empNo;		//사원번호
	
	EmployeeVO employeeVO;		//사원VO
}
