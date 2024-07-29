package kr.or.oho.attendence.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.oho.attendence.service.AttendService;
import kr.or.oho.attendence.service.HldyMngService;
import kr.or.oho.eatrzt.service.EatrztService;
import kr.or.oho.mapper.EmployeeMapper;
import kr.or.oho.vo.AtrzlnVO;
import kr.or.oho.vo.EatrztVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.HldyMngLdgrVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author PC-05
 *
 */
@RequestMapping("/hldy")
@Slf4j
@Controller
public class HldyController {
	
	@Autowired
	HldyMngService hldyMngService;
	
	@Autowired
	AttendService attendService;
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Autowired
	EatrztService eatrztService ;
	
	
	/**
	 * 근태 현황을 조회하는 컨트롤러
	 * @param model
	 * @param principal
	 * @param map
	 * @param eatrztVO
	 * @param atrzlnVO
	 * @return 근태 및 휴가 관리 목록 페이지(view name: "attend/hldymngList")
	 */
	@GetMapping("/list")
	public String list(Model model, Principal principal, Map<String, Object> map, EatrztVO eatrztVO, AtrzlnVO atrzlnVO) {
		if (principal == null) {
			return "redirect:/login";
		}

		log.info("principal:" + principal);

		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp);

		String empNo = emp.getEmpNo();
		map.put("empNo", empNo);

		List<HldyMngLdgrVO> hldyMngLdgrVOList = this.hldyMngService.list(empNo);
		log.info("hldyMngLdgrVOList :" + hldyMngLdgrVOList);

		List<HldyMngLdgrVO> hldyMngLdgrVOList2 = this.hldyMngService.btList(empNo);
		log.info("hldyMngLdgrVOList2 :" + hldyMngLdgrVOList2);

		model.addAttribute("hldyMngLdgrVOList", hldyMngLdgrVOList);
		model.addAttribute("hldyMngLdgrVOList2", hldyMngLdgrVOList2);

		map.put("waStatus", "퇴근");
		int totalWork = this.attendService.getCountList(map);
		log.info("getCountList 결과->totalWork : " + totalWork);
		model.addAttribute("totalWork", totalWork);

		map.put("waStatus", "조퇴");
		int outWork = this.attendService.getCountList(map);
		log.info("getCountList 결과->outWork : " + outWork);
		model.addAttribute("outWork", outWork);

		map.put("waStatus", "지각");
		int lateWork = this.attendService.getCountList(map);
		log.info("getCountList 결과->lateWork : " + lateWork);
		model.addAttribute("lateWork", lateWork);

		return "attend/hldymngList";
	}
	 
	
	/**
	 * 출근 목록에 대한 정보를 가져오는 ajax 동작을 위한 컨트롤러
	 * @param session
	 * @param map
	 * @return "SUCCESS"
	 */
	@ResponseBody
	@PostMapping("/listAjax3")
	public String listAjax3(HttpSession session,
			@RequestBody Map<String, Object> map) {
		log.info("받은 정보 gtWorkString:"+map);
		
		session.setAttribute("gtWork", map);
		
		return "SUCCESS";
	}
	
	
	/**
	 * 퇴근 목록에 대한 정보를 가져오는 ajax 동작을 위한 컨트롤러
	 * @param session
	 * @param map
	 * @return "SUCCESS"
	 */
	@ResponseBody
	@PostMapping("/listAjax4")
	public String listAjax4(HttpSession session,
			@RequestBody Map<String, Object> map) {
		log.info("받은 정보 dnWorkString:"+map);
		
		session.setAttribute("dnWork", map);
		
		return "SUCCESS";
	}
	
	
	/** 휴가 목록에 대한 정보를 가져오는 컨트롤러
	 * @param model
	 * @param principal
	 * @return 근태 및 휴가 관리 목록 페이지(view name: "attend/hldymngList")
	 */
	@GetMapping("/list2")
	public String getVacationList(Model model, Principal principal) {
		
		if(principal == null) {
			return "redirect:/login";
		}
		log.info("principal:"+principal);
		
		return "attend/hldymngList";
	}
}
