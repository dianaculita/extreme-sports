package com.company.repository;

import com.company.model.ExtremeSport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ExtremeSportRepository extends JpaRepository<ExtremeSport, Long>{

    Optional<ExtremeSport> getExtremeSportBySportId(Long id);

    Optional<ExtremeSport> getExtremeSportByName(String name);

}
