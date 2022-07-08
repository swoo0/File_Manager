package kr.co.file.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.file.dao.MapDAOImpl;
import kr.co.file.dto.SubwayVO;
import kr.co.file.util.MybatisSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapServiceImpl implements MapService {
	
	private static MapServiceImpl mapService;
	
	private MapServiceImpl() {}
	public static MapServiceImpl getInstance() {
		if (mapService == null) {
			mapService = new MapServiceImpl();
		}
		return mapService;
	}

	private MapDAOImpl mapDAO = MapDAOImpl.getInstance();
	
	private SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
	
	
	public void getSubwayList() {
		SqlSession session = sqlSessionFactory.openSession();
		List<SubwayVO> subwayList = null;
		subwayList = mapDAO.selectSubwayList(session);
		
		for(SubwayVO subwayInfo: subwayList){
			log.info(subwayInfo.line + " / " + subwayInfo.nm + "역");
		}
		
	}


}
