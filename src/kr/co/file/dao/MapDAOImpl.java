package kr.co.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.file.dto.SubwayVO;

public class MapDAOImpl implements MapDAO {

	private static MapDAO mapDAO;
//	private SqlSessionFactory ssf;
	
	private MapDAOImpl() {
//		ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	public static MapDAO getInstance() {	
		if (mapDAO == null) {
			mapDAO = new MapDAOImpl();
		}
		return mapDAO;
	}
	
	public List<SubwayVO> selectSubwayList(SqlSession session) {
//		SqlSession session = ssf.openSession();
		List<SubwayVO> subwayList = null;
        try {
        	subwayList = session.selectList("Subway-Mapper.selectSubwayList");
		} finally {
			session.close();
		}
		
		return subwayList;
	}


}
