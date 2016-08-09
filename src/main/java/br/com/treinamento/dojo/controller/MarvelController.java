package br.com.treinamento.dojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MarvelController {

	@RequestMapping(value = "/series", method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld() {

		return new ResponseEntity<String>("hello world", HttpStatus.OK);
	}
}
