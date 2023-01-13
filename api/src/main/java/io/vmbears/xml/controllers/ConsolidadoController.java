package io.vmbears.xml.controllers;

import io.vmbears.xml.model.Agente;
import io.vmbears.xml.services.ConsolidadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consolidado")
@AllArgsConstructor
public class ConsolidadoController {

    private final ConsolidadoService service;

    @GetMapping(path = "/regiao/{sigla}")
    public ResponseEntity<?> consolidado(@PathVariable String sigla) {
        final Optional<List<Agente>> result = this.service.filterByRegiao(sigla);
        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

}
