package com.github.eventreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.github.eventreader.model.EventLog;
import com.github.eventreader.service.EventLogService;
import com.github.eventreader.service.EventParseUtil;

@SpringBootApplication(scanBasePackages = { "com.github.eventreader" })
public class Application {
	public static void main(String[] args) throws ParseException {

		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		EventLogService eventLogService = applicationContext.getBean(EventLogService.class);

		JSONParser jsonParser = new JSONParser();
		Map<String, EventLog> eventMap = new HashMap<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\event\\log.txt"))) {

			String line = reader.readLine();
			while (line != null) {
				Object obj = jsonParser.parse(line);
				EventParseUtil.parseObject((JSONObject) obj, eventMap);
				line = reader.readLine();
			}
			reader.close();
			eventLogService.save(eventMap);

		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
