package io.vmbears.xml.parser;

import lombok.Getter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Getter
public class Regiao {
	@XmlElement
	public Geracao geracao;
	@XmlElement
	public Compra compra;
	@XmlElement
	public PrecoMedio precoMedio;
	@XmlAttribute
	public String sigla;
	@XmlAttribute
	public String text;
}
