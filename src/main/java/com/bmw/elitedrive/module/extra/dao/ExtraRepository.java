package com.bmw.elitedrive.module.extra.dao;

import com.bmw.elitedrive.module.extra.model.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExtraRepository extends JpaRepository<Extra, Long> {
}
