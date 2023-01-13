package io.vmbears.xml.services;

import io.vmbears.xml.model.Agente;
import io.vmbears.xml.model.Agentes;
import io.vmbears.xml.model.Regiao;
import io.vmbears.xml.repository.RegiaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConsolidadoService {

    private final RegiaoRepository repository;

    public Optional<List<Agente>> filterByRegiao(final String regiao) {
        return Optional.ofNullable(this.prepareResponse(this.repository.getRegiaoBySiglaEqualsIgnoreCase(regiao)));
    }

    private List<Agente> prepareResponse(final List<Regiao> regioes) {
        final List<Agente> result = new ArrayList<>();
        for (final Regiao regiao: regioes) {
            result.add(this.prepareAgente(regiao));
        }
        return result;
    }

    private Agente prepareAgente(final Regiao regiao) {
        final Agente result = new Agente();
        result.setId(regiao.getAgente().getId());
        result.setData(regiao.getAgente().getData());
        result.setCodigo(regiao.getAgente().getCodigo());
        result.setRegiao(new ArrayList<>());
        result.getRegiao().add(regiao);
        return result;
    }
}
