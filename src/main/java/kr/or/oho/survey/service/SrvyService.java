package kr.or.oho.survey.service;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import kr.or.oho.vo.AnsMcVO;
import kr.or.oho.vo.ExampleVO;
import kr.or.oho.vo.QstnMcVO;
import kr.or.oho.vo.SrvyVO;

public interface SrvyService {
	/**
	 * 설문조사 번호 가져오는 서비스
	 * @return
	 */
	public String srvyNoSelect();
	
	/**
	 * 질문번호 가져오는 서비스
	 * @return
	 */
	public String qmNoSelect();
	
	/**
	 * 설문 추가하는 서비스
	 * @param srvyVO
	 * @param principal
	 * @return
	 */
	public boolean srvyAdd(SrvyVO srvyVO, Principal principal);
	
	/**
	 * 설문목록 가져오는 서비스
	 * @return
	 */
	public List<SrvyVO> list();
	
	/**
	 * 설문 삭제하는 서비스
	 * @param srvyVO
	 * @return
	 */
	public int srvyDelete(SrvyVO srvyVO);
	
	/**
	 * 설문 수정하는 서비스
	 * @param srvyVO
	 * @return
	 */
	public int updateSurvey(SrvyVO srvyVO);
	
	/**
	 * 설문 상세보기하는 서비스
	 * @param srvyVO
	 * @return
	 */
	public SrvyVO surveyDetail(SrvyVO srvyVO);
	
	/**
	 * 질문 상세보기하는 서비스
	 * @param srvyVO
	 * @return
	 */
	public List<QstnMcVO> qmcDetail(SrvyVO srvyVO);
	
	/**
	 * 종료된 설문조사 상세보기하는 서비스
	 * @param map
	 * @return
	 */
	public List<ExampleVO> expDetail(Map<String,String> map);
	
	/**
	 * 답변 가져오는 서비스
	 * @param ansMcVO
	 * @return
	 */
	public int submitAns(AnsMcVO ansMcVO);
	
	/**
	 * 로그인한 사람이 참여할 수 있는 설문 리스트가져오는 서비스
	 * @param srvyTrgt
	 * @param principal
	 * @return
	 */
	public List<SrvyVO> ableSrvyList(String srvyTrgt, Principal principal);
	
	/**
	 * 설문조사관리목록 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public List<SrvyVO> srvyMngList(String empNo);
	
	/**
	 * 종료된 설문조사 목록 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public List<SrvyVO> srvyMngFinList(String empNo);
}
