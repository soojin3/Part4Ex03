package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

	@GetMapping("/view/all")
	public void all() {

	}

	@GetMapping("/view/quiz1")
	public void quiz1() {
	}

}
