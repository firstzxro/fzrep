package kr.or.oho.franchise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.oho.franchise.service.FranchiseService;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.FranchiseVO;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/frcs")
public class FranchiseController {

	@Autowired FranchiseService frcsService;
	
	/**
	 * 프랜차이즈 목록 정보를 가져오는 컨트롤러
	 * @param model
	 * @return 프랜차이즈 목록 조회 페이지("franchise/frcsList")
	 */
	@GetMapping("/list")
	public String frcsList(Model model) {
		
		log.info("frcsList 도착");
		
		List<FranchiseVO> frcsList = this.frcsService.frcsList();
		log.debug("frcsList : " + frcsList);
		
		model.addAttribute("frcsList", frcsList);
		
		return "franchise/frcsList";
	}
	
	/**
	 * 프랜차이즈 목록 조회하는 컨트롤러
	 * @param success
	 * @return 프랜차이즈 목록 조회 정보를 frcsVOList에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/getAllList")
	public List<FranchiseVO> getAllList(@RequestBody String success) {
		log.debug("frcs getAllList 시작");
		
		List<FranchiseVO> frcsVOList = this.frcsService.frcsList();
		log.debug("frcsVO : " + frcsVOList);
		
		return frcsVOList;
		
	}
	
	/**
	 * 프랜차이즈 상세보기를 조회하는 컨트롤러
	 * @param frcsVO
	 * @return 상세보기 정보를 frcsVO에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/detail")
	public EmployeeVO frcsDetail(@RequestBody EmployeeVO frcsVO) {
		log.debug("frcs detail 시작");
		
		frcsVO = this.frcsService.frcsDetail(frcsVO);
		log.debug("frcsVO : " + frcsVO);
		
		return frcsVO;
		
	}
	
	
	/**
	 * 수정된 프랜차이즈 목록 조회하는 컨트롤러
	 * @param frcsNo
	 * @param model
	 * @return 프랜차이즈 목록 페이지("franchise/frcsUpdateList")
	 */
	@GetMapping("/update")
	public String getfrcsInfo(String frcsNo, Model model) {
		
		log.debug("update에 왔다");
		log.debug("frcsNo : " + frcsNo);
		
		FranchiseVO frcsVO = this.frcsService.getfrcsInfo(frcsNo);
		EmployeeVO empVO = this.frcsService.getFrcsEmpInfo(frcsNo);
		
		
		log.debug("frcsNo : " + frcsNo);
		log.debug("frcsVO : " + frcsVO);
		
		model.addAttribute("frcsVO", frcsVO);
		model.addAttribute("empVO", empVO);
		
		return "franchise/frcsUpdateList";
	}
	
	
	/**
	 * 가맹점 수정하는 ajax 정보를 담은 컨트롤러
	 * @param frcsVO
	 * @return 가맹점 수정 기능을 cnt로 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/updateFrcsAjax")
	public int frcsAjax(@RequestBody FranchiseVO frcsVO) {
		
		log.debug("가맹점 수정용 ajax 도착");
		log.debug("frcsVO : " + frcsVO);
		
		int cnt = this.frcsService.updateFranchiseInfo(frcsVO);
		
		return cnt;
	}
	
	/**
	 * 가맹점주 수정하는 ajax 정보를 보내는 컨트롤러
	 * @param employeeVO
	 * @return 가맹점주 수정 기능을 cnt로 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/updateFrcsEmpAjax")
	public int frcsEmpAjax(@RequestBody EmployeeVO employeeVO) {
		
		log.debug("가맹점주 수정용 ajax 도착");
		log.debug("employeeVO : " + employeeVO);
		
		int cnt = this.frcsService.updateFrcsEmpInfo(employeeVO);
		
		return cnt;
	}
	
	/**
	 * 가맹점 삭제하는 ajax 정보를 보내는 컨트롤러
	 * @param frcsNo
	 * @return 가맹점 삭제 기능을 cnt로 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/deleteFranchiseAjax")
	public int deleteFranchise(@RequestBody FranchiseVO frcsNo) {
	
		log.debug("가맹점 삭제 ajax 도착");
		log.debug("frcsNo : " + frcsNo);
		
		int cnt = this.frcsService.deleteFranchise(frcsNo);
		
		return cnt;

	}
	
	
}