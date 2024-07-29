package kr.or.oho.attendence.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.attendence.service.AttendService;
import kr.or.oho.mapper.AttendMapper;
import kr.or.oho.vo.AttendVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AttendServiceImpl implements AttendService{
	
	@Autowired
	AttendMapper attendMapper;
	
	
	/**
	 * 근태현황 조회하는 서비스
	 * @param empNo(사원번호)
	 * @return
	 */
	@Override
	public List<AttendVO> getAttendList(String empNo) {
		return attendMapper.getAttendList(empNo);
	}
	
	/**
	 * 일정 수 조회하는 서비스
	 * @return
	 */
	@Override
	public int getCountList(Map<String, Object> map) {
		return attendMapper.getCountList(map);
	}
	
	/**
	 * 일정 등록하는 서비스
	 * @param attendVO(근태)
	 * @return
	 */
	@Override
	public int createPost(AttendVO attendVO) {
		return attendMapper.createPost(attendVO);
	}
	
	/**
	 * 근태 수정하는 서비스
	 * @param attendVO
	 * @return
	 */
	@Override
	public int updatePost(AttendVO attendVO) {

		return attendMapper.updatePost(attendVO);
	}
	

	/**
	 * 일정 날짜 가져오는 서비스
	 * @return
	 */
	@Override
	public AttendVO getWaYmd(Map<String, Object> map) {
		
		return attendMapper.getWaYmd(map);
	}

	/**
	 * 퇴근 시간 가져오는 서비스
	 * @return
	 */
	@Override
	public AttendVO geteaOutTime(Map<String, Object> map) {

		return attendMapper.geteaOutTime(map);
	}

	/**
	 * 퇴근 후 퇴근시간 가져오는 서비스
	 * @return
	 */
	@Override
	public AttendVO geteaOutTime2(String empNo) {
		
		return attendMapper.geteaOutTime2(empNo);
	}
}
