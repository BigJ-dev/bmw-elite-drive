package com.bmw.elitedrive.module.extra.dao;

import com.bmw.elitedrive.module.extra.model.ExtraJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExtraRepository extends JpaRepository<ExtraJpa, Long> {
    Optional<ExtraJpa> findByNameIgnoreCase(String name);
}
