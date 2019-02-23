package com.thesundaylunatics.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thesundaylunatics.model.Campaign;

@Repository
public interface CampaignDao extends CrudRepository<Campaign, Long> {

}
