package kr.co.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.file.dto.SubwayVO;
import kr.co.file.util.MybatisSqlSessionFactory;

public class MapDAOImpl implements MapDAO {

	private static MapDAO mapDAO;
	private SqlSessionFactory ssn;
	
	private MapDAOImpl() {
		ssn = MybatisSqlSessionFactory.getSqlSessionFactory();
	}
	
	public static MapDAO getInstance() {	
		if (mapDAO == null) {
			mapDAO = new MapDAOImpl();
		}
		return mapDAO;
	}
	
	public List<SubwayVO> selectSubwayList() {
		SqlSession session = ssn.openSession();
		List<SubwayVO> subwayList = null;
        try {
        	subwayList = session.selectList("Subway-Mapper.selectSubwayList");
		} finally {
			session.close();
		}
		
		return subwayList;
	}


}
