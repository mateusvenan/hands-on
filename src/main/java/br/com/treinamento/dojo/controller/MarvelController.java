package br.com.treinamento.dojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class MarvelController {

    @CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/series", method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld(@RequestParam(value="startYear", required=false) String startYear) {
    	Gson gson = new Gson();
		return new ResponseEntity<String>(gson.toJson("hello world" + startYear), HttpStatus.OK);
	}
}
