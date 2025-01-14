package br.com.meli.linktracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.dto.LinkMetricsDTO;
import br.com.meli.linktracker.dto.LinkURLDto;
import br.com.meli.linktracker.repo.LinkDTORepo;

@Service
public class LinkServiceImpl implements ILinkService {

	@Autowired
	private LinkDTORepo repo;

	@Override
	public LinkDTO add(LinkDTO linkDTO) {
		// TODO Auto-generated method stub
		linkDTO.setValid(true);
		return repo.save(linkDTO);
	}

	@Override
	public LinkURLDto redirect(Integer id) {
		// TODO Auto-generated method stub
		LinkDTO dto = repo.findById(id);
		if (dto != null) {
			dto.setCount(dto.getCount() + 1);
			repo.save(dto);
			return new LinkURLDto(dto.getUrl());
		}
		return null;
	}

	@Override
	public LinkMetricsDTO getAnalytics(Integer id) {
		// TODO Auto-generated method stub
		LinkDTO dto =  repo.findById(id);
		if (dto != null) {
			return new LinkMetricsDTO(dto.getUrl(), dto.getCount());
		}
		return null;
	}

	@Override
	public LinkDTO invalidate(Integer id) {
		// TODO Auto-generated method stub
		LinkDTO dto = repo.findById(id);
		if (dto != null) {
			dto.setValid(false);
			repo.save(dto);
		}
		return dto;
	}

}
