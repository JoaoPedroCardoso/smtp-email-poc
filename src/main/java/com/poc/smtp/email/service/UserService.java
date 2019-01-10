package com.poc.smtp.email.service;

import com.poc.smtp.email.domain.Bear;
import com.poc.smtp.email.domain.User;
import com.poc.smtp.email.infrastruct.exceptions.ObjectNotFoundException;
import com.poc.smtp.email.repository.BearRepository;
import com.poc.smtp.email.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BearRepository bearRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("User with ID: " + id + ", was not found."));
    }

    public User findByName(String name) {
        return userRepository.findByName(name).orElseThrow(() ->
                new ObjectNotFoundException("User with name: " + name + ", was not found."));
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User updateMail(Long userId, String mail) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ObjectNotFoundException("User with ID: " + userId + ", was not found."));
        user.setEmail(mail);
        return userRepository.save(user);
    }

    public User consumeBear(Long userId, Long bearId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ObjectNotFoundException("User with ID: " + userId + ", was not found."));
        List<Bear> bearList = user.getBearConsume();

        Bear bear = bearRepository.findById(bearId).orElseThrow(() ->
                new ObjectNotFoundException("Bear with ID: " + bearId + ", was not found."));

        bearList.add(bear);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        this.findById(id);
        userRepository.deleteById(id);
    }

}
