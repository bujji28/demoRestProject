// Java Program to Illustrate DemoController

package com.ibm.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Annotation
@Controller

// Class
public class DemoController {

	@RequestMapping("/hello")
	@ResponseBody

	// Method
	public String helloWorld()
	{

		// Print statement
		return "Hello World!";
	}
}

