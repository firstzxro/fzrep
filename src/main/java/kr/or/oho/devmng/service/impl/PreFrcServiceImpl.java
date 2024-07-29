package kr.or.oho.devmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.devmng.service.PreFrcService;
import kr.or.oho.mapper.PreFrcMapper;
import kr.or.oho.vo.InterviewerVO;
import kr.or.oho.vo.ItvBscInfoVO;
import kr.or.oho.vo.ReserveFounderVO;

@Service
public class PreFrcServiceImpl implements PreFrcService {

	@Autowired
	PreFrcMapper preFrcMapper;
	
	/**
	 * 예비 창업자 신청 목록 리스트
	 * @return
	 */
	@Override
	public List<ReserveFounderVO> list() {
		return this.preFrcMapper.list();
	}
	
	/**
	 * 비동기로 상담일 등록하는 메서드
	 * @return
	 */
	@Override
	public String ibiNoSelect() {
		return this.preFrcMapper.ibiNoSelect();
	}

	/**
	 * 일자 등록하는 서비스
	 * @param itvBscInfoVO
	 * @return
	 */
	@Override
	public int ymdInsert(ItvBscInfoVO itvBscInfoVO) {
		return this.preFrcMapper.ymdInsert(itvBscInfoVO);
	}

	/**
	 * 상담 일자 등록하는 메서드
	 * @param interviewerVO
	 * @return
	 */
	@Override
	public int interviewerInsert(InterviewerVO interviewerVO) {
		return this.preFrcMapper.interviewerInsert(interviewerVO);
	}

	/**
	 * 예비창업자 상담 수 가져오는 메서드
	 * @return
	 */
	@Override
	public int listCnt() {
		return this.preFrcMapper.listCnt();
	}

}
