package pack.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Gogek {
	@Id
	private int gogekno;
	
	private String gogekname;
	private String gogektel;
	
	@ManyToOne
	@JoinColumn(name="gogekdamsano", insertable = false, updatable = false)
	private Jikwon jikwon;
	// insertable = false, updatable = false : 참조용으로만 사용
}
