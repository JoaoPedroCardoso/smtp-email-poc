package com.poc.smtp.email.service;

import com.poc.smtp.email.domain.Bear;
import com.poc.smtp.email.infrastruct.exceptions.ObjectNotFoundException;
import com.poc.smtp.email.repository.BearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BearService {

    @Autowired
    private BearRepository bearRepository;

    public List<Bear> findAll() {
        return bearRepository.findAll();
    }

    public Bear findById(Long id) {
        return bearRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Bear with ID: " + id + ", was not found."));
    }

    public Bear findByName(String name) {
        return bearRepository.findByName(name).orElseThrow(() ->
                new ObjectNotFoundException("Bear with name: " + name + ", was not found."));
    }

    public Bear save(Bear bear) {
        return bearRepository.save(bear);
    }

    public void delete(Long id) {
        this.findById(id);
        bearRepository.deleteById(id);
    }

}
