package kr.or.oho.franchise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.franchise.service.FranchiseService;
import kr.or.oho.mapper.FrcMapper;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.FranchiseVO;

@Service
public class FranchiseServiceImpl implements FranchiseService{

	@Autowired
	FrcMapper frcMapper;
	
	/**
	 * 프랜차이즈 목록 정보를 가져오는 서비스
	 */
	@Override
	public List<FranchiseVO> frcsList() {
		return this.frcMapper.frcsList();
	}

	/**
	 * 프랜차이즈 상세보기를 조회하는 서비스
	 * @param frcsVO
	 */
	@Override
	public EmployeeVO frcsDetail(EmployeeVO frcsVO) {
		return this.frcMapper.frcsDetail(frcsVO);
	}

	/**
	 * 수정된 프랜차이즈 목록을 조회하는 서비스
	 *  @param frcsNo
	 */
	@Override
	public FranchiseVO getfrcsInfo(String frcsNo) {
		return this.frcMapper.getFranchiseInfo(frcsNo);
	}

	/**
	 * 가맹점주 정보를 조회하는 서비스
	 * @param frcsNo
	 */
	@Override
	public EmployeeVO getFrcsEmpInfo(String frcsNo) {
		return this.frcMapper.getFrcsEmpInfo(frcsNo);
	}

	
	/**
	 * 프랜차이즈 정보를 조회하는 서비스
	 * @param frcsVO
	 *
	 */
	@Override
	public int updateFranchiseInfo(FranchiseVO frcsVO) {
		return this.frcMapper.updateFranchiseInfo(frcsVO);
	}
	
	
	/**
	 * 가맹점주 수정하는 서비스
	 * @param employeeVO
	 */
	@Override
	public int updateFrcsEmpInfo(EmployeeVO employeeVO) {
		return this.frcMapper.updateFrcsEmpInfo(employeeVO);
	}

	/**
	 * 가맹점 삭제하는 서비스
	 * @param frcsNo
	 */
	@Override
	public int deleteFranchise(FranchiseVO frcsNo) {
		int result = this.frcMapper.deleteFranchise(frcsNo);
		result +=  this.frcMapper.deleteFrcsEmp(frcsNo);
		
		return result;
	}
	
}
