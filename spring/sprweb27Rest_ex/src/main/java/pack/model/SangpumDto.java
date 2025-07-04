package pack.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SangpumDto {
	private int code;	
	private String sang;
	private String su;
	private String dan;
	
	public static SangpumDto toDto(Sangpum sangpum) {
		return SangpumDto.builder()
				.code(sangpum.getCode())
				.sang(sangpum.getSang())
				.su(sangpum.getSu())
				.dan(sangpum.getDan())
				.build();
	}
}
