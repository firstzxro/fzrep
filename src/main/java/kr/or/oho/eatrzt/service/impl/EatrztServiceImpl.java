package kr.or.oho.eatrzt.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.velocity.runtime.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.oho.eatrzt.service.EatrztService;
import kr.or.oho.mapper.AttachMapper;
import kr.or.oho.mapper.EatrztMapper;
import kr.or.oho.vo.AtrzlnVO;
import kr.or.oho.vo.AttachVO;
import kr.or.oho.vo.EatrztVO;
import kr.or.oho.vo.EmployeeVO;
import kr.or.oho.vo.HldyMngLdgrVO;
import kr.or.oho.vo.TmpltVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EatrztServiceImpl implements EatrztService {

	@Autowired
	EatrztMapper eatrztMapper;
	
	@Autowired
	AttachMapper attachMapper;
	
	/**
	 * 기안문서함으로 가는 서비스
	 * @param empNo
	 * @return
	 */
	@Override
	public List<EatrztVO> docBoxList(String empNo) {
		return this.eatrztMapper.docBoxList(empNo);
	}

	/**
	 * 결재대기문 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	@Override
	public List<EatrztVO> beforeApvBoxList(String empNo) {
		return this.eatrztMapper.beforeApvBoxList(empNo);
	}

	/**
	 * 결재문서 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	@Override
	public List<EatrztVO> apvBoxList(String empNo) {
		return this.eatrztMapper.apvBoxList(empNo);
	}

	/**
	 * 문서 목록을 조회하는 서비스
	 * @param tmpltVO
	 * @return
	 */
	@Override
	public TmpltVO createPost(TmpltVO tmpltVO) {
		return this.eatrztMapper.createPost(tmpltVO);
	}

	/**
	 * 사원 목록을 가져오는 서비스
	 * @return
	 */
	@Override
	public List<EmployeeVO> getName() {
		return this.eatrztMapper.getName();
	}

	/**
	 * 문서서식 목록을 가져오는 서비스
	 * @return
	 */
	@Override
	public List<TmpltVO> tmpltList() {
		return this.eatrztMapper.tmpltList();
	}

	/**
	 * 상세보기에서 공통부분을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	@Override
	public EatrztVO comList(String empNo) {
		return this.eatrztMapper.comList(empNo);
	}

	/**
	 * 전자 결재 등록하는 서비스
	 * @param eatrztVO
	 * @return
	 */
	@Transactional
	@Override
	public int eatrztPost(EatrztVO eatrztVO) {
		//1) 부모
		int result = this.eatrztMapper.eatrztPost(eatrztVO);
		
		//ATRZLN테이블에 기안자로써 insert
		AtrzlnVO atrzlnVO = new AtrzlnVO();
		atrzlnVO.setAtrzlnNo("");
		atrzlnVO.setEmpNo(eatrztVO.getEmpNo());
		atrzlnVO.setEatrztNo(eatrztVO.getEatrztNo());
		atrzlnVO.setAtrzlnPro(0);
		
		//2) 기안자
		result += this.eatrztMapper.atrzlnPost(atrzlnVO);
		
		//3) 결재자들
		List<AtrzlnVO> atrzlnVOList = eatrztVO.getAtrzlnVOList();
		
		int cnt = 1;
		for(AtrzlnVO vo : atrzlnVOList) {
			vo.setEatrztNo(eatrztVO.getEatrztNo());
			vo.setAtrzlnPro(cnt++);
			
			result += this.eatrztMapper.atrzlnPost2(vo);
		}
		
		log.info("result(끝) : " + result);
		return result;
	}
	
	/**
	 * 결재선 목록을 가져오는 서비스
	 * @return
	 */
	@Override
	public List<Map<String, Object>> atrzlnList() {
		return this.eatrztMapper.atrzlnList();
	}
	
	/**
	 * 결재 상세보기 정보를 가져오는 서비스
	 * @param eatrztVO
	 * @return
	 */
	@Override
	public EatrztVO getEatrzt(EatrztVO eatrztVO) {
		return this.eatrztMapper.getEatrzt(eatrztVO);
	}
	
	/**
	 * 첨부파일 목록을 가져오는 서비스
	 * @param eatrztVO
	 * @return
	 */
	@Override
	public List<AttachVO> attachList (EatrztVO eatrztVO) {
		
		List<AttachVO> attachList = this.eatrztMapper.attachList(eatrztVO);
		for (AttachVO attachVO : attachList) {
			long afSz = attachVO.getAfSz();
			long changeSz = Math.round(afSz/1024);
			
			attachVO.setAfSz(changeSz);
		}
		
		return attachList;
	}
	
	/**
	 * 결재를 승인하는 ajax 동작을 위한 서비스
	 * @param atrzlnVO
	 * @return
	 */
	@Override
	public int atrUpdatePost(AtrzlnVO atrzlnVO) {
		//결재선 update
		int result = eatrztMapper.atrUpdatePost(atrzlnVO);
		log.info("atrUpdatePost -> atrzlnVO: " + atrzlnVO);
		
		//결재순서가 최종 결재자인지 확인
		int atrzlnPro = eatrztMapper.checkFinalApproval(atrzlnVO.getAtrzlnNo());

		//총 결재선의 수
        int finalApprovalValue = eatrztMapper.finalApprovalValue(atrzlnVO.getEatrztNo());

        //결재순서가 총 결재선의 수와 같으면 결재상태가 'I(진행중)'에서 'Y(승인)으로 update'
        if (atrzlnPro == finalApprovalValue) {
            //Update eatrzt
            eatrztMapper.updateEatrztAfterApproval(atrzlnVO.getEatrztNo());
            //연차 서식을 가지고 있는 결재선인지 확인  
            int checkHldyTmplt = eatrztMapper.checkHldyTmplt(atrzlnVO);
            log.info("checkHldyTmplt 결과 :" + checkHldyTmplt);
            HldyMngLdgrVO hldyMngLdgrVO = new HldyMngLdgrVO();
            hldyMngLdgrVO.setEmpNo(atrzlnVO.getEmpNo());
            hldyMngLdgrVO.setHsNo(atrzlnVO.getHsNo());
            hldyMngLdgrVO.setHmlUseDt(atrzlnVO.getHmlUseDt());
            hldyMngLdgrVO.setHmlEndDt(atrzlnVO.getHmlEndDt());
            hldyMngLdgrVO.setEatrztNo(atrzlnVO.getEatrztNo());
            hldyMngLdgrVO.setHmlRsn(atrzlnVO.getHmlRsn());;
            	if(checkHldyTmplt == 1) {
            		//연차 관리 대장 insert
            		result += eatrztMapper.hldyInsert(hldyMngLdgrVO);	
            	}
        }

        return result;
	}

	/**
	 * 결재 확인용 서비스
	 * @param chkAtrzlnVO
	 * @return
	 */
	@Override
	public AtrzlnVO check(AtrzlnVO chkAtrzlnVO) {
		//해당 전자결재문서 번호에 맞는 결재선 번호인지 확인
		return this.eatrztMapper.check(chkAtrzlnVO);
	}

	/**
	 * 결재를 반려하는 ajax 동작을 위한 서비스
	 * @param eatrztVO
	 * @return
	 */
	@Override
	public int eatrztUpdate(EatrztVO eatrztVO) {
		//반려 시 결재상태를 'I(진행중)'에서 'N(반려)'로 update한 결과를 담아줌.
		int result = eatrztMapper.eatrztUpdate(eatrztVO);
		
		//결재일자를 'null'로 update함
		 result += eatrztMapper.atrzlnUpdate(eatrztVO.getEatrztNo());
		
		return result;
	}

	/**
	 * 문서 삭제 ajax 동작을 위한 서비스
	 * @param eatrztVO
	 * @return
	 */
	@Override
	public int delUpdate(EatrztVO eatrztVO) {
		return this.eatrztMapper.delUpdate(eatrztVO);
	}

	/**
	 * 반려된 기안문 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	@Override
	public List<EatrztVO> nDocBoxList(String empNo) {
		return this.eatrztMapper.nDocBoxList(empNo);
	}

	/**
	 * 결재 서명 이미지 가져오는 서비스
	 * @param eatrztVO
	 * @return
	 */
	@Override
	public List<AtrzlnVO> stampAtrList(EatrztVO eatrztVO) {
		return this.eatrztMapper.stampAtrList(eatrztVO);
	}
	
	/**
	 * 결재 서명 이미지 가져오는 서비스2
	 * @param eatrztVO
	 * @return
	 */
	@Override
	public List<AtrzlnVO> stampAtrList2(EatrztVO eatrztVO) {
		return this.eatrztMapper.stampAtrList2(eatrztVO);
	}

	/**
	 * 반려한 기안 목록을 가져오는 서비스
	 * @param empNo
	 * @return
	 */
	@Override
	public List<EatrztVO> nApvBoxList(String empNo) {
		return this.eatrztMapper.nApvBoxList(empNo);
	}
	
}
