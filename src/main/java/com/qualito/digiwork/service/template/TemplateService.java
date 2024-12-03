package com.qualito.digiwork.service.template;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service
public class TemplateService {

	@Autowired TemplateCrudRepository repo;
	public TemplateEntity create(TemplateEntity meeting) {
		return repo.save(meeting);
	}
	
	public List<TemplateEntity> findAll(){
		return Lists.newArrayList(repo.findAll());
	}
	
	public Optional<TemplateEntity> findById(Long id) {
		return repo.findById(id);
	}
	
	public TemplateEntity update(TemplateEntity meeting) {
		return repo.save(meeting);
	}
	
	public void delete(Long id) {
		repo.delete(repo.findById(id).get());
	
	}
	
}
