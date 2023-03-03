package org.zerock.quiz;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.SampleController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping
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

}
