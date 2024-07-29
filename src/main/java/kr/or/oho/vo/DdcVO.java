package kr.or.oho.vo;

import java.text.DecimalFormat;

import lombok.Data;

@Data
public class DdcVO {
	private String ddcNo;	//공제번호
	private int ddcInsrnc;	//4대보험
	private int ddcInctx;	//소득세
	
	public String getComma(int money) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		String comma = formatter.format(money);
		return comma;
	}
}
