package com.thesundaylunatics.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thesundaylunatics.model.Notification;

@Repository
public interface NotificationDao extends CrudRepository<Notification, Long> {

}
