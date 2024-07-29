package kr.or.oho.frcowner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.frcowner.service.FreeBbsService;
import kr.or.oho.mapper.FreeBbsMapper;
import kr.or.oho.vo.ComentVO;
import kr.or.oho.vo.FreeBbsVO;

@Service
public class FreeBbsServiceImpl implements FreeBbsService {

	
	@Autowired
	FreeBbsMapper frcownerMapper;
	
	
	/**
	 * 점주 게시판 가져오는 서비스
	 */
	@Override
    public List<FreeBbsVO> list() {
        List<FreeBbsVO> freeBbsList = this.frcownerMapper.list();

       // displayNo 설정
       for (int i = 0; i < freeBbsList.size(); i++) {
           freeBbsList.get(i).setDisplayNo(i + 1); 
       }

        return freeBbsList;
	}

	/**
	 * 점주 게시글 등록하는 서비스
	 * @param freeBbsVO
	 * @return
	 */
	@Override
	public int create(FreeBbsVO freeBbsVO) {
		return this.frcownerMapper.create(freeBbsVO);
	}

	/**
	 * 점주 자유게시글 상세보기 가져오는 서비스
	 * @param fbNo
	 * @return
	 */
	@Override
	public FreeBbsVO detail(String fbNo) {
		return frcownerMapper.detail(fbNo);
	}


	/**
	 * 게시글 수 조회하는 서비스
	 * @param fbNo
	 */
	@Override
	public void count(String fbNo) {
		this.frcownerMapper.count(fbNo);
	}


	/**
	 * 댓글 목록 가져오는 서비스
	 * @param fbNo
	 * @return
	 */
	@Override
	public List<ComentVO> comentList(String fbNo) {
		return frcownerMapper.comentList(fbNo);
	}


	/**
	 * 자유게시글 수정하는 서비스
	 * @param freeBbsVO
	 * @return 
	 */
	@Override
	public int update(FreeBbsVO freeBbsVO) {
		return this.frcownerMapper.update(freeBbsVO);
	}

	/**
	 *게시글 삭제하는 서비스
	 * @param fbNo
	 * @return
	 */
	@Override
	public void delete(String fbNo) {
		frcownerMapper.delete(fbNo);
	}

	/**
	 * 댓글 생성하는 서비스
	 * @param comentVO
	 * @return
	 */
	@Override
	public int createCmt(ComentVO comentVO) {
		return this.frcownerMapper.createCmt(comentVO);
	}

	/**
	 * 댓글 삭제하는 서비스
	 * @param comentVO
	 * @return
	 */
	@Override
	public int deleteCmt(ComentVO comentVO) {
		return this.frcownerMapper.deleteCmt(comentVO);
	}

	/**
	 * 댓글 수정하는 서비스
	 * @param comentVO
	 * @return
	 */
	@Override
	public int updateCmt(ComentVO comentVO) {
		return this.frcownerMapper.updateCmt(comentVO);
	}

	/**
	 * 사원게시판 가져오는 서비스
	 * @return
	 */
	@Override
	public List<FreeBbsVO> empBoardList() {
		List<FreeBbsVO> freeBbsList = this.frcownerMapper.empBoardList();

	       // displayNo 설정
	       for (int i = 0; i < freeBbsList.size(); i++) {
	           freeBbsList.get(i).setDisplayNo(i + 1); 
	       }

	        return freeBbsList;
	}
	

}
