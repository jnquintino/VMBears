package io.vmbears.xml.parser;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@Getter
public class Agentes {
	@XmlElement
	public List<Agente> agente;
	@XmlElement
	public double versao;
	@XmlElement
	public String text;
}
