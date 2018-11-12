package br.ufc.qxd.persistencia.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Projeto.findByName", query="select p from Projeto p where p.nome = :nome")
})
public class Projeto implements Bean{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="projeto_id")
	private int id;
	private String nome;
	private int periodo;
	
	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable=false)
	private Departamento departamento;
	
	@OneToMany(mappedBy="projeto")
	private Set<PesquisadoresProjetos> pesquisadoresProjetos = new HashSet<PesquisadoresProjetos>();
	
	public Projeto(){}
	
	public Projeto(String nome, int periodo, Departamento departamento){
		this(0, nome, periodo, departamento);
	}
	
	public Projeto(int id, String nome, int periodo, Departamento departamento){
		this.id = id;
		this.nome = nome;
		this.periodo = periodo;
		this.departamento = departamento;
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
	
	public int getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<PesquisadoresProjetos> getPesquisadoresProjetos() {
		return pesquisadoresProjetos;
	}

	public void setPesquisadoresProjetos(Set<PesquisadoresProjetos> pesquisadoresProjetos) {
		this.pesquisadoresProjetos = pesquisadoresProjetos;
	}
	

}
