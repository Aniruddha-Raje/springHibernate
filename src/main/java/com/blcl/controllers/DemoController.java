package com.blcl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blcl.dtos.Form;
import com.blcl.dtos.GreetingsForm;
import com.blcl.dtos.PersonsDto;
import com.blcl.services.IService;

@RequestMapping("/api")
@RestController
public class DemoController {

	@Autowired
	private IService service;

	@RequestMapping(value = "/greeting", method = RequestMethod.GET)
	public ResponseEntity<GreetingsForm> getGreeting(@RequestParam(value = "name", required = true) String name)
			throws Exception {

		GreetingsForm form = new GreetingsForm();
		form.setResponseCode(String.valueOf(HttpStatus.OK.value()));
		form.setResponseMessage("Hello "+name);
		return new ResponseEntity<GreetingsForm>(form, HttpStatus.OK);

	}
	
	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public ResponseEntity<Form> getData(@RequestParam(value = "name", required = true) String name)
			throws Exception {

		Form form = new Form();
		List<PersonsDto> personsDtos = null;
		
		if(name != null){
			form.setResponseCode(String.valueOf(HttpStatus.OK.value()));
			form.setResponseMessage("Success");
			personsDtos = service.getData();
			form.setData(personsDtos);
			return new ResponseEntity<Form>(form, HttpStatus.OK);
		}
		else{
			form.setResponseCode(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			form.setResponseMessage("name is a mandatory parameter");
			form.setData(null);
			return new ResponseEntity<Form>(form, HttpStatus.BAD_REQUEST);
		}
	}

}
