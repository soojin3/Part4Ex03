package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor//기본생성자 만들기
public class SampleVO {
	private Integer mno;
	private String firstName;
	private String LastName;

}
