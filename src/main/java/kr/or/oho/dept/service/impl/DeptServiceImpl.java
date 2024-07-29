package kr.or.oho.dept.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.oho.dept.service.DeptService;
import kr.or.oho.mapper.DeptMapper;
import kr.or.oho.vo.DeptVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.JsTreeVO;

@Service
public class DeptServiceImpl implements DeptService {
	
	@Autowired
	DeptMapper deptMapper;

	/**
	 * 조직도에 표시할 부서 조회
	 * @return
	 */
	@Override
	public List<JsTreeVO> getDept() {
		return this.deptMapper.getDept();
	}

	/**
	 * 조직도에 표시할 사원 조회
	 * @return
	 */
	@Override
	public List<JsTreeVO> getEmp() {
		return this.deptMapper.getEmp();
	}

	/**
	 * 부서 선택시 표시할 부서정보 조회
	 * @param jsTreeVO
	 * @return
	 */
	@Override
	public DeptVO getDeptCn(JsTreeVO jsTreeVO) {
		return this.deptMapper.getDeptCn(jsTreeVO);
	}

	/**
	 * 부서 선택시 표시할 부서내 사원 정보 조회
	 * @param jsTreeVO
	 * @return
	 */
	@Override
	public List<EmployeeVO> getEmpCn(JsTreeVO jsTreeVO) {
		return this.deptMapper.getEmpCn(jsTreeVO);
	}

	/**
	 * 리스트로 갈때 부서이동 선택지 생성을 위한 부서 조회
	 * @return
	 */
	@Override
	public List<DeptVO> getAllDept() {
		return this.deptMapper.getAllDept();
	}

	/**
	 * 부서이동 서비스
	 * @param employeeVO
	 * @return
	 */
	@Override
	public int moveDept(EmployeeVO employeeVO) {
		return this.deptMapper.moveDept(employeeVO);
	}
}
