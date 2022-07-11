package kr.co.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.file.dto.SubwayVO;

public interface MapDAO {

	public List<SubwayVO> selectSubwayList();
	
}
