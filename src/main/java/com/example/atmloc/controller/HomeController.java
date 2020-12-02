package com.example.atmloc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.atmloc.service.AtmLocService;
import com.example.security.SecurityUtils;

/**
 * @author Deepak Katariya
 * @apiNote Dispatcher for home.html
 */
@Controller
public class HomeController {

	@Autowired
	private AtmLocService atmLocService;

	@RequestMapping(value = { "/home", "/" })
	public String homePage(@PageableDefault(size = 10) Pageable pageable, Model model,
			@RequestParam(required = false, defaultValue = "") String city) throws Exception {
		model.addAttribute("page", atmLocService.getAllAtmLocsByCity(pageable, city));
		model.addAttribute("user", SecurityUtils.getLoggedInUser());
		model.addAttribute("city", city);
		return "/home/home";
	}
}
