package br.usjt.aula10.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_previsao")
public class Previsao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Double minima;
	private Double maxima;
	private Double umidade;
	private String descricao;
	@OneToOne(mappedBy="previsao")
	private DiaDaSemana Dia;
	@ManyToOne
	private Cidade cidade;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public DiaDaSemana getDia() {
		return Dia;
	}
	public void setDia(DiaDaSemana dia) {
		Dia = dia;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getMinima() {
		return minima;
	}
	public void setMinima(Double minima) {
		this.minima = minima;
	}
	public Double getMaxima() {
		return maxima;
	}
	public void setMaxima(Double maixima) {
		this.maxima = maixima;
	}
	public Double getUmidade() {
		return umidade;
	}
	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Previsao other = (Previsao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Previsao [id=" + id + ", minima=" + minima + ", maxima=" + maxima + ", umidade=" + umidade
				+ ", descricao=" + descricao + ", cidade=" + cidade + "]";
	}

	
	
}
