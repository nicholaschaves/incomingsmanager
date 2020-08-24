package br.com.incomings.manager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRO")
public class Registro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private Date dtInclusao;
	private String nomeRequisitor;
	private String cpfRequisitor;
	private String nascimentoRequisitor;
	private String telefoneRequisitor;
	private String valorPrecificadoRegistro;
	private String formaPagamento;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}
	public String getNomeRequisitor() {
		return nomeRequisitor;
	}
	public void setNomeRequisitor(String nomeRequisitor) {
		this.nomeRequisitor = nomeRequisitor;
	}
	public String getCpfRequisitor() {
		return cpfRequisitor;
	}
	public void setCpfRequisitor(String cpfRequisitor) {
		this.cpfRequisitor = cpfRequisitor;
	}
	public String getNascimentoRequisitor() {
		return nascimentoRequisitor;
	}
	public void setNascimentoRequisitor(String nascimentoRequisitor) {
		this.nascimentoRequisitor = nascimentoRequisitor;
	}
	public String getTelefoneRequisitor() {
		return telefoneRequisitor;
	}
	public void setTelefoneRequisitor(String telefoneRequisitor) {
		this.telefoneRequisitor = telefoneRequisitor;
	}
	public String getValorPrecificadoRegistro() {
		return valorPrecificadoRegistro;
	}
	public void setValorPrecificadoRegistro(String valorPrecificadoRegistro) {
		this.valorPrecificadoRegistro = valorPrecificadoRegistro;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	

}
