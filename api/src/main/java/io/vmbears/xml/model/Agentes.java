package io.vmbears.xml.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
@Data
public class Agentes {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agentes")
	@SequenceGenerator(name = "agentes", sequenceName = "agentes_seq", initialValue = 1, allocationSize = 1)
	private long id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agentes")
	private List<Agente> agente;
	@Column
	private Double versao;
	@Column
	private String text;

	@Override
	public String toString() {
		return "Agentes{" +
				"id=" + id +
				", agente=" + agente +
				", versao=" + versao +
				", text='" + text + '\'' +
				'}';
	}
}
