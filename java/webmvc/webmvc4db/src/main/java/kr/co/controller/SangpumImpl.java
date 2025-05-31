package kr.co.controller;

import java.util.ArrayList;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.model.DataDto;
import kr.co.model.SangpumProcess;

public class SangpumImpl implements CommandInter{
	@Override
	public String showData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 모델 수행 후 결과와 뷰파일명 반환
		SangpumProcess sangpumProcess = new SangpumProcess(); // 원래는 싱글톤 처리
		ArrayList<DataDto> list = (ArrayList<DataDto>)sangpumProcess.selectSangpumAll(); // 캐스팅
		request.setAttribute("datas", list);
		
		return "sanglist.jsp";
	}

}
