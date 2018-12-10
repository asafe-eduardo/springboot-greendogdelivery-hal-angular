package com.boaglio.casadocodigo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/ambiente")
	public String ambiente() {
		return "ambiente";
	}
	
	@GetMapping("/delivery")
	public String delivery() {
		return "delivery/index";
	}
	
}
