package kr.or.oho.frcowner.service;

import java.util.List;

import kr.or.oho.vo.ComentVO;
import kr.or.oho.vo.NtcBbsVO;

public interface NtcBbsService {

	/**
	 * 공지사항 게시판 가져오는 서비스
	 * @return
	 */
	public List<NtcBbsVO> list();
	
	/**
	 * 공지사항 상세보기 가져오는 서비스
	 * @param nbNo
	 * @return
	 */
	public NtcBbsVO detail(String nbNo);
	
	/**
	 * 공지사항 조회수 가져오는 서비스
	 * @param nbNo
	 */
	public void count(String nbNo);
	
	/**
	 * 게시글 작성하는 서비스
	 * @param ntcBbsVO
	 * @return
	 */
	public int create(NtcBbsVO ntcBbsVO);
	
	/**
	 * 게시글 수정하는 서비스
	 * @param ntcBbsVO
	 * @return
	 */
	public int update(NtcBbsVO ntcBbsVO);

	/**
	 * 게시글 삭제하는 서비스
	 * @param nbNo
	 */
	public void delete(String nbNo);
	
	/**
	 * 댓글 목록 가져오는 서비스
	 * @param nbNo
	 * @return
	 */
	public List<ComentVO> comentList(String nbNo);
	
	/**
	 * 댓글 등록하는 서비스
	 * @param comentVO
	 * @return
	 */
	public int createCmt(ComentVO comentVO);
	
	/**
	 * 댓글 수정하는 서비스
	 * @param comentVO
	 * @return
	 */
	public int updateCmt(ComentVO comentVO);
	
	/**
	 * 댓글 삭제하는 서비스
	 * @param comentVO
	 * @return
	 */
	public int deleteCmt(ComentVO comentVO);

	/**
	 * 직원 공지사항 목록 가져오는 서비스
	 * @return
	 */
	public List<NtcBbsVO> ntcEmpList();



}
