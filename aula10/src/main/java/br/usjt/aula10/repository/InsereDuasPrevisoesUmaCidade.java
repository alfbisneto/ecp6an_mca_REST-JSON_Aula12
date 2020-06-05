package br.usjt.aula10.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.aula10.entity.Cidade;
import br.usjt.aula10.entity.DiaDaSemana;
import br.usjt.aula10.entity.Previsao;

public class InsereDuasPrevisoesUmaCidade {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Cidade c = new Cidade();
		c.setNome("Maceio");
		c.setLatitude("-9.66625");
		c.setLongitude("-35.7351");
		List<Previsao> previsoes = new ArrayList<>();
		Previsao p1 = new Previsao();
		p1.setDescricao("dia nublado com ventos fortes");
		p1.setMaxima(23.0);
		p1.setMinima(21.0);
		p1.setUmidade(43.0);
		p1.setCidade(c);
		Previsao p2 = new Previsao();
		p2.setDescricao("dia ensolarado com ceu aberto");
		p2.setMaxima(29.0);
		p2.setMinima(26.0);
		p2.setUmidade(21.0);
		p2.setCidade(c);
		previsoes.add(p1);
		previsoes.add(p2);
		c.setPrevisao(previsoes);
		DiaDaSemana d1 = new DiaDaSemana();
		d1.setNome("Segunda");
		d1.setPrevisao(p1);
		DiaDaSemana d2 = new DiaDaSemana();
		d2.setNome("Terca");
		d2.setPrevisao(p2);
		manager.persist(c);
		manager.persist(d1);
		manager.persist(d2);
		transaction.commit();
		manager.close();
		JPAUtil.close();
		
	}

}
