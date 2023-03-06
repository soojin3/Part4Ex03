package org.zerock.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor//기본생성자 만들기
public class JsonVO {
	private Integer bno;
	private String title;
	private String writer;
}
