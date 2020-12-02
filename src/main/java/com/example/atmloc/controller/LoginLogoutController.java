package com.example.atmloc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Deepak Katariya
 * @apiNote Dispatcher for login.html
 */
@Controller
public class LoginLogoutController {

	@RequestMapping("/login")
	public String loginPage() {
		return "/login/login";
	}

	@RequestMapping("/logout")
	public String logoutPage() {
		return "/logout/logout";
	}
}
