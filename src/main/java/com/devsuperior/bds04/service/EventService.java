package com.devsuperior.bds04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;

	public Page<EventDTO> findAll(Pageable pageable) {
		Page<Event> page = eventRepository.findAll(pageable);
		return page.map(x -> new EventDTO(x));
	}

	public  EventDTO insert(EventDTO dto) {
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setUrl(dto.getName());
		entity.setDate(dto.getDate());
		entity.setCity(new City(dto.getCityId(), null));
		entity = eventRepository.save(entity);
		return new EventDTO(entity);
	}

}
