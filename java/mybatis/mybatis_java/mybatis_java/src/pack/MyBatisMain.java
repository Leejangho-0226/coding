package pack;

import java.util.List;

public class MyBatisMain {

	public static void main(String[] args) {
		ProcessDao processDao = ProcessDao.getInstance();
		
		try {
			/*
			System.out.println("자료 추가 -------------");
			DataDto dataDto = new DataDto();
			dataDto.setCode("12"); // 자료 추가라서 이미 있는 번호를 넣으면 오류 남
			dataDto.setSang("피자빵");
			dataDto.setSu("40");
			dataDto.setDan("6000");
			processDao.insData(dataDto);
			*/
			
			/*
			System.out.println("자료 수정 -------------");
			DataDto dataDto = new DataDto();
			dataDto.setCode("10"); 
			dataDto.setSang("바나나우유");
			dataDto.setSu("30");
			dataDto.setDan("2000");
			processDao.upData(dataDto);
			*/
			
			/*
			System.out.println("자료 삭제 -------------");
			String co = "10";
			boolean b = processDao.delData(co);
			if(b) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			*/
			
			System.out.println("전체 자료 출력 -------------");
			List<DataDto> list = processDao.selectDatAll();
			for(DataDto s:list) {
				System.out.println(s.getCode() + " " + s.getSang() + " "  
								 + s.getSu() + " "  + s.getDan());
			}
			
			System.out.println("부분 자료 출력 -------------");
			String code = "1";
			DataDto dto = processDao.selectDataPart(code);
			System.out.println(dto.getCode() + " " + dto.getSang() + " "  
					 + dto.getSu() + " "  + dto.getDan());
			
			
		} catch (Exception e) {
			System.out.println("err : " + e);
		}

	}

}
