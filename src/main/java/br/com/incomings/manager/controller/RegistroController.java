package br.com.incomings.manager.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.incomings.manager.model.Registro;
import br.com.incomings.manager.repository.RegistroRepository;

@RestController
@RequestMapping(value = "/api")
public class RegistroController {

	@Autowired
	RegistroRepository registroRepository;

	@GetMapping("/listar")
	public ResponseEntity<List<Registro>> findAll() {
		List<Registro> lista = new ArrayList<Registro>();

		lista = registroRepository.findAll();

		try {
			if (lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/inserir")
	public ResponseEntity<Registro> inserir(@RequestBody Registro registro) {

		if (registro != null) {

			try {
				
				Date dtInclusao = new Date();
				registro.setDtInclusao(dtInclusao);

				Registro _registro = registroRepository.save(registro);
				return new ResponseEntity<>(_registro, HttpStatus.CREATED);

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/alterar")
	public ResponseEntity<Registro> alterar(@RequestBody Registro registro) {

		if (registro.getId() != null) {

			Optional<Registro> registroData = registroRepository.findById(registro.getId().longValue());

			if (registroData.isPresent()) {
				Registro _registro = registroData.get();
				_registro = registro;
				return new ResponseEntity<>(registroRepository.save(_registro), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}

		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<HttpStatus> deleteUsuario(@PathVariable("id") long id) {
		try {
			registroRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
