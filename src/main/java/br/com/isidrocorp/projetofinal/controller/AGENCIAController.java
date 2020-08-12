package br.com.isidrocorp.projetofinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.projetofinal.dao.AGENCIADAO;
import br.com.isidrocorp.projetofinal.model.AGENCIA;

@RestController
@CrossOrigin("*")
public class AGENCIAController {

	@Autowired
	private AGENCIADAO dao;
	
	@GetMapping("/agencia")
	public ArrayList<AGENCIA> getAll(){
		ArrayList<AGENCIA> lista;
		lista = (ArrayList<AGENCIA>)dao.findAll();
		return lista;
	}
	
}
