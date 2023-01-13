package io.vmbears.xml.repository;

import io.vmbears.xml.model.Valor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorRepository extends JpaRepository<Valor, Long> {
}
