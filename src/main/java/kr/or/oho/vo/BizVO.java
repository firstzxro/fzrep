package kr.or.oho.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BizVO {
	private String bizNo;		//프로젝트 번호
	private String bizNm;		//프로젝트 명
	private String bizCn;		//프로젝트 내용
	private String bizCmptnYn;	//완료 여부
	private Date bizStdt;		//시작일자
	private Date bizEdt;		//완료일자
	
	private List<BizMemberVO> bizMemberVOList;	//프로젝트 참여인원 목록
}
