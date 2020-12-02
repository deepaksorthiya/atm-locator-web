package com.example.atmloc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.atmloc.dto.AtmLocDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AtmLocRestClientService {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AtmLocCacheService atmLocCacheService;

	public static final String ATM_LOC_KEY = "ATM_LOC_CACHE_KEY";

	public List<AtmLocDto> getAllAtmLocs() throws Exception {
		if (atmLocCacheService.getAtmCache().size() != 0) {
			return atmLocCacheService.getAtmCache().get(ATM_LOC_KEY);
		}
		ResponseEntity<String> result = restTemplateBuilder.build().getForEntity("https://www.ing.nl/api/locator/atms/",
				String.class);
		String data = result.getBody().substring(result.getBody().indexOf('['));
		AtmLocDto[] atms = objectMapper.readValue(data, AtmLocDto[].class);
		List<AtmLocDto> newAtms = Arrays.asList(atms);
		atmLocCacheService.getAtmCache().put(ATM_LOC_KEY, newAtms);
		return newAtms;

	}

}
