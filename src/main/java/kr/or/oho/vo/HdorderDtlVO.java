package kr.or.oho.vo;

import java.text.DecimalFormat;
import java.util.Date;

import lombok.Data;

@Data
public class HdorderDtlVO {
	private String hodNo;	//발주번호
	private int hodQnt;		//수량
	private int hodPrc;		//가격
	private int gdsAmt;		//금액
	private String gdsNm;	//상품명
	private int gdsNtslAmt;	//최소재고수
	private int gdsStock;	//재고수
	private String gdsImg;	//상품이미지
	private String hoNo;	//발주번호
	private String cnptNo;	//거래처번호
	private String gdsNo;	//상품번호
	private String wrhsNo;
	
	public String getComma(int money) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		String comma = formatter.format(money);
		return comma;
	}
	
	// DB에 없는 컬럼
	private String hoRequest;
	private String hoPrcsYn;
	private String cnptNm;
	private Date hoDeliveryDt;
	private Date hoDt;
}
