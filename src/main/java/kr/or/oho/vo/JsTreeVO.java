package kr.or.oho.vo;

import lombok.Data;

@Data
public class JsTreeVO {
	private String id;			//번호
	private String parent;		//부모
	private String text;		//내용
	private String icon;		//아이콘
}
