package kr.or.oho.vo;

import java.text.DecimalFormat;

import lombok.Data;

@Data
public class GiveVO {
	private String giveNo;		//지급번호
	private int giveAmt;		//기본급	
	private int giveExts;		//연장근로수당
	private int giveNight;		//야간근로수당
	private int giveHldy;		//휴일근로수당
	
	public String getComma(int money) {
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		String comma = formatter.format(money);
		return comma;
	}
	
}
