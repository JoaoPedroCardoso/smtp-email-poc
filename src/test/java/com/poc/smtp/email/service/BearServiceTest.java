package com.poc.smtp.email.service;

import com.poc.smtp.email.EmailApplicationTests;
import com.poc.smtp.email.domain.Bear;
import com.poc.smtp.email.infrastruct.exceptions.ObjectNotFoundException;
import com.poc.smtp.email.repository.BearRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BearServiceTest extends EmailApplicationTests {

    @InjectMocks
    private BearService bearService;

    @Mock
    private BearRepository bearRepository;

    @BeforeAll
    public static void BeforeClass(){
        MockitoAnnotations.initMocks(BearServiceTest.class);
        mock(BearService.class);
    }

    @Test
    @DisplayName("Should find all bear with success")
    public void findAllBearTest() {
        when(bearRepository.findAll()).thenReturn(Collections.singletonList(
                Bear.of(1L, "Serramalte", "Puro Malte", 4.09)));
        List<Bear> list = bearService.findAll();
        assertTrue(!list.isEmpty());
    }

    @Test
    @DisplayName("Should find bear by id success")
    public void findBearByIdTest() {
        when(bearRepository.findById(1L)).thenReturn(
                Optional.of(Bear.of(1L, "Serramalte", "Puro Malte", 4.09)));
        assertDoesNotThrow(() -> bearService.findById(1L));
    }

    @Test
    @DisplayName("Should throw exception when find bear by invalid id")
    public void findBearByInvalidIdTest() {
        assertThrows(ObjectNotFoundException.class, () -> bearService.findById(66L));
    }

    @Test
    @DisplayName("Should find bear by name success")
    public void findBearByNameTest() {
        when(bearRepository.findByName("Serramalte")).thenReturn(
                Optional.of(Bear.of(1L, "Serramalte", "Puro Malte", 4.09)));
        assertDoesNotThrow(() -> bearService.findByName("Serramalte"));
    }

    @Test
    @DisplayName("Should throw exception when find bear by invalid name")
    public void findBearByInvalidNameTest() {
        assertThrows(ObjectNotFoundException.class, () -> bearService.findByName("06"));
    }

    @Test
    @DisplayName("Should save bear success")
    public void saveBearTest() {
        assertDoesNotThrow(() ->
                bearService.save(Bear.of(null, "Serramalte", "Puro Malte", 4.09)));
    }

    @Test
    @DisplayName("Should delete bear success")
    public void deleteBearTest() {
        when(bearRepository.findById(1L)).thenReturn(
                Optional.of(Bear.of(1L, "Serramalte", "Puro Malte", 4.09)));
        assertDoesNotThrow(() -> bearService.delete(1L));
    }

    @Test
    @DisplayName("Should throw exception when delete bear by invalid id")
    public void deleteBearByInvalidId() {
        assertThrows(ObjectNotFoundException.class, () -> bearService.delete(66L));
    }

}
