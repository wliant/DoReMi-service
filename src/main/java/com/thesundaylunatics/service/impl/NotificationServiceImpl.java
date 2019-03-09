package com.thesundaylunatics.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.thesundaylunatics.dao.NotificationDao;
import com.thesundaylunatics.model.Notification;
import com.thesundaylunatics.service.NotificationService;

@Service(value = "customerService")
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	private NotificationDao notificationDao;
	@Override
	public Notification save(Notification notification) {
		notification.setId(null);
		return notificationDao.save(notification);
	}

	@Override
	public List<Notification> list(Boolean isRead) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		final String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		if(isRead != null) {
			return StreamSupport.stream(notificationDao.findAll().spliterator(), false)
					.filter(noti->noti.getRecipient().equals(username))
					.filter(noti->noti.getIsRead().equals(isRead))
					.collect(Collectors.toList());
		}
		else {
			return StreamSupport.stream(notificationDao.findAll().spliterator(), false)
					.filter(noti->noti.getRecipient().equals(username))
					.collect(Collectors.toList());
		}
	}

	@Override
	public void delete(Long id) {
		notificationDao.delete(id);
	}

	@Override
	public Notification get(Long id) {
		return notificationDao.findOne(id);
	}

}
