package com.example.atmloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.atmloc.dto.AtmLocDto;
import com.example.atmloc.service.AtmLocService;

@RestController
@RequestMapping("/api/locator")
public class AtmLocApiController {

	@Autowired
	private AtmLocService atmLocService;

	@GetMapping(value = "/atms", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<AtmLocDto> getAtmsLocByCity(@PageableDefault(size = 10) Pageable pageable,
			@RequestParam(required = false, defaultValue = "") String city) throws Exception {
		return atmLocService.getAllAtmLocsByCity(pageable, city);
	}

}
