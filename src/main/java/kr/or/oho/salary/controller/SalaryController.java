package kr.or.oho.salary.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.oho.salary.service.SalaryService;
import kr.or.oho.vo.DdcVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.GiveVO;
import kr.or.oho.vo.SalaryVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author PC-05
 *
 */
@Controller
@Slf4j
@RequestMapping("/salary")
public class SalaryController {

	@Autowired
	SalaryService salaryService;

	/**
	 * 모든 사원의 급여관리대장 정보를 가져오는 컨트롤러
	 * @param model
	 * @return 급여관리대장 페이지
	 */
	@GetMapping("/all")
	public String selectAllSalaryList(Model model) {
		log.info("selectAllSalary메소드 도착");

		List<SalaryVO> salaryVOList = this.salaryService.allList();
		log.debug("salaryVOList : "+ salaryVOList);
		
		model.addAttribute("salaryVOList", salaryVOList);

		
		
		return "salary/allList";
	}
	
	/**
	 * 모든 사원의 급여관리대장 출력을 위한 메소드
	 * @return salaryVOList
	 */
	@ResponseBody
	@PostMapping("/allAjax")
	public List<SalaryVO> selectAllSalaryListAjax() {
		log.info("selectAllSalaryAjax메소드 도착");
		
		List<SalaryVO> salaryVOList = this.salaryService.allList();
		log.debug("salaryVOList : "+ salaryVOList);
		
		return salaryVOList;
	}
	
	/**
	 * 단일 급여 상세조회
	 * @param salaryVO
	 * @return map
	 */
	@ResponseBody
	@PostMapping("/detail")
	public Map<String,Object> detailSalary(@RequestBody SalaryVO salaryVO) {
		log.debug("detail메소드 시작");
		log.debug("salaryVO: "+salaryVO);
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		SalaryVO salary = this.salaryService.getSalary(salaryVO.getAmlNo());
		GiveVO giveVO = this.salaryService.getGive(salaryVO.getGiveNo());
		DdcVO ddcVO = this.salaryService.getDdc(salaryVO.getDdcNo());
		
		map.put("salary", salary);
		map.put("giveVO", giveVO);
		map.put("ddcVO", ddcVO);
		
		log.debug("map : "+ map);
		return map;
	}
	
	/**
	 * 급여관리대장 등록
	 * @param model
	 * @return 급여관리대장 등록 페이지
	 */
	@GetMapping("/create")
	public String create(Model model) {
		log.debug("create.jsp에 왔다.");
		
		List<EmployeeVO> employeeVOList = this.salaryService.getName();
		log.debug("employeeVOList : "+ employeeVOList);
		
		model.addAttribute("employeeVOList",employeeVOList);
		
		return "salary/create";
	}
	
	/**
	 * 급여관리대장 등록
	 * @param salaryVO
	 * @return cnt
	 */
	@ResponseBody
	@PostMapping("/createAjax")
	public int createAjax(@RequestBody SalaryVO salaryVO) {
		log.debug("createAjax 도착");
		log.debug("salaryVO : " + salaryVO);
		
		int cnt = this.salaryService.createAjax(salaryVO);
		
		return cnt;
	}
	
	/**
	 * 급여관리대장 수정
	 * @param salaryVO
	 * @return cnt
	 */
	@ResponseBody
	@PostMapping("/updateAjax")
	public int updateAjax(@RequestBody SalaryVO salaryVO) {
		log.debug("updateAjax 도착");
		log.debug("salaryVO : " + salaryVO);
		
		int cnt = this.salaryService.updateAjax(salaryVO);
		
		return cnt;
	}
	
	/**
	 * 급여관리대장 삭제
	 * @param salaryVO
	 * @return cnt
	 */
	@ResponseBody
	@PostMapping("/delete")
	public int deleteAjax(@RequestBody SalaryVO salaryVO) {
		log.debug("deleteAjax에 왔다.");
		log.debug("salaryVO : " + salaryVO);
		
		int cnt = this.salaryService.deleteAjax(salaryVO);
		
		return cnt;
	}
	
	/**
	 * 급여관리대장 수정
	 * @param amlNo
	 * @param giveNo
	 * @param ddcNo
	 * @param model
	 * @return 급여관리대장 수정페이지
	 */
	@GetMapping("/update")
	public String update(String amlNo, String giveNo, String ddcNo, Model model) {
		log.debug("update에 왔다.");
		log.debug("amlNo : "+amlNo);
		log.debug("giveNo : "+giveNo);
		log.debug("ddcNo : "+ddcNo);
		
		
		SalaryVO salary = this.salaryService.getSalary(amlNo);
		GiveVO giveVO = this.salaryService.getGive(giveNo);
		DdcVO ddcVO = this.salaryService.getDdc(ddcNo);
		List<EmployeeVO> employeeVOList = this.salaryService.getName();
		
		model.addAttribute("salary",salary);
		model.addAttribute("giveVO",giveVO);
		model.addAttribute("ddcVO",ddcVO);
		model.addAttribute("employeeVOList",employeeVOList);
		
		return "salary/update";
	}
	
}
