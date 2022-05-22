package com.devsuperior.bds04.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repository.CityRepository;

@Service
public class CityService {
	
	
	@Autowired
	private CityRepository cityRepository;

	public List<CityDTO> findAll() {
		List<City> list = cityRepository.findAll(Sort.by("name"));
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
		
	}

	public CityDTO insert( CityDTO dto) {
		City entity = new City();
		entity.setName(dto.getName());
		return new CityDTO(entity);
	}
	
	

}
