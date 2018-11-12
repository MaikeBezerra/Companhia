package br.ufc.qxd.persistencia.bean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
	@NamedQuery(name="Funcionario.findByName", query="select f from Funcionario f where f.nome = :nome")
})
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tipo_funcionario", discriminatorType=DiscriminatorType.STRING, length = 1)
@DiscriminatorValue("F")
public class Funcionario implements Bean{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "funcionario_id")
	private int id;
	private String nome;
	
	@OneToOne
	@JoinColumn(name="endereco_id", unique=true, nullable=false, updatable=false)
	private Endereco endereco;
	private char sexo;
	private Calendar dataNascimento;
	private double salario;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable=false)
	private Departamento departamento;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="funcionario")
	private List<Dependente> dependentes;
	
	public Funcionario(){}
	
	public Funcionario(String nome, Endereco endereco, char sexo, Calendar dataNascimento, 
							double salario, Departamento departamento){
		this(0, nome, endereco, sexo, dataNascimento, salario, departamento);
	}
	
	public Funcionario(int id, String nome, Endereco endereco, char sexo, Calendar dataNascimento, 
			double salario, Departamento departamento){
		this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
		this.departamento = departamento;
		this.dependentes = new ArrayList<>();
	
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
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}

	@SuppressWarnings("deprecation")
	public String getDate(){
		java.sql.Date dataNasc = new java.sql.Date(
		        this.getDataNascimento().getTimeInMillis());
		return dataNasc.getDate() + "/" + (dataNasc.getMonth() + 1) + "/" + (dataNasc.getYear() + 1900);
	}
}
