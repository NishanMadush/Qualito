package com.qualito.digiwork.service.template;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/template")
public class TemplateController {
	@Autowired TemplateService service;
	
    @GetMapping("/all")
	public ResponseEntity<List<TemplateEntity>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}

    @GetMapping("/{id}")
	public ResponseEntity<TemplateEntity> find(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.findById(id).get());
	}

    @PostMapping
    public ResponseEntity<TemplateEntity> create(@Valid @RequestBody TemplateEntity activity) {
    	TemplateEntity created = service.create(activity);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<TemplateEntity> update(
            @Valid @RequestBody TemplateEntity updatedMeeting) {

        TemplateEntity updated = service.update(updatedMeeting);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
    	service.delete(id);
    }
}
