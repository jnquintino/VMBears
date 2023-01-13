package io.vmbears.xml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Entity
@Data
public class Geracao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geracao")
	@SequenceGenerator(name = "geracao", sequenceName = "geracao_seq", initialValue = 1, allocationSize = 1)
	private long id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "geracao")
	private List<Valor> valor;
	@JsonIgnore
	@OneToOne
	private Regiao regiao;

	@Override
	public String toString() {
		return "Geracao{" +
				"id=" + id +
				", valor=" + valor +
				'}';
	}
}
