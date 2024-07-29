package kr.or.oho.revenue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/revenue")
public class HqRevenueController {
	
	/**
	 * 연간 매출 가져오는 컨트롤러
	 * @return
	 */
	@GetMapping("/annual")
	public String annual() {
		log.debug("annual 왔음");
		
		return "revenue/annualRevenue";
	}
	
	/**
	 * 월별 매출 가져오는 컨트롤러
	 * @return
	 */
	@GetMapping("/monthly")
	public String monthly() {
		log.debug("monthly 왔음");

		
		return "revenue/monthlyRevenue";
	}
	
	/**
	 * 분기별 매출 가져오는 컨트롤러
	 * @return
	 */
	@GetMapping("/quarterly")
	public String quarterly() {
		log.debug("quarterly 왔음");
		
		return "revenue/quarterlyRevenue";
	}
	
}
