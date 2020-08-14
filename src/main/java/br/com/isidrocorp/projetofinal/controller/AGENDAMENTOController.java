package br.com.isidrocorp.projetofinal.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.AGENDAMENTODAO;
import br.com.isidrocorp.projetofinal.model.AGENCIA;
import br.com.isidrocorp.projetofinal.model.AGENDAMENTO;

@RestController
@CrossOrigin("*")
public class AGENDAMENTOController {
	
	@Autowired
	private AGENDAMENTODAO dao;
	
	@PostMapping("/agendamento/novo")
	public ResponseEntity<AGENDAMENTO> inserirNovoAgendamento(@RequestBody AGENDAMENTO novo){
		System.out.println("TESTE - PASSOU DAQUI");
		try {
			System.out.println(novo.getNomeCliente());
			dao.save(novo);
			return ResponseEntity.status(201).body(novo);
		}
		catch(Exception ex) {
			return ResponseEntity.status(400).build();
		}
	}
	
	@GetMapping("/agendamento/todos")
	public ArrayList<AGENDAMENTO> pegarTodos(){
		ArrayList<AGENDAMENTO> lista;
		lista = (ArrayList<AGENDAMENTO>)dao.findAll();
		return lista;
	}
	



// combinacao 4
	@GetMapping("/agendamentos/filtrarporcliente")
	public ArrayList<AGENDAMENTO> filtrarPorCliente(@RequestParam(name="nomecli") String nome){
		return dao.findAllByNomeClienteContaining(nome);
	}
	
	// combinacao 1
	@GetMapping("/agendamentos/filtrarporagencia")
	public ArrayList<AGENDAMENTO> filtrarPorAgencia(@RequestParam(name="agencia") int agencia){
		AGENCIA agc = new AGENCIA();
		agc.setId(agencia);
		return dao.findAllByAgc(agc);
	}
	
	
	@GetMapping("/agendamentos/filtrarpordata")
	public ArrayList<AGENDAMENTO> filtrarPorData(@RequestParam(name="data") String dataAgendamento){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);	
		return dao.findAllByDataAgendamento(data);
	}
	
	@GetMapping("/agendamentos/filtrarporAgenciaData")
	public ArrayList<AGENDAMENTO> filtrarporAgenciaData(@RequestParam(name="agencia") int agencia, @RequestParam(name="data") String dataAgendamento ){
		AGENCIA agc = new AGENCIA();
		agc.setId(agencia);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);	
		return dao.findAllByAgcAndDataAgendamento(agc, data);
	}
	
	@GetMapping("/agendamentos/filtrarporAgenciaCliente")
	public ArrayList<AGENDAMENTO> filtrarporAgenciaCliente(@RequestParam(name="agencia") int agencia, @RequestParam(name="nomecli") String nome){
		AGENCIA agc = new AGENCIA();
		agc.setId(agencia);
		return dao.findAllByAgcAndNomeClienteContaining(agc, nome);
	}
	
	@GetMapping("/agendamentos/filtrarpordataCliente")
	public ArrayList<AGENDAMENTO> filtrarPorDataCliente(@RequestParam(name="data") String dataAgendamento, @RequestParam(name="nomecli") String nome){
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);		
		return dao.findAllByDataAgendamentoAndNomeClienteContaining(data, nome);
	}
	
	@GetMapping("/agendamentos/filtrarporagenciaDataCliente")
	public ArrayList<AGENDAMENTO> filtrarPorAgenciaDataCliente(@RequestParam(name="agencia") int agencia, @RequestParam(name="data") String dataAgendamento, @RequestParam(name="nomecli") String nome){
		AGENCIA agc = new AGENCIA();
		agc.setId(agencia);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate data = LocalDate.parse(dataAgendamento, fmt);		
		return dao.findAllByAgcAndDataAgendamentoAndNomeClienteContaining(agc, data, nome);
	}
	
	


}

















