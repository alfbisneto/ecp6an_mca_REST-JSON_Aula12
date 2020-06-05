package br.usjt.aula10.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.usjt.aula10.entity.DiaDaSemana;
import br.usjt.aula10.entity.Previsao;

public class InsereUsuario {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Previsao p = new Previsao();
		p.setMinima(23.0);
		p.setMaxima(27.0);
		p.setUmidade(45.0);
		p.setDescricao("Dia ensolarado com pequena chance de chuva");
		manager.persist(p);
		DiaDaSemana d = new DiaDaSemana();
		d.setNome("Segunda");
		d.setPrevisao(p);
		manager.persist(d);
		transaction.commit();
		manager.close();
		JPAUtil.close();
	}

}
