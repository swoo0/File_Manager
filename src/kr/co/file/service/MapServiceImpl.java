package kr.co.file.service;

import java.util.ArrayList;
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

	// 필드 선언
	private static MapService mapService;

	private SqlSessionFactory ssf;
	private MapDAO mapDAO;

	// 생성자
	private MapServiceImpl() {
		ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
		mapDAO = MapDAOImpl.getInstance();
	}

	// 메소드
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

		for (SubwayVO subwayInfo : subwayList) {
			log.info(subwayInfo.line.substring(1) + " / " + subwayInfo.nm + "역");
		}

	}

	public void getPakageList() {
		
		String basePackage = "kr.co.file.controller";
		
		List<String> classList = new ArrayList<String>();
		Package targetPackage = Package.getPackage(basePackage);
		
		if (targetPackage == null) {
			System.err.printf("Inseted Package Path(%s) is invalid!!", basePackage);
		} else {
			System.out.println(targetPackage);
		}
		
		
	}

}
