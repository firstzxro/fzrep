package kr.or.oho.vo;

import lombok.Data;

@Data
public class FrcsStockVO {
	private String gdsNo;		//상품번호
	private String frcsNo;		//가맹점코드
	private int frcssCnt;		//재고수
	private int minGdsStock;	//최소재고수
	private int maxGdsStock;	//최대재고수
	
	// DB에 없는 값
	private String gdsNm;
	private int gdsNtslAmt;
	private String comcdCdnm;
}
