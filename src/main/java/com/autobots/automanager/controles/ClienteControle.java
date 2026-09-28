package com.autobots.automanager.controles;

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
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.ClienteAtualizador;
import com.autobots.automanager.modelo.ClienteSelecionador;
import com.autobots.automanager.modelo.Resposta;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@RestController
@RequestMapping("/cliente")
public class ClienteControle {
	@Autowired
	private ClienteRepositorio repositorio;
	@Autowired
	private ClienteSelecionador selecionador;

	@GetMapping("/{id}")
	public ResponseEntity<Object> obterCliente(@PathVariable long id) {
		List<Cliente> clientes = repositorio.findAll();
		Cliente cliente = selecionador.selecionar(clientes, id);
		if (cliente == null) {
			Resposta resposta = new Resposta("Cliente não encontrado", "404 NOT_FOUND");
			return new ResponseEntity<Object>(resposta, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(cliente, HttpStatus.OK);
	}

	@GetMapping("/clientes")
	public ResponseEntity<Object> obterClientes() {
		List<Cliente> clientes = repositorio.findAll();
		return new ResponseEntity<Object>(clientes, HttpStatus.OK);
	}

	@PostMapping("/cadastro")
	public ResponseEntity<Object> cadastrarCliente(@RequestBody Cliente cliente) {
		repositorio.save(cliente);
		Resposta resposta = new Resposta("Cliente cadastrado com sucesso", "201 CREATED");
		return new ResponseEntity<Object>(resposta, HttpStatus.CREATED);
	}

	@PutMapping("/atualizar")
	public ResponseEntity<Object> atualizarCliente(@RequestBody Cliente atualizacao) {
		Cliente cliente = repositorio.findById(atualizacao.getId()).orElse(null);
		if (cliente == null) {
			Resposta resposta = new Resposta("Cliente não encontrado", "404 NOT_FOUND");
			return new ResponseEntity<Object>(resposta, HttpStatus.NOT_FOUND);
		}
		ClienteAtualizador atualizador = new ClienteAtualizador();
		atualizador.atualizar(cliente, atualizacao);
		repositorio.save(cliente);
		Resposta resposta = new Resposta("Cliente atualizado com sucesso", "200 OK");
		return new ResponseEntity<Object>(resposta, HttpStatus.OK);
	}

	@DeleteMapping("/excluir")
	public ResponseEntity<Object> excluirCliente(@RequestBody Cliente exclusao) {
		Cliente cliente = repositorio.findById(exclusao.getId()).orElse(null);
		if (cliente == null) {
			Resposta resposta = new Resposta("Cliente não encontrado", "404 NOT_FOUND");
			return new ResponseEntity<Object>(resposta, HttpStatus.NOT_FOUND);
		}
		repositorio.delete(cliente);
		Resposta resposta = new Resposta("Cliente excluído com sucesso", "200 OK");
		return new ResponseEntity<Object>(resposta, HttpStatus.OK);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<Object> excluirClientePorId(@PathVariable long id) {
		Cliente cliente = repositorio.findById(id).orElse(null);
		if (cliente == null) {
			Resposta resposta = new Resposta("Cliente não encontrado", "404 NOT_FOUND");
			return new ResponseEntity<Object>(resposta, HttpStatus.NOT_FOUND);
		}
		repositorio.delete(cliente);
		Resposta resposta = new Resposta("Cliente excluído com sucesso", "200 OK");
		return new ResponseEntity<Object>(resposta, HttpStatus.OK);
	}
}
