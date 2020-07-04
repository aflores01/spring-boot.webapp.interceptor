package com.learning.springboot.interceptor.horario.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;

	@Value("${config.horario.cierre}")
	private Integer cierre;

	@GetMapping({"/","/index"})
	private String index(Model model) {
		model.addAttribute("titulo","Web APP Hour Interceptor");
		model.addAttribute("subtitulo","WebApp con control de acceso por horario");
		
		return "index";
	}
	
	@GetMapping("/cerrado")
	private String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado por favor visitenos desde las: ");
		mensaje.append(apertura);
		mensaje.append("hrs. ");
		mensaje.append("Y hasta las: ");
		mensaje.append(cierre);
		mensaje.append("hrs.");
		mensaje.append("Gracias por su visita.");
		model.addAttribute("titulo","Fuera de hroario de atención");
		model.addAttribute("mensaje", mensaje.toString());
		return "cerrado";
	}
}
