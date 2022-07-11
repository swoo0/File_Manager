package kr.co.file.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.file.dao.MapDAO;
import kr.co.file.dao.MapDAOImpl;
import kr.co.file.dto.SubwayVO;
import kr.co.file.util.MybatisSqlSessionFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapServiceImpl implements MapService {
	
	private static MapService mapService;
	private SqlSessionFactory ssf;
	private MapDAO mapDAO;
	
	private MapServiceImpl() {
		ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		mapDAO = MapDAOImpl.getInstance();
	}
	
	public static MapService getInstance() {
		if (mapService == null) {
			mapService = new MapServiceImpl();
		}
		return mapService;
	}
	
	
	public void getSubwayList() {
		SqlSession session = ssf.openSession();
		List<SubwayVO> subwayList = null;
		subwayList = mapDAO.selectSubwayList(session);
		
		for(SubwayVO subwayInfo: subwayList){
			log.info(subwayInfo.line + " / " + subwayInfo.nm + "역");
		}
		
	}


}
