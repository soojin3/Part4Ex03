package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping(value="/getText",produces="test/plain;charset=UTF-8")
	public String getText() {
		return " ㅇㅇㅇㅇ";
	}

}
