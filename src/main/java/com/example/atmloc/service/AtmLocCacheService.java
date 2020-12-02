package com.example.atmloc.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.example.atmloc.dto.AtmLocDto;

@Service
public class AtmLocCacheService {

	private Map<String, List<AtmLocDto>> atmCache = new ConcurrentHashMap<>();

	public Map<String, List<AtmLocDto>> getAtmCache() {
		return atmCache;
	}

	public void setAtmCache(Map<String, List<AtmLocDto>> atmCache) {
		this.atmCache = atmCache;
	}

}
