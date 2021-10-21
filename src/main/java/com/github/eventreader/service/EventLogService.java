package com.github.eventreader.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.eventreader.model.EventData;
import com.github.eventreader.model.EventLog;

@Service
public class EventLogService {

	@Autowired
	EventLogRepository eventLogRepository;

	List<EventData> eventList = new ArrayList<>();

	public List<EventData> save(Map<String, EventLog> eventMap) {
		setEventData(eventMap, eventList);
		eventList.forEach(e -> eventLogRepository.save(e));
		return eventList;
	}

	private List<EventData> setEventData(Map<String, EventLog> eventMap, List<EventData> eventList) {

		Collection<EventLog> eventLogs = eventMap.values();
		eventLogs.stream()
				.forEach(e -> {
					EventData event = new EventData();
					if (e.getEndtimestamp() - e.getBegintimestamp() >= 4) {
						event.setAlert(true);
					} else {
						event.setAlert(false);
					}
					event.setDuration(e.getEndtimestamp() - e.getBegintimestamp());
					event.setId(e.getId());
					event.setState(e.getState());
					event.setHost(e.getHost());
					event.setType(e.getType());
					eventList.add(event);

				});
		return eventList;
	}

}
