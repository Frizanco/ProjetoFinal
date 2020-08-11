package br.com.isidrocorp.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="itmn032_agendamento")
public class AGENDAMENTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
	private int numSeq;
	
	@Column (name="nome_cli", length=100)
	private String nomeCliente;
	
	@Column(name="email_cli", length=100)
	private String emailCliente;
	
	@Column(name="celular_cli",length=20)
	private String celularCliente;
	
	@Column(name="data_agendamento")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy", shape=JsonFormat.Shape.STRING)
	private Date dataAgendamento;
	
	@Column(name="hora_agendamento")
	@JsonFormat(pattern="HH:mm", shape=JsonFormat.Shape.STRING)
	@Temporal(TemporalType.TIME)
	private Date horaAgendamento;
	
	@Column(name="observacao",length=255)
	private String observacoes;	
	
	@ManyToOne
	@JoinColumn(name="id_agencia")
	@JsonIgnoreProperties("listaAGENDAMENTO") 
	private AGENCIA agc;
	
	

	@Override
	public String toString() {
		return "AGENDAMENTO [numSeq=" + numSeq + ", nomeCliente=" + nomeCliente + ", emailCliente=" + emailCliente
				+ ", celularCliente=" + celularCliente + ", dataAgendamento=" + dataAgendamento + ", horaAgendamento="
				+ horaAgendamento + ", observacoes=" + observacoes + ", agc=" + agc + "]";
	}
	
	
	
	public int getNumSeq() {
		return numSeq;
	}
	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public String getCelularCliente() {
		return celularCliente;
	}
	public void setCelularCliente(String celularCliente) {
		this.celularCliente = celularCliente;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Date getHoraAgendamento() {
		return horaAgendamento;
	}
	public void setHoraAgendamento(Date horaAgendamento) {
		this.horaAgendamento = horaAgendamento;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public AGENCIA getAgc() {
		return agc;
	}
	public void setAgc(AGENCIA aGC) {
		agc = aGC;
	}
	
	
}
