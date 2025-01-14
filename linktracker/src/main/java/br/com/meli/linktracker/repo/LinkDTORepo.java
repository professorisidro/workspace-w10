package br.com.meli.linktracker.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.meli.linktracker.dto.LinkDTO;

@Repository
public class LinkDTORepo {
	
	private List<LinkDTO> database;
	
	public LinkDTORepo() {
		this.database = new ArrayList<LinkDTO>();
	}
	
	public LinkDTO save(LinkDTO dto) {
		if (dto.getId() == null) {
			dto.setId(database.size()+1);
			database.add(dto);
		}
		else {
			database.set(dto.getId()-1, dto);
		}
		System.out.println("DEBUG - "+database.size()+" - "+database);
		return dto;
	}
	
	public LinkDTO findById(Integer id) {
		return database.stream().filter(l -> l.getId().equals(id) && l.isValid()).findFirst().orElse(null);
	}

}
