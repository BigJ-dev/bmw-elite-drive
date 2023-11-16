package com.bmw.elitedrive.module.client.dao;

import com.bmw.elitedrive.module.client.model.ClientJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientJpa, Long> {
    Optional<ClientJpa> findClientByIdNumber(String id);
}
