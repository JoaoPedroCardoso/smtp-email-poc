package com.poc.smtp.email.controller;

import com.poc.smtp.email.controller.request.MailUpdateRequest;
import com.poc.smtp.email.domain.User;
import com.poc.smtp.email.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = service.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<User> findByName(@PathVariable String name) {
        User user = service.findByName(name);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody User user){
        User obj = service.save(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public ResponseEntity<User> updateMail(@PathVariable Long id, @RequestBody MailUpdateRequest mail){
        User obj = service.updateMail(id, mail.getEmail());
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}/bear/{bearId}", method=RequestMethod.PUT)
    public ResponseEntity<User> consumeBear(@PathVariable Long id, @PathVariable Long bearId){
        User obj = service.consumeBear(id, bearId);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
