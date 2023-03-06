package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value="/getText",produces="test/plain;charset=UTF-8")
	public String getText() {
		return "안녕하세요";
	}
	
	@GetMapping(value="/getSample")
	public SampleVO getSample() {
		
		return new SampleVO(123,"홍","길동");
	}

	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for (int i=0;i<10;i++) {
			SampleVO vo = new SampleVO(i,"퐁"+i,"길동"+i);
			list.add(vo);
		}
		
		return list;
	}
	
	//테스트 방법: check?num=3	params 은 특정 키 값이 존재하게 제한
	@GetMapping(value="/check",params= {"num","num1"})
	public ResponseEntity<SampleVO> check(int num){
		SampleVO vo = new SampleVO(1,"홍","길동");
		ResponseEntity<SampleVO> result = null;
		if(num>10) {
			result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(vo);
		}else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
		
	}
	//check2/num(필요한 문자)/4
	@GetMapping("/check/{type}/{num}")
	public String check2(@PathVariable("type") String type, @PathVariable("num") int aaa) {
		return type+""+aaa;
		
	}
	
	@GetMapping("/all/{num1}/{num2}")
	public String check33(@PathVariable("num1") int num1,@PathVariable("num2") int num2) {//이름이 같다면 괄호 생략 가능
		int sum=0;
		for (int i=num1;i<=num2;i++) {
			sum+= i;
		}
		return sum+"";
		
	}
	
	//클라이언트에서 서버로 sampleVO 형태의 json타입으로 데이터를 보낼때,,
	//{"mno":123,"firstName":"홍","lastName":"길동"}
	
	@PostMapping(value="/getSample")
	public SampleVO gogo(@RequestBody SampleVO vo) {
		log.info("수집된 값 "+vo);
		return vo;
	}
	
	
}
