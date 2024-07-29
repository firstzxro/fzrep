package kr.or.oho.openmng.service;

import java.util.List;
import java.util.Map;

import kr.or.oho.vo.CtrtVO;
import kr.or.oho.vo.FrcsTypeVO;

public interface CtrtService {
	/**
	 * 가맹점 전체 계약 목록 가져오는 서비스
	 * @return
	 */
	public List<CtrtVO> list();
	
	/**
	 * 가맹점 유형 별 계약 목록 가져오는 서비스
	 * @param frcsTypeVO
	 * @return
	 */
	public List<CtrtVO> list(FrcsTypeVO frcsTypeVO);
	
	/**
	 * 가맹점 계약 상세 가져오는 서비스
	 * @param ctrtVO
	 * @return
	 */
	public CtrtVO detail(CtrtVO ctrtVO);
	
	/**
	 * 계약번호 가져오는 서비스
	 * @return
	 */
	public String ctrtNoSelect();
	
	/**
	 * 계약 등록 결과 가져오는 서비스
	 * @param ctrtVO
	 * @return
	 */
	public int add(CtrtVO ctrtVO);
	
	/**
	 * 프랜차이즈유형 가져오는 서비스
	 * @return
	 */
	public List<FrcsTypeVO> frcsTypeSelect();
	
	/**
	 * 계약 수정하는 서비스
	 * @param ctrtVO
	 * @return
	 */
	public int update(CtrtVO ctrtVO);
	
	/**
	 * 가맹점 유형 수 가져오는 서비스
	 * @return
	 */
	public List<FrcsTypeVO> getFtCnt();
	
	/**
	 * 가맹점 개점일 가져오는 서비스
	 * @param map
	 * @return
	 */
	public int getClsYnCnt(Map<String,String> map);
}
