package kr.or.oho.hdorder.service;

import java.util.List;
import java.util.Map;

import kr.or.oho.vo.CnptVO;
import kr.or.oho.vo.ComcdVO;
import kr.or.oho.vo.FranchiseVO;
import kr.or.oho.vo.FrcOrderDtlVO;
import kr.or.oho.vo.FrcOrderVO;
import kr.or.oho.vo.GdsVO;
import kr.or.oho.vo.HdorderDtlVO;
import kr.or.oho.vo.HdorderVO;

public interface HdorderService {

	/**
	 * 거래처 정보 가져오는 서비스
	 * @return
	 */
	public List<CnptVO> getCntpInfo();

	/**
	 * 거래처별 품목목록 가져오는 서비스
	 * @param cnptVO
	 * @return
	 */
	public List<GdsVO> getCnptGds(CnptVO cnptVO);

	/**
	 * 거래처별 거래내역 목록 가져오는 서비스
	 * @param hdorderDtlVO
	 * @return
	 */
	public List<HdorderVO> getOrderDt(HdorderDtlVO hdorderDtlVO);

	/**
	 * 발주 등록하는 서비스
	 * @param hdorderVO
	 * @return
	 */
	public int createPost(HdorderVO hdorderVO);

	/**
	 * 모든 거래내역 가져오는 서비스
	 * @param hdorderVO
	 * @return
	 */
	public List<HdorderVO> getAllHdorder(HdorderVO hdorderVO);
	
	/**
	 * 거래내역 가져오는 서비스
	 * @return
	 */
	public List<HdorderVO> getAllHdorder();

	/**
	 * 거래처별 거래내역 목록 가져오는 서비스2
	 * @param hdorderDtlVO
	 * @return
	 */
	public List<HdorderDtlVO> getOrderDt2(HdorderVO hdorderVO);

	/**
	 * 발주삭제하는 서비스
	 * @param hdorderVO
	 * @return
	 */
	public int deleteHdorder(HdorderVO hdorderVO);

	
	/**
	 * 발주일자 수정하는 서비스
	 * @param frcOrderVO
	 * @return
	 */
	public int updateYn(FrcOrderVO frcOrderVO);

	/**
	 * 발주내역 상세조회하는 서비스
	 * @param frcOrderVO
	 * @return
	 */
	public List<FrcOrderDtlVO> getOrderDetail(FrcOrderVO frcOrderVO);

	/**
	 * 입고 창고 가져오는 서비스
	 * @return
	 */
	public List<ComcdVO> getAllWrhs();

	/**
	 * 모든 상품 가져오는 서비스
	 * @return
	 */
	public List<GdsVO> getAllStock();

	/**
	 * 상품 임시 저장하는 서비스
	 * @param gdsList
	 * @return
	 */
	public int updateSave(List<Map<String, Object>> gdsList);

	/**
	 * 모든 재고수 가져오는 서비스
	 * @param comcdVO
	 * @return
	 */
	public List<GdsVO> getAllStock(ComcdVO comcdVO);

	/**
	 * 신청한 상품 가져오는 서비스
	 * @param gdsVO
	 * @return
	 */
	public List<GdsVO> getWrhsGds(GdsVO gdsVO);

	/**
	 * 거래처 정보 가져오는 서비스
	 * @param frcOrderVO
	 * @return
	 */
	public List<FrcOrderVO> getAllFrcorder(FrcOrderVO frcOrderVO);

	/**
	 * 거래 상세 내역 가져오는 서비스
	 * @param frcOrderVO
	 * @return
	 */
	public List<FrcOrderDtlVO> getfrcOrderDtl(FrcOrderVO frcOrderVO);

	/**
	 * 가맹점 위치 가져오는 서비스
	 * @param comcdVO
	 * @return
	 */
	public List<FranchiseVO> locFrn(ComcdVO comcdVO);



}
