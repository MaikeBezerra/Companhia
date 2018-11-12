package br.ufc.qxd.persistencia.bean;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Pesquisador.findByName", query="select p from Pesquisador p where p.nome = :nome")
})
@DiscriminatorValue("P")
public class Pesquisador extends Funcionario {

	private String area;
	
	@OneToMany(mappedBy="pesquisador")
	private Set<PesquisadoresProjetos> pesquisadoresProjetos = new HashSet<PesquisadoresProjetos>();

	public Pesquisador(){}
	
	public Pesquisador(String nome, Endereco endereco, char sexo, Calendar dataNascimento, 
										double salario, Departamento departamento, 
										String area){
		super(nome, endereco, sexo, dataNascimento, salario, departamento);
		this.area = area;
	}
	
	public Pesquisador(String area){
		this.area = area;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
		
}
