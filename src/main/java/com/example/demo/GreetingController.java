package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String codigo = ",a18103739";
    

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/idat")
	public Greeting greeting(@RequestParam(value="name",defaultValue = "name" )String name) {
		return new Greeting(counter.incrementAndGet(), String.format(name,codigo));
	}
  	@GetMapping("/idat/codigo")
	public Greeting greeting1(@RequestParam(value="codigo",defaultValue = "codigo" )String codigo) {
		return new Greeting(counter.incrementAndGet(), String.format(codigo));
	}
    	@GetMapping("/idat/nombreCom")
	public Greeting greeting2(@RequestParam(value="nomcom",defaultValue = "nomcom" )String noncom) {
		return new Greeting(counter.incrementAndGet(), String.format(noncom));
	}
}