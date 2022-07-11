package kr.co.file.service;

import java.util.List;

import kr.co.file.dao.MapDAO;
import kr.co.file.dao.MapDAOImpl;
import kr.co.file.dto.SubwayVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapServiceImpl implements MapService {
	
	private static MapService mapService;
	private MapDAO mapDAO;
	
	private MapServiceImpl() {
		mapDAO = MapDAOImpl.getInstance();
	}
	
	public static MapService getInstance() {
		if (mapService == null) {
			mapService = new MapServiceImpl();
		}
		return mapService;
	}
	
//	private SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	
	public void getSubwayList() {
//		SqlSession session = sqlSessionFactory.openSession();
		List<SubwayVO> subwayList = null;
		subwayList = mapDAO.selectSubwayList();
		
		for(SubwayVO subwayInfo: subwayList){
			log.info(subwayInfo.line + " / " + subwayInfo.nm + "역");
		}
		
	}


}
