package kr.or.oho.todoList.controller;


import java.security.Principal;
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

import kr.or.oho.mapper.EmployeeMapper;
import kr.or.oho.todoList.Service.TodoListService;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.TodoListVO;
import lombok.extern.slf4j.Slf4j;

/**
 * @author PC-05
 *
 */
@RequestMapping("/todoList")
@Slf4j
@Controller
public class TodoListController {
	
	@Autowired
	TodoListService todoListService;

	@Autowired
	private EmployeeMapper employeeMapper;
     	
	/**
	 * 일정 정보를 가져오는 컨트롤러
	 * @return
	 */
	@GetMapping("/list")
	public String getCalendarList() {
		
		return "todoList/todoAllList";
	}
	
	/**
	 * 일정 목록을 가져오는 컨트롤러
	 * @param map
	 * @return todoListVOList
	 */
	@ResponseBody
	@PostMapping("/listAjax")
	public List<TodoListVO> getCalendarListAjax(@RequestBody Map<String, Object> map) {
		log.info("listAjax에서 전송받은 데이터 :" + map);
		
		List<TodoListVO> todoListVOList = this.todoListService.getCalendarList(map);
	    log.info("가져온 이벤트 리스트: " +  todoListVOList);
		
		return todoListVOList;
	}
	
	
	/**
	 * 개인일정 목록을 가져오는 컨트롤러
	 * @param map
	 * @return todoListVOList
	 */
	@ResponseBody
	@PostMapping("/peCheckBoxListAjax")
	public List<TodoListVO> getCheckBoxListAjax(@RequestBody Map<String, Object> map) {
		log.info("개인체크박스 이벤트를 가져옵니다..."+map);
		
		List<TodoListVO> todoListVOList = this.todoListService.getCheckBoxList(map);
	    log.info("가져온 체크박스 이벤트 리스트: " +  todoListVOList);
		
		return todoListVOList;
	}
	
	/**
	 * 부서일정 목록을 가져오는 컨트롤러
	 * @param map
	 * @return todoListVOList
	 */
	@ResponseBody
	@PostMapping("/deCheckBoxListAjax")
	public List<TodoListVO> getCheckBoxListAjax2(@RequestBody Map<String, Object> map) {
		log.info("부서체크박스 이벤트를 가져옵니다...");
		
		List<TodoListVO> todoListVOList = this.todoListService.getCheckBoxList2(map);
	    log.info("가져온 체크박스 이벤트 리스트: " +  todoListVOList);
		
		return todoListVOList;
	}
	
	/**
	 * 모든 일정 체크박스를 가져오는 컨트롤러
	 * @param map
	 * @return todoListVOList
	 */
	@ResponseBody
	@PostMapping("/alCheckBoxListAjax")
	public List<TodoListVO> getCheckBoxListAjax3(@RequestBody Map<String, Object> map) {
		log.info("모든체크박스 이벤트를 가져옵니다...");
		
		List<TodoListVO> todoListVOList = this.todoListService.getCheckBoxList3(map);
	    log.info("가져온 체크박스 이벤트 리스트: " +  todoListVOList);
		
		return todoListVOList;
	}
	
	/**
	 * 일정 상세보기를 가져오는 컨트롤러
	 * @param todoListVO
	 * @return todoListVOList
	 */
	@ResponseBody
	@PostMapping("/detailAjax")
	public TodoListVO detail(@RequestBody TodoListVO todoListVO) {
		log.info("detail(전)->todoListVO :"+todoListVO);
		
		todoListVO = this.todoListService.getCalendarDetail(todoListVO);
		log.info("detail(후)->todoListVO : " + todoListVO);
		
		return todoListVO;
	}
	
	/**
	 * 일정수를 가져오는 컨트롤러
	 * @param empNo
	 * @param model
	 * @return SUCCESS
	 */
	@ResponseBody
	@PostMapping("/getCountAjax")
	public String getCalendarCount(@RequestBody String empNo, Model model) {
		log.info("getCountAjax(전)->todoListVO :"+empNo);
		
		int getCountWork = this.todoListService.getCalendarCount(empNo);
		log.info("getCountAjax(후)->getCountWork : " + getCountWork);
		
		model.addAttribute("getCountWork", getCountWork);
		
		return "SUCCESS";
	}
	
	/**
	 * 일정을 생성하는 컨트롤러
	 * @param todoListVO
	 * @return SUCCESS
	 */
	@ResponseBody
	@PostMapping("/createAjax")
	public String createAjax(@RequestBody TodoListVO todoListVO) {
		 
	log.info("createAjax(전)->todoListVO : " + todoListVO);
	  
	int result = this.todoListService.createPost(todoListVO);
	log.info("createAjax(후)->result : " + result);
	
	return "SUCCESS";
	}
	
	/**
	 * 일정을 수정하는 컨트롤러
	 * @param todoListVO
	 * @return todoListVO
	 */
	@ResponseBody
	@PostMapping("/updateAjax")
	public TodoListVO updateAjax(@RequestBody TodoListVO todoListVO) {
		log.info("updateAjax(전)->todoListVO :" +todoListVO);
		
		//날짜 처리
		//DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.KOREA);
	
		//insert, update, delete의  return타입 : int 타입
		int result = this.todoListService.updatePost(todoListVO);
		log.info("updateAjax(후)->result :" +result);
		
		//상세보기
		todoListVO = this.todoListService.getCalendarDetail(todoListVO);
		
		return todoListVO;
	}
	
	/**
	 * 일정을 삭제하는 컨트롤러
	 * @param todoListVO
	 * @return todoListVO
	 */
	@ResponseBody
	@PostMapping("/deleteAjax")
	public TodoListVO deleteAjax(@RequestBody TodoListVO todoListVO) {
		log.info("deleteAjax(전)->todoListVO :" + todoListVO);
		
		//insert, update, delete의  return타입 : int 타입
		int result = this.todoListService.deletePost(todoListVO);
		
		return todoListVO;
	}
	
	/**
	 * EmployeeVO 정보 가져오기
	 * @author PC-01
	 * @return empno
	 *
	 */
	@ResponseBody
	@GetMapping("/getEmp")
	public EmployeeVO GetEmp(Principal principal) {
		String empId = principal.getName();
		
		log.info("GetEmp->empId : " + empId);
		
	    EmployeeVO emp = this.employeeMapper.detail(empId);
		log.info("로그인 한 emp 정보 : " + emp);
	    
	    return emp;
	}
	
	/**
	 * EmployeeVO 정보 가져오기
	 * @author PC-01
	 * @return deptno
	 *
	 */
	@ResponseBody
	@GetMapping("/getDept")
	public EmployeeVO GetDept(Principal principal) {
		String empId = principal.getName();
		
		log.info("GetEmp->empId : " + empId);
		
	    EmployeeVO dept = this.employeeMapper.getDetpNo(empId);
		log.info("로그인 한 dept 정보 : " + dept);
		
	    return dept;
	}
	

	
}
