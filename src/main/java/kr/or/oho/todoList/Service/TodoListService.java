package kr.or.oho.todoList.Service;

import java.util.List;
import java.util.Map;

import kr.or.oho.vo.TodoListVO;

public interface TodoListService {

	/**
	 * 캘린더 정보 가져오기
	 * @param map
	 * @return
	 */
	List<TodoListVO> getCalendarList(Map<String, Object> map);

	/**
	 * 개인일정 체크박스 가져오기
	 * @param map
	 * @return
	 */
	List<TodoListVO> getCheckBoxList(Map<String, Object> map);
	
	/**
	 * 부서 일정 체크박스 가져오기
	 * @param map
	 * @return
	 */
	List<TodoListVO> getCheckBoxList2(Map<String, Object> map);
	
	/**
	 * 모든 일정 체크박스 가져오기
	 * @param map
	 * @return
	 */
	List<TodoListVO> getCheckBoxList3(Map<String, Object> map);
	
	/**
	 * 일정 상세
	 * @param todoListVO
	 * @return
	 */
	TodoListVO getCalendarDetail(TodoListVO todoListVO);
	
	/**
	 * 오늘 날짜의 일정 갯수 가져오기
	 * @param
	 * @return 
	 */
	int getCalendarCount(String empNo);
	
	/**
	 * 일정 생성
	 * @param todoListVO
	 * @return
	 */
	int createPost(TodoListVO todoListVO);

	/**
	 * 일정 수정
	 * @param todoListVO
	 * @return
	 */
	int updatePost(TodoListVO todoListVO);

	/**
	 * 일정 삭제
	 * @param todoListVO
	 * @return
	 */
	int deletePost(TodoListVO todoListVO);






	

}
