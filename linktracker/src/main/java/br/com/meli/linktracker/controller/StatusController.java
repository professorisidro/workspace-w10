package br.com.meli.linktracker.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.meli.linktracker.dto.StatusDTO;
import br.com.meli.linktracker.dto.StatusEntity;

@RestController
public class StatusController {
	
	@PostMapping("/status")
	public StatusEntity receiveData(@RequestBody StatusDTO dto) throws Exception{
		StatusEntity entity = new StatusEntity();
		entity.setId(dto.id());
		entity.setData(LocalDate.parse(dto.data()));
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		System.out.println(mapper.writeValueAsString(entity));
		
		return entity;
	}

}
