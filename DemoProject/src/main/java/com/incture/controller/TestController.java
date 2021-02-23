package com.incture.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/test")
	public ResponseEntity<?> test() {

		return new ResponseEntity<String>("Current time is" + new Date().toString(), HttpStatus.OK);
	}

}
