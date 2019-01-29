package kr.or.ddit.rangers.service;

import java.util.ArrayList;
import java.util.List;

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
	
}