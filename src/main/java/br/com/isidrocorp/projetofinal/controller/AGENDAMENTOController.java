package br.com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.AGENDAMENTODAO;
import br.com.isidrocorp.projetofinal.model.AGENDAMENTO;

@RestController
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
	
}
