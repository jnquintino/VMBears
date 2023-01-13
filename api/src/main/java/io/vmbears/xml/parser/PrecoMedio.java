package io.vmbears.xml.parser;

import lombok.Getter;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Getter
public class PrecoMedio {
	@XmlElement
	public List<Double> valor;
}
