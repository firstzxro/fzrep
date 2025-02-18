package kr.or.oho.eatrzt.contoller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.oho.eatrzt.service.EatrztService;
import kr.or.oho.mapper.EatrztMapper;
import kr.or.oho.mapper.EmployeeMapper;
import kr.or.oho.salary.service.SalaryService;
import kr.or.oho.utils.UploadController;
import kr.or.oho.vo.AtrzlnVO;
import kr.or.oho.vo.AttachVO;
import kr.or.oho.vo.EatrztVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.TmpltVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/eatrzt")
@Controller
public class EatrztController {
	
	@Autowired
	EatrztService eatrztService;
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Autowired
	UploadController uploadController;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;
	
	/**
	 * 전자결재 홈으로 가는 컨트롤러
	 * @param model
	 * @param eatrztVO
	 * @param principal
	 * @return 전자결재 홈 페이지("eatrzt/eatrztHome")
	 */
	@GetMapping("/eatrztHome")
	public String home(Model model, EatrztVO eatrztVO, Principal principal) {
		log.info("전자결재에 왔다,principal : " + principal);
		
		if(principal==null) {
			return "redirect:/login";
		}
		
		log.info("principal.getName():{}",principal.getName());
		log.info("employeeMapper:{}",employeeMapper);
		log.info("employeeMapper.detail{}:",employeeMapper.detail(principal.getName()));
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp.getEmpNo());
		
		List<EatrztVO> docBoxList = this.eatrztService.docBoxList(emp.getEmpNo());
		model.addAttribute("docBoxList", docBoxList);
		
		List<EatrztVO> nDocBoxList = this.eatrztService.nDocBoxList(emp.getEmpNo());
		log.info("nDocBoxList에 왔다");
		model.addAttribute("nDocBoxList", nDocBoxList);
		
		List<EatrztVO> beforeApvBoxList = this.eatrztService.beforeApvBoxList(emp.getEmpNo());
		log.info("beforeApvBoxList : " + beforeApvBoxList);
		model.addAttribute("beforeApvBoxList", beforeApvBoxList);
		
		List<EatrztVO> apvBoxList = this.eatrztService.apvBoxList(emp.getEmpNo());
		model.addAttribute("apvBoxList", apvBoxList);
		
		return "eatrzt/eatrztHome";
	}
	
	
	/**
	 * 기안문서함 목록을 가져오는 컨트롤러
	 * @param gstatus
	 * @param model
	 * @param principal
	 * @return 기안문서함 목록 페이지("eatrzt/docBoxList")
	 */
	@GetMapping("/docBoxList")
	public String docBoxList(@RequestParam(value ="gstatus", required = false, defaultValue ="" ) String gstatus,Model model, Principal principal) {
		log.info("기안문서함에 왔다 {}", gstatus);
		
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp.getEmpNo());

		List<EatrztVO> nApvBoxList = new ArrayList<EatrztVO>();
		List<EatrztVO> docBoxList = new ArrayList<EatrztVO>();
		if(gstatus.equals("N")) {
			nApvBoxList = this.eatrztService.nApvBoxList(emp.getEmpNo());			
			model.addAttribute("docBoxList", nApvBoxList);
		}else {
			docBoxList = this.eatrztService.docBoxList(emp.getEmpNo());			
			model.addAttribute("docBoxList", docBoxList);
		}		
		return "eatrzt/docBoxList";
	}
	
	/**
	 * 결재문서함 목록을 가져오는 컨트롤러
	 * @param model
	 * @param eatrztVO
	 * @param principal
	 * @return 결재문서함 목록 페이지("eatrzt/apvBoxList")
	 */
	@GetMapping("/apvBoxList")
	public String apvBoxList(Model model, EatrztVO eatrztVO, Principal principal) {
		log.info("결재문서함에 왔다");
		
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp.getEmpNo());
		
		List<EatrztVO> apvBoxList = this.eatrztService.apvBoxList(emp.getEmpNo());
		
		model.addAttribute("apvBoxList", apvBoxList);
		
		return "eatrzt/apvBoxList";
	}
	
	/**
	 * 결재대기함 목록을 가져오는 컨트롤러
	 * @param model
	 * @param principal
	 * @return 결재대기함 목록 페이지("eatrzt/beforeApvBoxList")
	 */
	@GetMapping("/beforeApvBoxList")
	public String beforeApvBoxList(Model model, Principal principal) {
		log.info("결재대기문서함에 왔다");
		
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp.getEmpNo());
		
		List<EatrztVO> beforeApvBoxList = this.eatrztService.beforeApvBoxList(emp.getEmpNo());
		
		model.addAttribute("beforeApvBoxList", beforeApvBoxList);
		
		return "eatrzt/beforeApvBoxList";
	}
	
	/**
	 * 전자결재 문서작성 정보를 가져오는 컨트롤러
	 * @param model
	 * @param principal
	 * @return 전자결재 문서작성 페이지("eatrzt/create")
	 */
	@GetMapping("/create")
	public String create(Model model, Principal principal) {
		
		String testPwd = bcryptPasswordEncoder.encode            ("12345");
		
		log.info("문서작성에 왔다, testPwd : " + testPwd);
		
		//로그인한 사람의 아이디
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp.getEmpNo());
		
		//문서작성하기의 기본정보를 위함
		EatrztVO comList = this.eatrztService.comList(emp.getEmpNo());
		log.info("create -> emp : " + emp);
		
		//결재자 목록1
		List<EmployeeVO> atrzlnList = this.salaryService.getName();
		log.info("create -> atrzlnList : " + atrzlnList);
		
		//결재자 목록2
		List<EmployeeVO> employeeVOList = this.eatrztService.getName();
		log.info("employeeVOList : " + employeeVOList);
		
		//서식 목록
		List<TmpltVO> tmpltVOList = this.eatrztService.tmpltList();
		log.info("tmpltVOList : " + tmpltVOList);
		
		model.addAttribute("employeeVOList", employeeVOList);
		model.addAttribute("tmpltVOList", tmpltVOList);
		model.addAttribute("comList", comList);
		model.addAttribute("atrzlnList", atrzlnList);
		
		return "eatrzt/create";
	}
	
	
	/**
	 * 문서 목록을 조회하는 컨트롤러
	 * @param tmpltVO
	 * @return 문서 목록을 조회 기능을 tmpltVO에 담아 return
	 */
	@ResponseBody
	@PostMapping("/createPost")
	public TmpltVO createPost(@RequestBody TmpltVO tmpltVO) {
		log.info("createPost에 왔다");
		
		log.info("tmpltVO1:" + tmpltVO);
		tmpltVO = this.eatrztService.createPost(tmpltVO);
		log.info("tmpltVO2:" + tmpltVO);
		
		return tmpltVO;
	}
	
	/**
	 * 전자결재 상세보기 정보를 가져오는 컨트롤러 
	 * @param model
	 * @param eatrztVO
	 * @param atrzlnVO
	 * @param principal
	 * @return 전자결재 상세보기 페이지("eatrzt/detail")
	 */
	@GetMapping("/detail")
	public String detail(Model model, EatrztVO eatrztVO, AtrzlnVO atrzlnVO, Principal principal) {
		log.info("결재 상세보기에 왔다");
		
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
		log.info("로그인 한 emp 정보 : " + emp.getEmpNo());
		
		log.info("eatrztVO ffff결재선번호와야함:" + eatrztVO);
		
		EatrztVO getEatrzt = this.eatrztService.getEatrzt(eatrztVO);
		log.info("detail -> getEatrzt : " + getEatrzt);
		
		AtrzlnVO chkAtrzlnVO = new AtrzlnVO();
		chkAtrzlnVO.setEatrztNo(getEatrzt.getEatrztNo());
		chkAtrzlnVO.setEmpNo(emp.getEmpNo());
		
		AtrzlnVO check = this.eatrztService.check(chkAtrzlnVO);
		log.info("check :" +check);
		
		eatrztVO.setEatrztNo(getEatrzt.getEatrztNo());
		
		List<AttachVO> attachList = this.eatrztService.attachList(eatrztVO);
		log.info("detail -> attachList : " + attachList);
		
		List<AtrzlnVO> stampAtrList = this.eatrztService.stampAtrList(eatrztVO);
		
		List<AtrzlnVO> stampAtrList2 = this.eatrztService.stampAtrList2(eatrztVO);
		log.info("stampAtrList2 : " + stampAtrList2);
		
		model.addAttribute("emp", emp);
		model.addAttribute("getEatrzt", getEatrzt);
		model.addAttribute("attachList", attachList);
		model.addAttribute("check", check);
		model.addAttribute("stampAtrList", stampAtrList);
		model.addAttribute("stampAtrList2", stampAtrList2);
		
		return "eatrzt/detail";
	}
	
	/**
	 * 전자 결재 등록하는 컨트롤러
	 * @param eatrztVO
	 * @param principal
	 * @return 기안문서함 페이지("/eatrzt/docBoxList")
	 */
	@PostMapping("/eatrztPost")
	public String eatrztPost(EatrztVO eatrztVO, Principal principal) {
		
		EmployeeVO emp = this.employeeMapper.detail(principal.getName());
	    log.info("로그인 한 emp 정보 : " + emp.getEmpNo());
		
		eatrztVO.setEmpNo(emp.getEmpNo());
		log.info("eatrztVO : " + eatrztVO);
		
		int result = this.eatrztService.eatrztPost(eatrztVO);
		log.info("result : " + result);
		
		int result2 = uploadController.uploadMulti(eatrztVO.getFile(), eatrztVO.getEatrztNo());
		log.info("result2 : " + result2);
		
		return "redirect:/eatrzt/docBoxList";
	}

	
	
	/**
	 * 결재를 승인하는 ajax 동작을 위한 컨트롤러
	 * @param atrzlnVO
	 * @return 결재를 승인한 결과를 atrzlnVO에 담아 return
	 */
	@ResponseBody
	@PostMapping("/atrUpdatePost")
	public AtrzlnVO atrUpdatePost(@RequestBody AtrzlnVO atrzlnVO) {
		log.info("atrUpdatePost에 왔다");
		
		int result = eatrztService.atrUpdatePost(atrzlnVO);
		log.info("atrUpdatePost -> result : " + result);
		
		return atrzlnVO;
	}
	
	/**
	 * 결재를 반려하는 ajax 동작을 위한 컨트롤러
	 * @param eatrztVO
	 * @return 결재를 반려한 결과를 eatrztVO에 담아 return
	 */
	@ResponseBody
	@PostMapping("/reAtrUpdatePost")
	public EatrztVO reAtrUpdatePost(@RequestBody EatrztVO eatrztVO) {
		log.info("reAtrUpdatePost에 왔다");
		
		int result = eatrztService.eatrztUpdate(eatrztVO);
		log.info("atrUpdatePost -> result : " + result);
		
		return eatrztVO;
	}
	
	
	/**
	 * 문서 삭제 ajax 동작을 위한 컨트롤러
	 * @param eatrztVO
	 * @return 삭제처리한 결과를 eatrztVO에 담아 return
	 */
	@ResponseBody
	@PostMapping("/delUpdate")
	public EatrztVO delUpdate(@RequestBody EatrztVO eatrztVO) {
		log.info("delUpdate에 왔다");
		
		int result = eatrztService.delUpdate(eatrztVO);
		log.info("delUpdate -> result : " + result);
		
		return eatrztVO;
	}
	
	
}
