package kr.co.file.service;

import java.util.List;

import kr.co.file.dao.MapDAO;
import kr.co.file.dto.SubwayVO;
import kr.co.file.util.MybatisConnectionFactory;

public class MapService {
	
	MapDAO mapDAO = new MapDAO(MybatisConnectionFactory.getSqlSessionFactory());
	
	private static MapService mapService;
	
	// 생성자 선언
	private MapService() {
	}
	
	public static MapService getInstance() {
		if (mapService == null) {
			mapService = new MapService();
		}
		return mapService;
	}
	
	public void getSubwayList() throws Exception {
		List<SubwayVO> subwayList = null;
		subwayList = mapDAO.selectSubwayList();
		
		for(SubwayVO subwayInfo: subwayList){
			System.out.println(subwayInfo.line + " / " + subwayInfo.nm + "역");
		}
		
	}


}
