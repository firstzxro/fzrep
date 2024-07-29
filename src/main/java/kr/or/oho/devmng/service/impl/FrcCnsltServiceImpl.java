package kr.or.oho.devmng.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.devmng.service.FrcCnsltService;
import kr.or.oho.mapper.FrcCnsltMapper;
import kr.or.oho.vo.ItvBscInfoVO;
import kr.or.oho.vo.ReserveFounderVO;

@Service
public class FrcCnsltServiceImpl implements FrcCnsltService {

	@Autowired
	FrcCnsltMapper frcCnsltMapper;
	
	/**
	 *  로그인한 사원 담당 가맹 상담 리스트 화면 이동
	 * @param empNo
	 * @return
	 */
	@Override
	public List<ReserveFounderVO> list(String empNo) {
		return this.frcCnsltMapper.list(empNo);
	}

	/**
	 * 가맹 상세 상담 관리 화면 이동
	 * @param itvBscInfoVO
	 * @return
	 */
	@Override
	public ReserveFounderVO detail(ItvBscInfoVO itvBscInfoVO) {
		return this.frcCnsltMapper.detail(itvBscInfoVO);
	}

	/**
	 * ajax 면접 기본정보 수정 처리
	 * @param itvBscInfoVO
	 * @return
	 */
	@Override
	public int update(ItvBscInfoVO itvBscInfoVO) {
		return this.frcCnsltMapper.update(itvBscInfoVO);
	}

	/**
	 * 면접관 삭제, 면접기본정보 삭제 처리
	 * @param itvBscInfoVO
	 * @return 삭제성공시 true
	 */
	@Override
	public boolean cancel(ItvBscInfoVO itvBscInfoVO) {
		int result = this.frcCnsltMapper.interviewerDelete(itvBscInfoVO);
		result += this.frcCnsltMapper.cancel(itvBscInfoVO);
		
		if(result == 2) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * ajax 면접 기본정보 삭제 처리
	 * @return
	 */
	@Override
	public List<ReserveFounderVO> cnsltYList() {
		return this.frcCnsltMapper.cnsltYList();
	}

	/**
	 * 면접 상세
	 * @param reserveFounderVO
	 * @return
	 */
	@Override
	public ReserveFounderVO cnsltYOne(ReserveFounderVO reserveFounderVO) {
		return this.frcCnsltMapper.cnsltYOne(reserveFounderVO);
	}

	/**
	 * 면접자 수 조회
	 * @param map
	 * @return
	 */
	@Override
	public int listCnt(Map<String, String> map) {
		return this.frcCnsltMapper.listCnt(map);
	}

}
