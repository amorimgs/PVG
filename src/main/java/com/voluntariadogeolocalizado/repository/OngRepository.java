package com.voluntariadogeolocalizado.repository;

import com.voluntariadogeolocalizado.entity.Ong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OngRepository extends JpaRepository<Ong, Long> {
}
