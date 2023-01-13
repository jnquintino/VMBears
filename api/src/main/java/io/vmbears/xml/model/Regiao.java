package io.vmbears.xml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Data
public class Regiao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "regiao")
	@SequenceGenerator(name = "regiao", sequenceName = "regiao_seq", initialValue = 1, allocationSize = 1)
	private long id;
	@OneToOne(cascade = CascadeType.ALL)
	private Geracao geracao;
	@OneToOne(cascade = CascadeType.ALL)
	private Compra compra;
	@OneToOne(cascade = CascadeType.ALL)
	private PrecoMedio precoMedio;
	@Column
	private String sigla;
	@Column
	private String text;
	@JsonIgnore
	@ManyToOne
	private Agente agente;

	@Override
	public String toString() {
		return "Regiao{" +
				"id=" + id +
				", geracao=" + geracao +
				", compra=" + compra +
				", precoMedio=" + precoMedio +
				", sigla='" + sigla + '\'' +
				", text='" + text + '\'' +
				'}';
	}
}
