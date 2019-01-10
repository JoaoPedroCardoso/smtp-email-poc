package com.poc.smtp.email.service;

import com.poc.smtp.email.EmailApplicationTests;
import com.poc.smtp.email.domain.User;
import com.poc.smtp.email.infrastruct.exceptions.ObjectNotFoundException;
import com.poc.smtp.email.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest extends EmailApplicationTests {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeAll
    public static void BeforeClass(){
        MockitoAnnotations.initMocks(UserServiceTest.class);
        mock(UserService.class);
    }

    @Test
    @DisplayName("Should find all user with success")
    public void findAllUserTest() {
        when(userRepository.findAll()).thenReturn(Collections.singletonList(
                User.of(1L, "test", "test@gamil.com", Collections.emptyList())));
        List<User> list = userService.findAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("Should find user by id success")
    public void findUserByIdTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(
                User.of(1L, "test", "test@gamil.com", Collections.emptyList())));
        assertDoesNotThrow(() -> userService.findById(1L));
    }

    @Test
    @DisplayName("Should throw exception when find user by invalid id")
    public void findUserByInvalidIdTest() {
        assertThrows(ObjectNotFoundException.class, () -> userService.findById(66L));
    }

    @Test
    @DisplayName("Should find user by name success")
    public void findUserByNameTest() {
        when(userRepository.findByName("test")).thenReturn(Optional.of(
                User.of(1L, "test", "test@gamil.com", Collections.emptyList())));
        assertDoesNotThrow(() -> userService.findByName("test"));
    }

    @Test
    @DisplayName("Should throw exception when find user by invalid name")
    public void findUserByInvalidNameTest() {
        assertThrows(ObjectNotFoundException.class, () -> userService.findByName("06"));
    }

    @Test
    @DisplayName("Should save user success")
    public void saveUserTest() {
        assertDoesNotThrow(() ->
                userService.save(User.of(null, "test", "test@gamil.com", Collections.emptyList())));
    }

    @Test
    @DisplayName("Should delete user success")
    public void deleteUserTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(
                User.of(1L, "test", "test@gamil.com", Collections.emptyList())));
        assertDoesNotThrow(() -> userService.deleteUser(1L));
    }

    @Test
    @DisplayName("Should throw exception when delete user by invalid id")
    public void deleteUserByInvalidId() {
        assertThrows(ObjectNotFoundException.class, () -> userService.deleteUser(1L));
    }

    @Test
    @DisplayName("Should update user mail success")
    public void updateMailUserTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(
                User.of(1L, "test", "test@gamil.com", Collections.emptyList())));
        when(userRepository.save(User.of(1L, "test", "foo@gmail.com", Collections.emptyList())))
                .thenReturn(User.of(1L, "test", "foo@gmail.com", Collections.emptyList()));
        User user = userService.updateMail(1L, "foo@gmail.com");
        assertEquals("foo@gmail.com", user.getEmail());
        assertEquals("1", user.getId().toString());

    }

    @Test
    @DisplayName("Should throw exception when try update mail user by invalid user id")
    public void updateMailForInvalidUserTest() {
        assertThrows(ObjectNotFoundException.class, () -> userService.updateMail(66L, "foo"));
    }

}
