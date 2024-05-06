package com.springboot.devtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		int a = 10;
		int b = 5;
		int c = 5;
		return "this is for testing and sum of a and b is "+(a+b+c);
	}

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "This is home page and i am running it from vs code";
	}
}
