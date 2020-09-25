package com.cubewealth.service;

import com.cubewealth.dto.EventDto;
import com.cubewealth.model.Event;

public interface EventService {
	Event addEvent(EventDto Event);
	Iterable<Event> getAllEvents();
	Event getEventById(Long id);
	Event updateEvent(Long id, Event Event);
	String deleteEventById(Long id);
}
