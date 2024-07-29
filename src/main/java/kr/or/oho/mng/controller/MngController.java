package kr.or.oho.mng.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.oho.frcorder.service.FrcorderService;
import kr.or.oho.mng.service.MngService;
import kr.or.oho.salary.service.SalaryService;
import kr.or.oho.vo.ComcdVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.FranchiseVO;
import kr.or.oho.vo.MngVO;
import kr.or.oho.vo.SalaryVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author PC-05
 *
 */
/**
 * @author PC-05
 *
 */
@Slf4j
@Controller
@RequestMapping("/mng")
public class MngController {
	
	@Autowired
	MngService mngService;
	
	@Autowired
	SalaryService salaryService;
	
	@Autowired
	FrcorderService frcorderService;
	
	/**
	 * 일정 정보를 가져오는 컨트롤러
	 * @param model
	 * @return 일정 홈페이지("mng/list")
	 */
	@GetMapping("/list")
	public String list(Model model) {
		log.debug("mng/list에 왔다.");
		
		List<MngVO> mngVOList = this.mngService.getList();
		
		MngVO count = this.mngService.getCount();
		
		List<EmployeeVO> employeeVOList = this.salaryService.getName();
		log.debug("employeeVOList : "+ employeeVOList);
		
		// 모든 지역 정보
		List<ComcdVO> locationVOList = this.frcorderService.getAllLoc();
		log.info("locationVOList -> locationVOList : " + locationVOList);
		
		model.addAttribute("employeeVOList",employeeVOList);
		model.addAttribute("locationVOList",locationVOList);
		model.addAttribute("mngVOList",mngVOList);
		model.addAttribute("count",count);
		
		return "mng/list";
	}
	
	/**
	 * 일정생성하는 컨트롤러
	 * @param mngVO
	 * @return 일정 생성 기능을 mngVOList에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/create")
	public List<MngVO> createMng(@RequestBody MngVO mngVO){
		
		int cnt = this.mngService.createMng(mngVO);
		log.debug("cnt :"+cnt );
		
		List<MngVO> mngVOList = this.mngService.getList();
		log.debug("mngVOList : " + mngVOList);
		
		return mngVOList;
	}
	
	/**
	 * 일자별 일정 조회하는 컨트롤러
	 * @param mngVO
	 * @return 일자별 일정 조회 기능을 mngVOList에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/oneMng")
	public List<MngVO> oneMng(@RequestBody MngVO mngVO){
		
		List<MngVO> mngVOList = this.mngService.getOneDay(mngVO);
		log.debug("mngVOList : " + mngVOList);
		
		return mngVOList;
	}
	
	/**
	 * 상세 정보 조회하는 컨트롤러
	 * @param mngNo
	 * @return 상세보기 기능을 mngVO에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/detail")
	public MngVO detail(@RequestBody String mngNo) {
		
		MngVO mngVO = this.mngService.detail(mngNo);
		log.debug("mngVO : "+mngVO);
		
		return mngVO;
	}
	
	/**
	 * 현황 출력용 카운트된 일정 수 가져오는 컨트롤러
	 * @return mngVO에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/getCount")
	public MngVO getCount() {
		
		MngVO mngVO = this.mngService.getCount();
		log.debug("mngVO : "+mngVO);
		
		return mngVO;
	}
	
	/**
	 * 방문일정 수정하는 컨트롤러
	 * @param mngVO
	 * @return 방문일정 수정한 기능을 mngVOList에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/update")
	public List<MngVO> update(@RequestBody MngVO mngVO){
		log.debug("mngVO :"+ mngVO);
		
		int cnt = this.mngService.update(mngVO);
		
		List<MngVO> mngVOList = this.mngService.getList();
		log.debug("mngVOList : " + mngVOList);
		
		return mngVOList;
	}
	
	/**
	 * 방문일정 완료처리하는 컨트롤러
	 * @param mngNo
	 * @return mngVOList에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/done")
	public List<MngVO> done(@RequestBody String mngNo){
		log.debug("mngNo :"+ mngNo);
		
		int cnt = this.mngService.done(mngNo);
		
		List<MngVO> mngVOList = this.mngService.getList();
		log.debug("mngVOList : " + mngVOList);
		
		return mngVOList;
	}
	
	/**
	 * 방문일정 삭제하는 컨트롤러
	 * @param mngNo
	 * @return mngVOList에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("/delete")
	public List<MngVO> delete(@RequestBody String mngNo){
		log.debug("mngNo :"+ mngNo);
		
		int cnt = this.mngService.delete(mngNo);
		
		List<MngVO> mngVOList = this.mngService.getList();
		log.debug("mngVOList : " + mngVOList);
		
		return mngVOList;
	}
	
	/**
	 * 알람용 기본키 최대값 가져오는 컨트롤러
	 * @return max에 담아 리턴
	 */
	@ResponseBody
	@PostMapping("getMax")
	public String getMax() {
		
		String max = this.mngService.getMax();
		
		return max;
	}
}
