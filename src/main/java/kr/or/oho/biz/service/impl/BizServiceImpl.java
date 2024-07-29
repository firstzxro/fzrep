package kr.or.oho.biz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.biz.service.BizService;
import kr.or.oho.mapper.BizMapper;
import kr.or.oho.vo.BizMemberVO;
import kr.or.oho.vo.BizVO;

@Service
public class BizServiceImpl implements BizService{
	
	@Autowired
	BizMapper bizMapper;

	/**
	 * 전체 프로젝트 리스트 출력
	 * @return List<BizVO>
	 */
	@Override
	public List<BizVO> getBizVOList() {
		return this.bizMapper.getBizVOList();
	}

	/**
	 * 프로젝트 생성
	 * @param bizVO
	 * @return
	 */
	@Override
	public int create(BizVO bizVO) {
		int cnt = 0;
		
		cnt+= this.bizMapper.createBiz(bizVO);
		List<BizMemberVO> bizMemberVOList = bizVO.getBizMemberVOList();
		for (BizMemberVO bizMemberVO : bizMemberVOList) {
			cnt+= this.bizMapper.createBizMember(bizMemberVO);
		}
		
		return cnt;
	}

	/**
	 * 프로젝트 상세보기
	 * @return
	 */
	@Override
	public BizVO detail(BizVO bizVO) {
		return this.bizMapper.detail(bizVO);
	}

	/**
	 * 프로젝트 상세보기에서 수정하는 서비스
	 * @param bizVO
	 * @return
	 */
	@Override
	public int update(BizVO bizVO) {
		int cnt =0;
		
		cnt += this.bizMapper.deleteMember(bizVO);
		List<BizMemberVO> bizMemberVOList = bizVO.getBizMemberVOList();
		for (BizMemberVO bizMemberVO : bizMemberVOList) {
			bizMemberVO.setBizNo(bizVO.getBizNo());
			cnt += this.bizMapper.updateMember(bizMemberVO);
		}
		cnt += this.bizMapper.updateBiz(bizVO);
		
		
		return cnt;
	}

	/**
	 * 프로젝트 상세보기에서 진척도 변경하는 서비스
	 * @param bizVO
	 * @return
	 */
	@Override
	public int updateStatus(BizVO bizVO) {
		int cnt = 0;
		
		cnt += this.bizMapper.updateStatus(bizVO);
		
		return cnt;
	}

	/**
	 * 프로젝트 중단처리
	 * @param bizVO
	 * @return
	 */
	@Override
	public int updateStatusN(BizVO bizVO) {
		int cnt =0;
		
		cnt += this.bizMapper.updateStatusN(bizVO);
		
		return cnt;
	}
}
