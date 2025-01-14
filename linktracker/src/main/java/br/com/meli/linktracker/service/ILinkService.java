package br.com.meli.linktracker.service;

import br.com.meli.linktracker.dto.LinkDTO;
import br.com.meli.linktracker.dto.LinkMetricsDTO;
import br.com.meli.linktracker.dto.LinkURLDto;

public interface ILinkService {

	public LinkDTO add(LinkDTO linkDTO);
	public LinkURLDto redirect(Integer id);
	public LinkMetricsDTO getAnalytics(Integer id);
	public LinkDTO invalidate(Integer id);
}
