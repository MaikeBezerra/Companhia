package br.ufc.qxd.persistencia.bean;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	@NamedQuery(name="Departamento.findByName", query="select d from Departamento d where d.nome = :nome"),
	@NamedQuery(name="Departamento.findAllName", query="select d.nome from Departamento d")
})
public class Departamento implements Bean{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="departamento_id")
	private int id;
	@javax.validation.constraints.NotEmpty
	@NotNull
	private String nome;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departamento")
	private List<Projeto> projetos;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="departamento")
	private List<Funcionario> funcionarios;
	
	public Departamento(){ }
	
	public Departamento(String nome){ 
		this(0, nome);
	}
	
	public Departamento(int id, String nome){
		this.id = id;
		this.nome = nome;
		this.projetos = new ArrayList<>();
		this.funcionarios = new ArrayList<>();
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
	public List<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}
