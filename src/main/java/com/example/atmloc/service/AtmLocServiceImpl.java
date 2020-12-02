package com.example.atmloc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.atmloc.dto.AtmLocDto;

@Service
public class AtmLocServiceImpl implements AtmLocService {

	@Autowired
	AtmLocRestClientService client;

	@Override
	public Page<AtmLocDto> getAllAtmLocsByCity(Pageable pageable, String city) throws Exception {
		Page<AtmLocDto> page = null;
		List<AtmLocDto> allAtmLocs = client.getAllAtmLocs();
		if (!StringUtils.isEmpty(city)) {
			List<AtmLocDto> newAtms = allAtmLocs.stream().filter(t -> t.getAddress().getCity().equals(city))
					.collect(Collectors.toList());
			int size = newAtms.size();
			List<AtmLocDto> filterAtms = newAtms.stream()
					.skip((long) (pageable.getPageNumber() * pageable.getPageSize()))
					.limit((long) (pageable.getPageSize())).collect(Collectors.toList());
			page = PageableExecutionUtils.getPage(filterAtms, pageable, () -> size);
		} else {
			List<AtmLocDto> newAtms = allAtmLocs.stream()
					.skip((long) (pageable.getPageNumber() * pageable.getPageSize()))
					.limit((long) (pageable.getPageSize())).collect(Collectors.toList());
			page = PageableExecutionUtils.getPage(newAtms, pageable, () -> allAtmLocs.size());
		}
		return page;
	}

}
