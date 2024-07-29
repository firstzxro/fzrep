package kr.or.oho.vo;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class HdorderVO {
	private String hoNo;		//발주번호
	private Date hoDt;			//발주일
	private String hoPrcsYn;	//처리여부	
	private String empNo;		//사원번호
	private int hoTotalAmt;		//발주 총 수량
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hoDeliveryDt;	//발주배송일자
	private String hoRequest;	//발주요청메시지
	private String hoMnm;		//발주명
	private Date hoShippingStrdt;	//발주배송시작일
	private Date hoShippingEnddt;	//발주배송종료일
	private Date hoStlmDt;			//발주배송일자
	
	// hdorder/create페이지에서 값을 받기 위해 생성
	private String foNo;
	
	List<HdorderDtlVO> hdorderDtlVOList;
	
	EmployeeVO employeeNm;
	
	public String getComma(int money) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		String comma = formatter.format(money);
		return comma;
	}
}
