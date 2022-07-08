package kr.co.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.file.dto.SubwayVO;

public class MapDAOImpl {

	private static MapDAOImpl mapDAO;
	
	private MapDAOImpl() {}
	
	public static MapDAOImpl getInstance() {
		if (mapDAO == null) {
			mapDAO = new MapDAOImpl();
		}
		return mapDAO;
	}
	
	public List<SubwayVO> selectSubwayList(SqlSession session) {

		List<SubwayVO> subwayList = null;
        
        try {
        	subwayList = session.selectList("Subway-Mapper.selectSubwayList");
		} finally {
			session.close();
		}
		
		return subwayList;
	}


}
