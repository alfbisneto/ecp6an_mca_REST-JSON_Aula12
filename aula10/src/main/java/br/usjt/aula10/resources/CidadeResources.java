package br.usjt.aula10.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.usjt.aula10.entity.Cidade;
import br.usjt.aula10.repository.CidadeRepository;


@RestController
@RequestMapping("/cidades")
public class CidadeResources {
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@GetMapping("/lista")
	public List<Cidade> todasCidades(){
		return cidadeRepo.findAll();
	}
	
	@GetMapping("/letra/{letra}")
	public Cidade buscarLetra(@PathVariable String letra) {
		return cidadeRepo.findByLetra(letra);
	}
	
	@GetMapping("/longitude/{longitude}")
	public Cidade buscarLongitude(@PathVariable String longitude) {
		return cidadeRepo.findByLongitude(longitude);
	}
	
	@GetMapping("/latitude/{latitude}")
	public Cidade buscarLatitude(@PathVariable String latitude) {
		return cidadeRepo.findByLatitude(latitude);
	}
	
	@PostMapping("/salvar")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cidade> salvar(@RequestBody Cidade cidade) {
		Cidade c = cidadeRepo.save(cidade);
		URI uri = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/{lista}").
				buildAndExpand(c.getId()).
				toUri();
		//response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(c);
	}

}
