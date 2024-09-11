package com.voluntariadogeolocalizado.repository;

import com.voluntariadogeolocalizado.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportynityRepository extends JpaRepository<Opportunity, Long> {
}
