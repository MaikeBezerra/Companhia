package br.ufc.qxd.persistencia.bean;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name="Dependente.findByName", query="select d from Dependente d where d.nome = :nome"),
	@NamedQuery(name="Dependente.findAllName", query="select d.nome from Dependente d "
													+ "where d.funcionario.id = :id")
	
})
public class Dependente implements Bean{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dependente_id")
	private int id;
	
	@NotEmpty
	@NotNull
	private String nome;
	private char sexo;
	private Calendar dataNascimento;
	private String parentesco;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id", referencedColumnName="funcionario_id", nullable=false)
	private Funcionario funcionario;
	
	public Dependente() {}
	
	public Dependente(String nome, char sexo, Calendar dataNascimento, Funcionario responsavel, String parentesco) {
		this(0, nome, sexo, dataNascimento, responsavel, parentesco);
	}
	
	public Dependente(int id, String nome, char sexo, Calendar dataNascimento, 
								Funcionario responsavel, String parentesco){
		this.id = id;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.funcionario = responsavel;
		this.parentesco = parentesco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public Funcionario getResponsavel() {
		return funcionario;
	}
	public void setMantedores(Funcionario responsavel) {
		this.funcionario = responsavel;
	}
	
	@SuppressWarnings("deprecation")
	public String getDate(){
		java.sql.Date dataNasc = new java.sql.Date(
		        this.getDataNascimento().getTimeInMillis());
		return dataNasc.getDate() + "/" + (dataNasc.getMonth() + 1) + "/" + (dataNasc.getYear() + 1900);
	}

}
