package io.vmbears.xml.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@NoArgsConstructor
public class Valor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "valor")
	@SequenceGenerator(name = "valor", sequenceName = "valor_seq", initialValue = 1, allocationSize = 1)
	private long id;
	@Column
	@JsonIgnore
	private Double valor;
	@JsonIgnore
	@ManyToOne
	private Compra compra;
	@JsonIgnore
	@ManyToOne
	private Geracao geracao;
	@JsonIgnore
	@ManyToOne
	private PrecoMedio precoMedio;

	public Valor(final Double valor, final Compra compra, final Geracao geracao, final PrecoMedio precoMedio) {
		this.valor = valor;
		this.compra = compra;
		this.geracao = geracao;
		this.precoMedio = precoMedio;
	}

	@Override
	public String toString() {
		return "Valor{" +
				"id=" + id +
				", valor=" + valor +
				'}';
	}
}
