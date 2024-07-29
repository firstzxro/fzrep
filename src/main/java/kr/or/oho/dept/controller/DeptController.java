package kr.or.oho.dept.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.oho.dept.service.DeptService;
import kr.or.oho.vo.DeptVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.JsTreeVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	/**
	 * 조직도 홈 정보를 가져오는 컨트롤러
	 * @return 조직도 페이지로 return("dept/list")
	 */
	@GetMapping("/list")
	public String list() {
		log.debug("list에 왔다.");
		
		return "dept/list";
	}
	
	
	/**
	 * 조직도에 표시할 부서 조회하는 컨트롤러
	 * @return jsTreeVOList에 deptVOList와 empVOList를 담아 return
	 */
	@ResponseBody
	@PostMapping("/getJsTree")
	public List<JsTreeVO> getJsTreeVO(){
		List<JsTreeVO> deptVOList = this.deptService.getDept();
		log.debug("deptVOList : "+deptVOList);
		List<JsTreeVO> empVOList = this.deptService.getEmp();
		log.debug("empVOList : "+empVOList);
		
		List<JsTreeVO> jsTreeVOList = new ArrayList<JsTreeVO>();
		jsTreeVOList.addAll(empVOList);
		jsTreeVOList.addAll(deptVOList);
		
		log.debug("jsTreeVOList : "+jsTreeVOList);
		
		
		return jsTreeVOList;
	}
	
	
	/**
	 * 부서 선택시 표시할 부서정보 조회하는 컨트롤러
	 * @param jsTreeVO
	 * @return 부서정보를 조회하는 select문을 deptVO에 담아 return
	 */
	@ResponseBody
	@PostMapping("/getDeptCn")
	public DeptVO getDeptCn(@RequestBody JsTreeVO jsTreeVO) {
		log.debug("getDeptCn에 왔다.");
		log.debug("jsTreeVO :"+jsTreeVO);
			
		DeptVO deptVO = this.deptService.getDeptCn(jsTreeVO);
		log.debug("deptVO : "+ deptVO);
		
		return deptVO;
	}
	
	/**
	 * 부서 선택시 표시할 부서내 사원 정보 조회하는 컨트롤러
	 * @param jsTreeVO
	 * @return 사원 정보를 조회하는 내용을 employeeVOList에 담아 return
	 */
	@ResponseBody
	@PostMapping("/getEmpCn")
	public List<EmployeeVO> getEmpCn(@RequestBody JsTreeVO jsTreeVO) {
		log.debug("getEmpCn에 왔다.");
		log.debug("jsTreeVO :"+jsTreeVO);
		
		List<EmployeeVO> employeeVOList = this.deptService.getEmpCn(jsTreeVO);
		log.debug("employeeVOList : "+ employeeVOList);
		
		return employeeVOList;
	}
	
	/**
	 * 리스트로 갈때 부서이동 선택지 생성을 위한 부서 조회하는 컨트롤러
	 * @return 리스트로 갈때 부서이동 선택지 생성을 위한 부서 조회하는 정보를 담은 deptVOList를 return
	 */
	@ResponseBody
	@PostMapping("/getAllDept")
	public List<DeptVO> getAllDept(){
		List<DeptVO> deptVOList = this.deptService.getAllDept();
		log.debug("deptVOList : "+deptVOList);
		return deptVOList;
	}
	
	
	/**
	 * 부서이동을 하는 컨트롤러
	 * @param employeeVO
	 * @return 부서 이동 작업의 결과를 나타내는 정수 값
	 */
	@ResponseBody
	@PostMapping("/moveDept")
	public int moveDept(@RequestBody EmployeeVO employeeVO) {
		log.debug("moveDept에 왔다.");
		log.debug("employeeVO :" + employeeVO);
		
		return this.deptService.moveDept(employeeVO);
	}
}
