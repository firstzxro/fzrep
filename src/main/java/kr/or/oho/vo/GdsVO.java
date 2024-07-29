package kr.or.oho.vo;

import lombok.Data;

@Data
public class GdsVO {
	private String gdsNo;		//상품번호
	private String gdsNm;		//싱품명
	private int gdsPrchsAmt;	//매입가
	private int gdsNtslAmt;		//판매가
	private int gdsStock;		//재고수
	private int minGdsStock;	//최소재고수
	private String gdsImg;		//재고이미지
	private String cnptNo;		//거래처번호
	private String gdsGu;		//상품구분
	private String wrhsNo;
	
	// 값 가져오기 위해 추가
	private String cnptNm;
	private String comcdCdnm;
}
