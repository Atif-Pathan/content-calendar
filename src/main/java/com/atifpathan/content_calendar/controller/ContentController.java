package com.atifpathan.content_calendar.controller;

import com.atifpathan.content_calendar.model.Content;
import com.atifpathan.content_calendar.model.Status;
import com.atifpathan.content_calendar.repository.ContentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/content")
@CrossOrigin // for CORS, look into this ----------------------------------------------------------------->
public class ContentController {

    private final ContentRepository repository;

    @Autowired
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "")
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Content findById(@PathVariable Integer id) {
        return repository.findById(id)
                         .orElseThrow(() ->
                                 new ResponseStatusException(HttpStatus.NOT_FOUND,"Content Not Found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "")
    public void create(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(path = "/{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!");
        }
//        Optional<Content> c = repository.findById(id);
//        repository.deleteById(id);
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping(path = "/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword) {
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping(path = "/filter/status/{status}")
    public List<Content> findByStatus(@PathVariable Status status) {
        return repository.listByStatus(status);
    }
}
