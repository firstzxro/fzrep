package kr.or.oho.eatrzt.service;

import java.util.List;
import java.util.Map;

import kr.or.oho.vo.AtrzlnVO;
import kr.or.oho.vo.AttachVO;
import kr.or.oho.vo.EatrztVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.TmpltVO;

public interface EatrztService {

	/**
	 * 기안문서함으로 가는 서비스
	 * @param empNo
	 * @return
	 */
	public List<EatrztVO> docBoxList(String empNo);
	
	/**
	 * 반려된 기안문 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public List<EatrztVO> nDocBoxList(String empNo);

	/**
	 * 결재대기문 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public List<EatrztVO> beforeApvBoxList(String empNo);

	
	/**
	 * 결재문서 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public List<EatrztVO> apvBoxList(String empNo);
	
	/**
	 * 반려한 기안 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public List<EatrztVO> nApvBoxList(String empNo);

	/**
	 * 문서 목록을 조회하는 서비스
	 * @param tmpltVO
	 * @return
	 */
	public TmpltVO createPost(TmpltVO tmpltVO);

	/**
	 * 사원 목록을 가져오는 서비스
	 * @return
	 */
	public List<EmployeeVO> getName();

	
	/**
	 * 문서서식 목록을 가져오는 서비스
	 * @return
	 */
	public List<TmpltVO> tmpltList();

	/**
	 * 상세보기에서 공통부분을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	public EatrztVO comList(String empNo);

	/**
	 * 전자 결재 등록하는 서비스
	 * @param eatrztVO
	 * @return
	 */
	public int eatrztPost(EatrztVO eatrztVO);

	/**
	 * 결재선 목록을 가져오는 서비스
	 * @return
	 */
	public List<Map<String, Object>> atrzlnList();

	/**
	 * 결재 상세보기 정보를 가져오는 서비스
	 * @param eatrztVO
	 * @return
	 */
	public EatrztVO getEatrzt(EatrztVO eatrztVO);

	
	/**
	 * 첨부파일 목록을 가져오는 서비스
	 * @param eatrztVO
	 * @return
	 */
	public List<AttachVO> attachList(EatrztVO eatrztVO);
	
	/**
	 * 결재를 승인하는 ajax 동작을 위한 서비스
	 * @param atrzlnVO
	 * @return
	 */
	public int atrUpdatePost(AtrzlnVO atrzlnVO);
	
	/**
	 * 결재 확인용 서비스
	 * @param chkAtrzlnVO
	 * @return
	 */
	public AtrzlnVO check(AtrzlnVO chkAtrzlnVO);

	/**
	 * 결재를 반려하는 ajax 동작을 위한 서비스
	 * @param eatrztVO
	 * @return
	 */
	public int eatrztUpdate(EatrztVO eatrztVO);
	
	/**
	 * 문서 삭제 ajax 동작을 위한 서비스
	 * @param eatrztVO
	 * @return
	 */
	public int delUpdate(EatrztVO eatrztVO);
	
	
	/**
	 * 결재 서명 이미지 가져오는 서비스
	 * @param eatrztVO
	 * @return
	 */
	public List<AtrzlnVO> stampAtrList(EatrztVO eatrztVO);
	
	/**
	 * 결재 서명 이미지 가져오는 서비스2
	 * @param eatrztVO
	 * @return
	 */
	public List<AtrzlnVO> stampAtrList2(EatrztVO eatrztVO);
	

}
