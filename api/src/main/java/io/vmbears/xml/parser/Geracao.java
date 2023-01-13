package io.vmbears.xml.parser;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class Geracao {
	@XmlElement
	public List<Double> valor;
}
