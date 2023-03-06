package org.zerock.quiz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.JsonVO;

import lombok.extern.log4j.Log4j;
@Log4j
@RestController
public class TestController {

	@GetMapping(value = "/cal/{type}/{num2}/{num1}", produces = "test/plain;charset=UTF-8")
	public String cal(@PathVariable("type") String type, @PathVariable("num2") int num2,
			@PathVariable("num1") int num1) {
		int sum = 0;
		if (type.equals("add")) {
			sum = num2 + num1;

		} else if (type.equals("sub")) {
			sum = num2 - num1;
		}

		return type.equals("add") ? num2 + num1 + "" : num2 - num1 + "";
		// return sum+""; 위와 같음

	}
	
	@GetMapping(value="quiz/quiz1")
	public String getText() {
		return "hi~";
	}
	
	@GetMapping(value="quiz/quiz2/{num}",produces="test/plain;")
	public int getText2( @PathVariable("num") int num) {
		return num;
	}
	
	//@GetMapping(value="quiz/quiz2/{num}",produces="test/plain")
	//public String getText3( @PathVariable("num") String num) {
	//	return num;
	//}
	
	@PostMapping(value="quiz/quiz3")
	public JsonVO gogo(@RequestBody JsonVO vo) {
		vo.setBno(10);
		log.info("수집된 값 "+vo);
		//return new JsonVO(10,"테스트"관리자",");
		//10은 고정값, test는 우리가 적는 부분
		return vo;
	}
	
}
