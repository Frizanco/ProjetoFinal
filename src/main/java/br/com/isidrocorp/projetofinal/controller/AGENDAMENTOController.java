package br.com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.AGENDAMENTODAO;
import br.com.isidrocorp.projetofinal.model.AGENDAMENTO;

@RestController
public class AGENDAMENTOController {
	
	@Autowired
	private AGENDAMENTODAO dao;
	
	@GetMapping("/agendamento")
	public ArrayList<AGENDAMENTO> getAll(){
		ArrayList<AGENDAMENTO> lista;
		lista = (ArrayList<AGENDAMENTO>)dao.findAll();
		return lista;
	}
	
}
