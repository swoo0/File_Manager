package kr.co.file.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubwayVO {

	public String voCode;
	public String gid;		    // 고유번호
	public String code;			// 역구분코드
	public String line;		    // 호선명
	public String nm;       	// 지하철역명
	public String latitude;     // 지번
	public String longitude;    // 도로명주소
	public String geom;     	// 지오메트리
	
	public String x;
	public String y;
	
	
}
