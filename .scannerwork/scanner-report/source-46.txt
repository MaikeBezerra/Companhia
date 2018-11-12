package br.ufc.qxd.persistencia.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Endereco implements Bean{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private int id;
	
	private String rua;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	
	@OneToOne(mappedBy="endereco")
	private Funcionario funcionario;
	
	public Endereco(){}
	
	public Endereco(String rua, int numero, String bairro, String cidade, String estado, Funcionario funcionario){
		this(0, rua, numero, bairro, cidade, estado, funcionario);
	}
	
	public Endereco(int id, String rua, int numero, String bairro, String cidade, 
											String estado, Funcionario funcionario){
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.funcionario = funcionario;
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
