package br.usjt.aula10.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_cidade")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String latitude;
	private String longitude;
	@OneToMany(mappedBy="cidade", cascade=CascadeType.ALL)
	private List <Previsao> previsoes;
	
	public List<Previsao> getPrevisao() {
		return previsoes;
	}
	public void setPrevisao(List<Previsao> previsao) {
		this.previsoes = previsao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}


	
	
	
	

}
