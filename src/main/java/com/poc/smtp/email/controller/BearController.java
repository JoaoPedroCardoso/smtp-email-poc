package com.poc.smtp.email.controller;

import com.poc.smtp.email.domain.Bear;
import com.poc.smtp.email.service.BearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/bear")
public class BearController {

    @Autowired
    private BearService bearService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Bear>> findAll() {
        return ResponseEntity.ok().body(bearService.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bear> findById(@PathVariable Long id) {
        Bear bear = bearService.findById(id);
        return ResponseEntity.ok().body(bear);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Bear> findByName(@PathVariable String name) {
        Bear bear = bearService.findByName(name);
        return ResponseEntity.ok().body(bear);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Bear user){
        Bear obj = bearService.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bearService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
