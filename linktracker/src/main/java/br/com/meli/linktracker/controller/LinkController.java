package br.com.meli.linktracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.dto.LinkMetricsDTO;
import br.com.meli.linktracker.dto.LinkURLDto;
import br.com.meli.linktracker.service.ILinkService;

@RestController
public class LinkController {
	
	@Autowired
	private ILinkService service;
	
	@PostMapping("/link")
	public ResponseEntity<LinkDTO> create(@RequestBody LinkDTO dto){
		return ResponseEntity.status(201).body(service.add(dto));
	}
	
	@GetMapping("/link/{linkId}")
	public ResponseEntity<LinkURLDto> redirect(@PathVariable Integer linkId){
		LinkURLDto dto = service.redirect(linkId);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/metrics/{linkId}")
	public ResponseEntity<LinkMetricsDTO> getMetrics(@PathVariable Integer linkId){
		LinkMetricsDTO dto = service.getAnalytics(linkId);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping("/invalidate/{linkId}")
	public ResponseEntity<LinkDTO> invalidateLin(@PathVariable Integer linkId){
		LinkDTO dto = service.invalidate(linkId);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		}
		return ResponseEntity.notFound().build();
	}

}
