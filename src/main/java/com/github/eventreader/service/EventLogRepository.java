package com.github.eventreader.service;

import org.springframework.stereotype.Repository;
import com.github.eventreader.model.EventData;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EventLogRepository extends CrudRepository<EventData, String>{

}
