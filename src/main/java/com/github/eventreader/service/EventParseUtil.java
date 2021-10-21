package com.github.eventreader.service;

import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import com.github.eventreader.model.EventLog;

@Component
public class EventParseUtil {

	public static void parseObject(JSONObject eventLog, Map<String, EventLog> eventMap) {

		String id = (String) eventLog.get("id");
		if (eventMap.containsKey(id)) {
			EventLog existingEvent = eventMap.get(id);
			if (existingEvent.getState() == "started") {
				existingEvent.setEndtimestamp(Integer.parseInt((String) eventLog.get("endtimestamp")));
			} else {
				existingEvent.setBegintimestamp(Integer.parseInt((String) eventLog.get("begtimestamp")));
			}

		} else {
			EventLog eventObj = new EventLog();
			eventObj.setId(id);
			String state = (String) eventLog.get("state");
			eventObj.setState(state);
			String type = (String) eventLog.get("type");
			eventObj.setType(type);
			String host = (String) eventLog.get("host");
			eventObj.setHost(host);
			int begTime = (String) eventLog.get("begtimestamp") == null ? 0 : Integer.parseInt((String) eventLog.get("begtimestamp"));
			eventObj.setBegintimestamp(begTime);
			int endTime = (String) eventLog.get("endtimestamp") == null ? 0 : Integer.parseInt((String) eventLog.get("endtimestamp"));
			eventObj.setEndtimestamp(endTime);

			eventMap.put(id, eventObj);
		}

	}
}
