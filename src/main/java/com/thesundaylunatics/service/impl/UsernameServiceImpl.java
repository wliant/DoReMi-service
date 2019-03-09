package com.thesundaylunatics.service.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.thesundaylunatics.service.UsernameService;

@Service(value = "usernameService")
public class UsernameServiceImpl implements UsernameService{

	@Override
	public String getUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
		  return ((UserDetails)principal).getUsername();
		} else {
		  return principal.toString();
		}
	}

}
