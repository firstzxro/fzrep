package kr.or.oho.devmng.service;

import java.util.List;
import java.util.Map;

import kr.or.oho.vo.ItvBscInfoVO;
import kr.or.oho.vo.ReserveFounderVO;

public interface FrcCnsltService {
	/**
	 *  로그인한 사원 담당 가맹 상담 리스트 화면 이동
	 * @param empNo
	 * @return
	 */
	public List<ReserveFounderVO> list(String empNo);
	
	/**
	 * 가맹 상세 상담 관리 화면 이동
	 * @param itvBscInfoVO
	 * @return
	 */
	public ReserveFounderVO detail(ItvBscInfoVO itvBscInfoVO);
	
	
	/**
	 * ajax 면접 기본정보 수정 처리
	 * @param itvBscInfoVO
	 * @return
	 */
	public int update(ItvBscInfoVO itvBscInfoVO);
	
	/**
	 * 면접관 삭제, 면접기본정보 삭제 처리
	 * @param itvBscInfoVO
	 * @return 삭제성공시 true
	 */
	public boolean cancel(ItvBscInfoVO itvBscInfoVO);
	
	/**
	 * ajax 면접 기본정보 삭제 처리
	 * @return
	 */
	public List<ReserveFounderVO> cnsltYList();
	
	/**
	 * 면접 상세
	 * @param reserveFounderVO
	 * @return
	 */
	public ReserveFounderVO cnsltYOne(ReserveFounderVO reserveFounderVO);
	
	/**
	 * 면접자 수 조회
	 * @param map
	 * @return
	 */
	public int listCnt(Map<String,String> map);
}
