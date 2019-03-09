package com.thesundaylunatics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thesundaylunatics.model.Notification;
import com.thesundaylunatics.service.NotificationService;

@RestController
@RequestMapping(value="/rest2/notifications")
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Notification> listNotifications() {
		return notificationService.list();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Notification getNotification(@PathVariable(value = "id") Long id) {
		return notificationService.get(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Notification saveNotification(@RequestBody Notification customer) {
		return notificationService.save(customer);
	}
}
