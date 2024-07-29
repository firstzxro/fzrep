package kr.or.oho.vo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class EmployeeVO {
	private String empNo;		// 사원번호 
	private String empNm;		// 사원명 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date empBrdt;		// 생년월일
	private String empEmlAddr;	// 이메일
	private int empZip;			// 우편번호
	private String empAddr;		// 주소
	private String empDaddr;	// 상세주소
	private String empTelno;	// 전화번호
	private String empMrgYn;	// 기혼여부
	private int empAmt;			// 연봉
	private String empImg;		// 프로필사진(uploadFile.getOriginalFileName())
	private String empId;		// 아이디
	private String empPswd;		// 비밀번호
	private String empGen;		// 성별
	private Date empEmpymd;		// 입사일
	private Date empWhdwlYmd;	// 퇴사일
	private String empJncmpYmd;	// 은행명
	private String empActno;	// 계좌번호
	private int empRv;			// 잔여연차
	private String enabled;		// 퇴사여부
	private String empJbgdNm;	// 직위
	private String empJbttlNm;	// 직책
	private String empClsf;		// 회원분류
	private String deptNo;     	// 부서번호
	private String comcdCdnm;   // 공통코드명
	private DeptVO deptVO;      // 부서VO
	private String deptNm;		// 부서명
	private AttachVO attachVO;	// 사진파일VO
	
	
	private String cvmlUsePrps; // 차량관리대장 대여목적
	private String cvmlUser;	// 차량관리대장 회원번호
	private String cvmlNo;		// 차량관리대장 번호
	
	private MultipartFile[] uploadFile;		//여러 첨부파일
	private MultipartFile uploadFileOne;	//첨부팡리 1개
	
	
	private List<EmployeeAuthrtVO> empAuthVOList;	//직원 서명 목록
	private List<FranchiseVO> franchiseVOList;		//가맹점 목록
	
	private String frcsNo;			//가맹점 번호
				
}
