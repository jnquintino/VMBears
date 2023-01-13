package io.vmbears.xml.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Agente {
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agentes")
	@SequenceGenerator(name = "agentes", sequenceName = "agentes_seq", initialValue = 1, allocationSize = 1)
	private long id;
	@Column
	private int codigo;
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "agente")
	private List<Regiao> regiao;
	@JsonIgnore
	@ManyToOne
	private Agentes agentes;

	@Override
	public String toString() {
		return "Agente{" +
				"codigo=" + codigo +
				", data=" + data +
				", regiao=" + regiao +
				", id=" + id +
				'}';
	}
}
