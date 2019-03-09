package com.thesundaylunatics.service;

import java.util.List;

import com.thesundaylunatics.model.Notification;

public interface NotificationService {
	Notification save(Notification notification);
	List<Notification> list(Boolean isRead);
	void delete(Long id);
	Notification get(Long id);
	
}
