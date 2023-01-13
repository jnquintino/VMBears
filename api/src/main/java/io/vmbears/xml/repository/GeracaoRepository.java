package io.vmbears.xml.repository;

import io.vmbears.xml.model.Geracao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeracaoRepository extends JpaRepository<Geracao, Long> {
}
