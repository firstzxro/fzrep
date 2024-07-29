package kr.or.oho.vo;

import java.util.Date;

import lombok.Data;

@Data
public class HldyMngLdgrVO {
	
	private String hmlNo;		//연차관리번호
	private String empNo;		//사원번호
	private String hsNo;		//연차구분번호
	private Date hmlUseDt1;		//연차사용일1
	private Date hmlEndDt1;		//연차종료일1
	private String hmlUseDt;	//연차사용일
	private String hmlEndDt;	//연차종료일
	private int hmlTd;			//총일수
	private String hmlRsn;		//사유
	private String eatrztNo;	//전자결재번호
	private String atrzlnNo;	//결재선번호
	private String tmpltCn;		//서식내용
	private String tmpltNo;		//서식번호
	private HldySeVO hldySeVO;	//연차구분VO
	
	private EatrztVO eatrztVO;	//전자결재VO
}
