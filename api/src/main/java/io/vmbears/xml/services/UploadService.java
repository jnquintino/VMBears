package io.vmbears.xml.services;

import io.vmbears.xml.parser.Agente;
import io.vmbears.xml.parser.Agentes;
import io.vmbears.xml.repository.AgentesRepository;
import io.vmbears.xml.utils.XMLToModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UploadService {

    private final AgentesRepository repository;

    public void upload(final InputStream stream) {
        final Optional<Agentes> optional = this.getAgentes(stream);
        if (optional.isPresent()) {
            final Agentes agentes = optional.get();
            final io.vmbears.xml.model.Agentes model = XMLToModel.convert(agentes);
            for (final Agente agente: agentes.getAgente()) {
                System.out.println("Código do agente: " + agente.codigo);
            }
            this.repository.save(model);
        } else {
            System.err.println("Nenhuma informação foi encontrada!");
        }
    }

    private Optional<Agentes> getAgentes(final InputStream stream) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((stream)));
            StringBuilder builder = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                builder.append(output).append("\n");
            }
            StringReader sr = new StringReader(builder.toString());
            JAXBContext jaxbContext = JAXBContext.newInstance(Agentes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return Optional.ofNullable((Agentes) unmarshaller.unmarshal(sr));
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }

    public Optional<String> extension(final String filename) {
        return Optional.ofNullable(filename).filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1));
    }

}
