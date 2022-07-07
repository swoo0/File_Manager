package kr.co.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.co.file.dto.SubwayVO;

public class MapDAO {
	
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public MapDAO(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
	
	public List<SubwayVO> selectSubwayList() {
		
		List<SubwayVO> subwayList = null;
        SqlSession session = sqlSessionFactory.openSession();
        
        try {
        	subwayList = session.selectList("Subway-Mapper.selectSubwayList");
		} finally {
			session.close();
		}
		
		return subwayList;
	}


}
