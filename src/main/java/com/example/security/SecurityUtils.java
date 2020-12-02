package com.example.security;

import org.springframework.security.core.context.SecurityContextHolder;

import com.example.atmloc.dto.AppUser;

public class SecurityUtils {

	public static AppUser getLoggedInUser() {
		AppUser appUser = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return appUser;
	}

}
