package br.usjt.aula10.repository;

import javax.persistence.Persistence;

public class TesteCriarBaseETabelas {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("aula10PU");
	}

}
