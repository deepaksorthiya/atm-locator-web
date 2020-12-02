package com.example.atmloc.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.atmloc.dto.AtmLocDto;

public interface AtmLocService {

	Page<AtmLocDto> getAllAtmLocsByCity(Pageable pageable, String city) throws Exception;

}