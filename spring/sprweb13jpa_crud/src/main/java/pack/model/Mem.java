package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 파라미터 x 생성자
@AllArgsConstructor // 파라미터 o 생성자
@Entity
// @Table(name = "mem")
public class Mem {
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // 자동증가
	@Column(name = "num")
	private int num;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	private String addr;
}
