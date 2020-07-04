package com.learning.springboot.interceptor.horario.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping({"/","/index"})
	private String index(Model model) {
		model.addAttribute("titulo","Web APP Hour Interceptor");
		model.addAttribute("subtitulo","WebApp con control de acceso por horario");
		return "index";
	}
}
