package kr.or.oho.frcowner.service;

import java.util.List;

import kr.or.oho.vo.ComentVO;
import kr.or.oho.vo.FreeBbsVO;

public interface FreeBbsService {
	
	/**
	 * 점주 게시판 가져오는 서비스
	 * @return
	 */
	public List<FreeBbsVO> list();

	/**
	 * 점주 자유게시글 상세보기 가져오는 서비스
	 * @param fbNo
	 * @return
	 */
	public FreeBbsVO detail(String fbNo);

	/**
	 * 게시글 수 조회하는 서비스
	 * @param fbNo
	 */
	public void count(String fbNo);

	/**
	 * 게시글 작성하는 서비스
	 * @param freeBbsVO
	 * @return
	 */
	public int create(FreeBbsVO freeBbsVO);

	/**
	 * 댓글 목록 가져오는 서비스
	 * @param fbNo
	 * @return
	 */
	public List<ComentVO> comentList(String fbNo);

	/**
	 * 게시글 수정하는 서비스
	 * @param freeBbsVO
	 * @return
	 */
	public int update(FreeBbsVO freeBbsVO);

	/**
	 * 게시글 삭제하는 서비스
	 * @param fbNo
	 */
	public void delete(String fbNo);

	/**
	 * 댓글 등록하는 서비스
	 * @param comentVO
	 * @return
	 */
	public int createCmt(ComentVO comentVO);

	/**
	 * 댓글 삭제하는 서비스
	 * @param comentVO
	 * @return
	 */
	public int deleteCmt(ComentVO comentVO);

	/**
	 * 댓글 수정하는 서비스
	 * @param comentVO
	 * @return
	 */
	public int updateCmt(ComentVO comentVO);

	/**
	 * 사원게시판 가져오는 서비스
	 * @return
	 */
	public List<FreeBbsVO> empBoardList();

}
