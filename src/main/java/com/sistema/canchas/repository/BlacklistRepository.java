package com.sistema.canchas.repository;

import com.sistema.canchas.model.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<Blacklist,Long> {
}
