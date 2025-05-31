package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemCrudRepositrory repositrory; // 자동으로 pooling 처리됨, HikariPool
	
	// 전체자료 읽기
    public List<Mem> getDataAll() {
        List<Mem> list = repositrory.findAll();
        logger.info("list size : " +  list.size());
        
        return list;
    }
    
    // 추가
    public String insert(MemBean bean) {
    	// 번호 자동 증가 프로그래밍인 경우
    	// int ma = repositrory.findByMaxNum();
    	
    	// 여기서는 사용자가 입력한 num 중복 확인으로 프로그래밍하자
    	try {
    		// findById() : select * from mem where num=num값
			Mem mem = repositrory.findById(bean.getNum()).get(); // 내장 메소드 사용,Java Optional , select 문으로 처리됨
			System.out.println("mem : " + mem);
			return "이미 등록된 번호입니다";
		} catch (Exception e) {
			try {
				// 사용자가 입력한 새 회원번호가 DB에 없는 경우
				Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
				mem = repositrory.save(mem);  // 내장 메소드 사용, insert 문으로 처리됨 
				return "success";
			} catch (Exception e2) {
				return "입력 자료 오류:" + e2.getMessage();
			}
		}
    }
    
    // 수정, 삭제 자료 읽기 
    public Mem getData(String num) {
        int numInt = Integer.parseInt(num); // 문자열 → 정수 변환
        Mem mem = repositrory.findByNum(numInt); // 변환된 정수로 검색
        return mem;
    }
    
    // 수정
    public String update(MemBean bean) {
    	try {
    		Mem mem = new Mem(bean.getNum(), bean.getName(), bean.getAddr());
			mem = repositrory.save(mem);  // 내장 메소드 사용, 동일한 num인 경우 update 문으로 처리됨 
			// save(mem); : save가 insert, update 둘 다 처리
    		return "success";
		} catch (Exception e) {
			return "수정 자료 오류:" + e.getMessage();
		}
    }
    
    // 삭제
    public String delete(int num) {
    	try {
    		repositrory.deleteById(num);;  // delete 문으로 처리함
    		return "success";
		} catch (Exception e) {
			return "수정 자료 오류:" + e.getMessage();
		}
    }
    
    
}

