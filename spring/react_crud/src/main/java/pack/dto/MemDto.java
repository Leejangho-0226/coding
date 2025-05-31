package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("memDto")  // 별명이 걸림
public class MemDto {
	private int num;
	private String name;
	private String addr;
}
