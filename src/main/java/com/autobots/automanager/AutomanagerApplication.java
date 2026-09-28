package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.entidades.Telefone;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public ClienteRepositorio repositorio;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			Calendar calendario1 = Calendar.getInstance();
			calendario1.set(2002, 5, 15);

			Cliente cliente1 = new Cliente();
			cliente1.setId(1L);
			cliente1.setNome("Pedro Alcântara de Bragança e Bourbon");
			cliente1.setDataCadastro(Calendar.getInstance().getTime());
			cliente1.setDataNascimento(calendario1.getTime());
			cliente1.setNomeSocial("Dom Pedro");
			
			Telefone telefone1 = new Telefone();
			telefone1.setDdd("21");
			telefone1.setNumero("981234576");
			cliente1.getTelefones().add(telefone1);
			
			Endereco endereco1 = new Endereco();
			endereco1.setEstado("Rio de Janeiro");
			endereco1.setCidade("Rio de Janeiro");
			endereco1.setBairro("Copacabana");
			endereco1.setRua("Avenida Atlântica");
			endereco1.setNumero("1702");
			endereco1.setCodigoPostal("22021001");
			endereco1.setInformacoesAdicionais("Hotel Copacabana palace");
			cliente1.setEndereco(endereco1);
			
			Documento rg1 = new Documento();
			rg1.setTipo("RG");
			rg1.setNumero("1500");
			
			Documento cpf1 = new Documento();
			cpf1.setTipo("CPF");
			cpf1.setNumero("00000000001");
			
			cliente1.getDocumentos().add(rg1);
			cliente1.getDocumentos().add(cpf1);
			
			repositorio.save(cliente1);

			Calendar calendario2 = Calendar.getInstance();
			calendario2.set(2001, 3, 6);

			Cliente cliente2 = new Cliente();
			cliente2.setId(81L);
			cliente2.setNome("Oscar Piastri");
			cliente2.setDataCadastro(Calendar.getInstance().getTime());
			cliente2.setDataNascimento(calendario2.getTime());
			cliente2.setNomeSocial("Pilastri");

			Telefone telefone2 = new Telefone();
			telefone2.setDdd("81");
			telefone2.setNumero("981818181");
			cliente2.getTelefones().add(telefone2);

			Endereco endereco2 = new Endereco();
			endereco2.setEstado("São Paulo");
			endereco2.setCidade("São José dos Campos");
			endereco2.setBairro("Urbanova");
			endereco2.setRua("Eduardo Cury");
			endereco2.setNumero("3332");
			endereco2.setCodigoPostal("1281818");
			cliente2.setEndereco(endereco2);

			Documento rg2 = new Documento();
			rg2.setTipo("RG");
			rg2.setNumero("81");

			Documento cpf2 = new Documento();
			cpf2.setTipo("CPF");
			cpf2.setNumero("00000000081");

			cliente2.getDocumentos().add(rg2);
			cliente2.getDocumentos().add(cpf2);

			repositorio.save(cliente2);
		}
	}

}
