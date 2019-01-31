package kr.or.ddit.rangers.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.rangers.model.RangerVO;

public class RangersService {

	public List<String> getAll() {
		//db연동이 필요한 부분 --> 추후
		List<String> rangersList = new ArrayList<String>();
		rangersList.add("brown");
		rangersList.add("cony");
		rangersList.add("sally");
		rangersList.add("james");
		rangersList.add("moon");
		
		return rangersList;
	}
	
	public List<RangerVO> getAllRangerVO(){
		List<RangerVO> rangersList = new ArrayList<RangerVO>();
		rangersList.add(new RangerVO("brown", "브라운", 8));
		rangersList.add(new RangerVO("cony", "코니", 9));
		rangersList.add(new RangerVO("sally", "샐리", 10));
		rangersList.add(new RangerVO("james", "제임스", 11));
		rangersList.add(new RangerVO("moon", "문", 12));
		
		return rangersList;
	}
	
}