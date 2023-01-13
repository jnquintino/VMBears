package io.vmbears.xml.utils;

import io.vmbears.xml.model.Agente;
import io.vmbears.xml.model.Agentes;
import io.vmbears.xml.model.Compra;
import io.vmbears.xml.model.Geracao;
import io.vmbears.xml.model.PrecoMedio;
import io.vmbears.xml.model.Regiao;
import io.vmbears.xml.model.Valor;

import java.util.ArrayList;
import java.util.List;

public class XMLToModel {

    public static Agentes convert(final io.vmbears.xml.parser.Agentes agentes) {
        final Agentes result = new Agentes();
        result.setText(agentes.getText());
        result.setVersao(agentes.getVersao());
        result.setAgente(XMLToModel.listOfAgentes(agentes.getAgente(), result));
        return result;
    }

    private static List<Agente> listOfAgentes(final List<io.vmbears.xml.parser.Agente> agentes,
                                              final Agentes principal) {
        final List<Agente> result = new ArrayList<>();
        if (agentes != null) {
            for (final io.vmbears.xml.parser.Agente agente: agentes) {
                final Agente item = new Agente();
                item.setCodigo(agente.getCodigo());
                item.setData(agente.getData());
                item.setRegiao(XMLToModel.listOfRegioes(agente.getRegiao(), item));
                item.setAgentes(principal);
                result.add(item);
            }
        }
        return result;
    }

    private static List<Regiao> listOfRegioes(final List<io.vmbears.xml.parser.Regiao> regioes,
                                              final Agente principal) {
        final List<Regiao> result = new ArrayList<>();
        if (regioes != null) {
            for (final io.vmbears.xml.parser.Regiao regiao: regioes) {
                final Regiao item = new Regiao();
                item.setSigla(regiao.getSigla());
                item.setText(regiao.getText());
                item.setGeracao(XMLToModel.convertGeracao(regiao.getGeracao(), item));
                item.setCompra(XMLToModel.convertCompra(regiao.getCompra(), item));
                item.setPrecoMedio(XMLToModel.convertPrecoMedio(regiao.getPrecoMedio(), item));
                item.setAgente(principal);
                result.add(item);
            }
        }
        return result;
    }

    private static Geracao convertGeracao(final io.vmbears.xml.parser.Geracao geracao, final Regiao principal) {
        final Geracao result = new Geracao();
        if (geracao == null) {
            return null;
        }
        result.setValor(XMLToModel.listOfValor(geracao.getValor(), result));
        result.setRegiao(principal);
        return result;
    }

    private static Compra convertCompra(final io.vmbears.xml.parser.Compra compra, final Regiao principal) {
        final Compra result = new Compra();
        if (compra == null) {
            return null;
        }
        result.setValor(XMLToModel.listOfValor(compra.getValor(), result));
        result.setRegiao(principal);
        return result;
    }

    private static PrecoMedio convertPrecoMedio(final io.vmbears.xml.parser.PrecoMedio precoMedio,
                                                final Regiao principal) {
        final PrecoMedio result = new PrecoMedio();
        if (precoMedio == null) {
            return null;
        }
        result.setValor(XMLToModel.listOfValor(precoMedio.getValor(), result));
        result.setRegiao(principal);
        return result;
    }

    private static List<Valor> listOfValor(final List<Double> valores, final Geracao geracao) {
        return listOfValor(valores, geracao, null, null);
    }

    private static List<Valor> listOfValor(final List<Double> valores, final Compra compra) {
        return listOfValor(valores, null, compra, null);
    }

    private static List<Valor> listOfValor(final List<Double> valores, final PrecoMedio precoMedio) {
        return listOfValor(valores, null, null, precoMedio);
    }

    private static List<Valor> listOfValor(final List<Double> valores, final Geracao geracao, final Compra compra,
                                           final PrecoMedio precoMedio) {
        final List<Valor> result = new ArrayList<>();
        if (valores != null) {
            for (final Double valor: valores) {
                result.add(new Valor(valor, compra, geracao, precoMedio));
            }
        }
        return result;
    }

}
