package kr.or.oho.devmng.service;

import java.util.List;

import kr.or.oho.vo.InterviewerVO;
import kr.or.oho.vo.ItvBscInfoVO;
import kr.or.oho.vo.ReserveFounderVO;

public interface PreFrcService {
	/**
	 * 예비 창업자 신청 목록 리스트
	 * @return
	 */
	public List<ReserveFounderVO> list();
	
	/**
	 * 비동기로 상담일 등록하는 메서드
	 * @return
	 */
	public String ibiNoSelect();
	
	/**
	 * 일자 등록하는 서비스
	 * @param itvBscInfoVO
	 * @return
	 */
	public int ymdInsert(ItvBscInfoVO itvBscInfoVO);
	
	
	/**
	 * 상담 일자 등록하는 메서드
	 * @param interviewerVO
	 * @return
	 */
	public int interviewerInsert(InterviewerVO interviewerVO);
	
	
	/**
	 * 예비창업자 상담 수 가져오는 메서드
	 * @return
	 */
	public int listCnt();
}
