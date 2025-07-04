package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {  // 클라이언트 <-> DB 처리용 클래스 <-> JPA <-> JDBC <-> RDBMS
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SangpumRepository repository;
	
	// 전체 자료 읽기
	public List<SangpumDto> getDataAll(){
		List<SangpumDto> list = repository.findAll();  // 코드 중요 // 내장된 기본 메소드
		logger.info("행의 갯수 : " + list.size() + "개");
		return list;
	}
	
	// 검색 처리
	public List<SangpumDto> getDataSearch(String svalue){
		// 쿼리용 메소드 작성 규칙에 따른 추상 메소드 호출
//      List<SangpumDto> list = repository.findBySangContaining(svalue);
//		List<SangpumDto> list = repository.findBySangStartingWith(svalue);
//      List<SangpumDto> list = repository.findBySangEndingWith(svalue);
		
		// JPQL 사용 메소드 호출
		List<SangpumDto> list = repository.searchMyMethod(svalue);
		
        logger.info("검색 결과 행의 갯수" + list.size() + "개");
        list.forEach(SangpumDto -> System.out.println(SangpumDto.getCode() + " " +
        											  SangpumDto.getSang()));
        return list;
    }

}
