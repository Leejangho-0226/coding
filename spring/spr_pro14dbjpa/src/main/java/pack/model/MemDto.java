package pack.model;

// 🧩 DB 컬럼과 매핑할 때 필요한 어노테이션들 (JPA)
import javax.persistence.Column;      // DB 테이블의 '컬럼(열)'과 자바 변수 연결할 때 사용
import javax.persistence.Entity;      // 이 클래스가 DB 테이블과 연결된다는 표시
import javax.persistence.Id;          // DB에서 '기본키(PK)'로 사용하는 컬럼에 붙임
import javax.persistence.Table;       // 이 클래스가 연결될 'DB 테이블 이름'을 정함

import lombok.AllArgsConstructor;     
import lombok.Builder;                
import lombok.Getter;                 
import lombok.NoArgsConstructor;      
import lombok.Setter;                 


@Getter
@Setter
@Builder // 예: MemDto dto = MemDto.builder().num(1).name("홍길동").addr("서울").build();
@AllArgsConstructor // 📌 모든 필드를 받는 생성자 자동 생성 (예: new MemDto(1, "홍길동", "서울"))
@NoArgsConstructor // 📌 아무 값도 받지 않는 기본 생성자 자동 생성 (예: new MemDto())
@Entity // 📌 이 클래스는 DB 테이블과 연결된다는 뜻 (JPA에서 꼭 필요함!)
@Table(name = "mem") // 📌 이 클래스가 연결될 실제 DB 테이블 이름은 "mem"이라는 뜻
public class MemDto {

	// 📌 이 필드는 DB의 기본키(PK)로 사용됨
	// 📌 DB 테이블의 "num"이라는 컬럼과 연결
	@Id
	@Column(name = "num")
	private int num; // 회원 번호

	// 📌 DB 테이블의 "name" 컬럼과 연결됨
	// 📌 nullable = true → 값이 없어도 저장 가능
	@Column(name = "name", nullable = true)
	private String name; // 회원 이름

	// 📌 @Column 어노테이션 생략 가능 → 변수명이 곧 컬럼명이 됨
	// 📌 여기선 "addr"이라는 이름의 컬럼과 자동 연결
	private String addr; // 회원 주소
}
