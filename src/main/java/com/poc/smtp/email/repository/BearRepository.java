package com.poc.smtp.email.repository;

import com.poc.smtp.email.domain.Bear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface BearRepository extends JpaRepository<Bear, Long> {

    @Transactional(readOnly = true)
    Optional<Bear> findByName(String name);

}
