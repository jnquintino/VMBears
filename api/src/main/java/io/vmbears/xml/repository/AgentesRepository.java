package io.vmbears.xml.repository;

import io.vmbears.xml.model.Agentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentesRepository extends JpaRepository<Agentes, Long> {
}
