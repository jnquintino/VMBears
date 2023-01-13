package io.vmbears.xml.repository;

import io.vmbears.xml.model.PrecoMedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoMedioRepository extends JpaRepository<PrecoMedio, Long> {
}
