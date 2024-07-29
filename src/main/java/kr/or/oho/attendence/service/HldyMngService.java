package kr.or.oho.attendence.service;

import java.util.List;
import java.util.Map;

import kr.or.oho.vo.HldyMngLdgrVO;

public interface HldyMngService {

	
	/** 휴가현황을 조회하는 서비스
	 * @param empNo
	 * @return
	 */
	List<HldyMngLdgrVO> list(String empNo);
	
	/** 출장현황을 조회하는 서비스
	 * @param empNo
	 * @return
	 */
	List<HldyMngLdgrVO> btList(String empNo);
	
}
