package kr.or.oho.vo;

import java.util.List;

import lombok.Data;

@Data
public class HldySeVO {
	
	private String hsNo;	//연차구분번호 
	private String hsNm;	//연차구분명	 
	
	private List<HldyMngLdgrVO> HldyMngLdgrVOList;
	
}
