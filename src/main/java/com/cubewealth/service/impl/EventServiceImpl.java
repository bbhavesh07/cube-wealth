package com.cubewealth.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubewealth.dto.EventDto;
import com.cubewealth.exceptions.EventNotFoundException;
import com.cubewealth.model.Event;
import com.cubewealth.repository.EventRepository;
import com.cubewealth.service.EventService;
import com.cubewealth.service.RabbitMQSender;

@Service
public class EventServiceImpl implements EventService{
	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private RabbitMQSender rabbitMQSender;
	
	@Override
	public Event addEvent(EventDto eventDto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Event event = mapper.map(eventDto, Event.class);
		event = eventRepo.save(event);
		if(eventDto.isBillPay())
			rabbitMQSender.send(eventDto);
		return event;
	}
	
	@Override
	public Iterable<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public Event getEventById(Long id) {
		return eventRepo.findById(id).orElseThrow(EventNotFoundException::new);
	}

	//TODO: correct update event 
	@Override
	public Event updateEvent(Long id, Event event) {
		Event eventToUpdate = eventRepo.findById(id).orElseThrow(EventNotFoundException::new);
		eventToUpdate.setLatitude(event.getLatitude());
		eventToUpdate.setLongitude(event.getLongitude());
		return eventRepo.save(eventToUpdate);
	}

	@Override
	public String deleteEventById(Long id) {
		eventRepo.delete(eventRepo.findById(id).orElseThrow(EventNotFoundException::new));
		return "{meassage: Event deleted successfully!}";
	}

}
