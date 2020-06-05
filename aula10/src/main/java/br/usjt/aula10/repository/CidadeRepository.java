package br.usjt.aula10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.usjt.aula10.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade,Long> {
	
	public Cidade findByLatitude(String latitude);
	
	public Cidade findByLongitude(String longitude);
	
	@Query(value = "SELECT * FROM tb_cidade WHERE nome LIKE CONCAT('%',:letra,'%')", nativeQuery = true)
	public Cidade findByLetra(@Param("letra") String letra);

}
