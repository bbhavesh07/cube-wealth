package com.cubewealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubewealth.dto.EventDto;
import com.cubewealth.model.Event;
import com.cubewealth.service.EventService;

@RestController
@RequestMapping("/event")
public class EventsController {

	@Autowired
	private EventService eventService;
	
	@GetMapping
	public Iterable<Event> getAllEvents(){
		return eventService.getAllEvents();
	}
	
	@PostMapping
    public ResponseEntity<?> addEvent(@RequestBody EventDto event) {

        return ResponseEntity.ok(eventService.addEvent(event));
    }
}
