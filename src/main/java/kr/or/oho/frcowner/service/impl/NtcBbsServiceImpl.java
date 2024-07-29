package kr.or.oho.frcowner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.frcowner.service.NtcBbsService;
import kr.or.oho.mapper.NtcBbsMapper;
import kr.or.oho.vo.ComentVO;
import kr.or.oho.vo.NtcBbsVO;

@Service
public class NtcBbsServiceImpl implements NtcBbsService {

	@Autowired
	NtcBbsMapper ntcBbsMapper;
	
	/**
	 * 공지사항 게시판 가져오는 서비스
	 * @return
	 */
	@Override
	public List<NtcBbsVO> list() {
		List<NtcBbsVO> ntcBbsList = this.ntcBbsMapper.list();
		 
	       for (int i = 0; i < ntcBbsList.size(); i++) {
	           ntcBbsList.get(i).setDisplayNo(i + 1); 
	       }
		
		return ntcBbsList;
	}

	/**
	 * 게시글 작성하는 서비스
	 * @param ntcBbsVO
	 * @return
	 */
	@Override
	public int create(NtcBbsVO ntcBbsVO) {
		return this.ntcBbsMapper.create(ntcBbsVO);
	}
	
	/**
	 * 공지사항 상세보기 가져오는 서비스
	 * @param nbNo
	 * @return
	 */
	@Override
	public NtcBbsVO detail(String nbNo) {
		return ntcBbsMapper.detail(nbNo);
	}

	/**
	 * 공지사항 조회수 가져오는 서비스
	 * @param nbNo
	 */
	@Override
	public void count(String nbNo) {
		this.ntcBbsMapper.count(nbNo);
	}

	/**
	 * 게시글 수정하는 서비스
	 * @param ntcBbsVO
	 * @return
	 */
	@Override
	public int update(NtcBbsVO ntcBbsVO) {
		return this.ntcBbsMapper.update(ntcBbsVO);
	}

	/**
	 * 게시글 삭제하는 서비스
	 * @param nbNo
	 */
	@Override
	public void delete(String nbNo) {
		ntcBbsMapper.delete(nbNo);
	}

	/**
	 * 댓글 목록 가져오는 서비스
	 * @param nbNo
	 * @return
	 */
	@Override
	public List<ComentVO> comentList(String nbNo) {
		return ntcBbsMapper.comentList(nbNo);
	}

	/**
	 * 댓글 등록하는 서비스
	 * @param comentVO
	 * @return
	 */
	@Override
	public int createCmt(ComentVO comentVO) {
		return this.ntcBbsMapper.createCmt(comentVO);
	}

	/**
	 * 댓글 수정하는 서비스
	 * @param comentVO
	 * @return
	 */
	@Override
	public int updateCmt(ComentVO comentVO) {
		return this.ntcBbsMapper.updateCmt(comentVO);
	}

	/**
	 * 댓글 삭제하는 서비스
	 * @param comentVO
	 * @return
	 */
	@Override
	public int deleteCmt(ComentVO comentVO) {
		return this.ntcBbsMapper.deleteCmt(comentVO);
	}

	/**
	 * 직원 공지사항 목록 가져오는 서비스
	 * @return
	 */
	@Override
	public List<NtcBbsVO> ntcEmpList() {
		List<NtcBbsVO> ntcBbsList = this.ntcBbsMapper.ntcEmpList();
		 
	       for (int i = 0; i < ntcBbsList.size(); i++) {
	           ntcBbsList.get(i).setDisplayNo(i + 1); 
	       }
		
		return ntcBbsList;
	}

}
