package br.com.dfdx.springbootmaven;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController       // API Rest
@RequestMapping("/")  // Maoeamento da da Rota
public class HelloWorld {
	
	@GetMapping // Verbo HTTP GET será atendido por esse método
	public String sayHello() {
		return "Hello from SpringBoot";
	}
	
	@GetMapping("/subpath") 
	@ResponseBody
	@ResponseStatus( code = HttpStatus.NO_CONTENT)  // Customizar o resultado da requisição
	public String subPath(@RequestParam(value = "name", required = false) String name) {
		return "Este é um subpath do endpoint /" + name;
	}

	
	@GetMapping("/{dynamic}") 
	public String dynamicSubPath(@PathVariable("dynamic") String name) {
		return "Olá [" + name + "], esta é a minha rota dinâmica";
	}
	
	
	@PostMapping("/post")
	public String sayHelloPost(@RequestBody Map<String, Object> payload) {
		return payload.get("name").toString();
	}
}
