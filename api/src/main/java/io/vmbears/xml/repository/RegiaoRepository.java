package io.vmbears.xml.repository;

import io.vmbears.xml.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

    List<Regiao> getRegiaoBySiglaEqualsIgnoreCase(final String sigla);

}
