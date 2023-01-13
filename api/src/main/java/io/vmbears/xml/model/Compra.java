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
public class Compra {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compra")
	@SequenceGenerator(name = "compra", sequenceName = "compra_seq", initialValue = 1, allocationSize = 1)
	private long id;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
	private List<Valor> valor;
	@JsonIgnore
	@OneToOne
	private Regiao regiao;

	@Override
	public String toString() {
		return "Compra{" +
				"id=" + id +
				", valor=" + valor +
				'}';
	}
}
