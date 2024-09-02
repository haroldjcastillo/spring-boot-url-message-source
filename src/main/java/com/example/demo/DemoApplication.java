package com.example.demo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public static MessageSource messageSource() throws IOException {
		return new UrlBasedMessageSource("https://pastebin.com/raw/47DgMshH");
	}

	@RestController
	@RequestMapping("/test")
	public class TestController {

		@Autowired
		private MessageSource messageSource;

		@GetMapping(value = "/{key}")
		public String readVariable(@PathVariable String key) {
			return messageSource.getMessage(key, null, "Unknown", null);
		}

	}

}
