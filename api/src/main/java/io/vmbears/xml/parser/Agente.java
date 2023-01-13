package io.vmbears.xml.parser;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;
import java.util.List;

@Getter
public class Agente {
	@XmlElement
	public int codigo;
	@XmlElement
	public Date data;
	@XmlElement
	public List<Regiao> regiao;
}
