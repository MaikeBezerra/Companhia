package br.ufc.qxd.persistencia.bean;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name="Limpeza.findByName", query="select l from Limpeza l where l.nome = :nome")
})
@DiscriminatorValue("L")
public class Limpeza extends Funcionario {

	private String cargo;
	private int jornada;
	
	@ManyToOne
	@JoinColumn(name = "supervisor_id", insertable = true, updatable = true, nullable = true)
	private Limpeza supervisor;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="supervisor")
	private List<Limpeza> supervisionados;
	
	public Limpeza(){}
	
	public Limpeza(String nome, Endereco endereco, char sexo, Calendar dataNascimento, 
			double salario, Departamento departamento,
			String cargo, int jornada, Limpeza supervisor){
		this(0, nome, endereco, sexo, dataNascimento, salario, departamento, cargo, jornada, supervisor);
	}
	
	public Limpeza(int id, String nome, Endereco endereco, char sexo, Calendar dataNascimento, 
			double salario, Departamento departamento,
			String cargo, int jornada, Limpeza supervisor){
		
		super(id, nome, endereco, sexo, dataNascimento, salario, departamento);
		this.cargo = cargo;
		this.jornada = jornada;
		this.supervisor = supervisor;
		this.supervisionados = new ArrayList<>();
	}
	
	public Limpeza(String cargo, int jornada){
		this.cargo = cargo;
		this.jornada = jornada;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getJornada() {
		return jornada;
	}

	public void setJornada(int jornada) {
		this.jornada = jornada;
	}

	public Limpeza getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Limpeza supervisor) {
		this.supervisor = supervisor;
	}
	
	public List<Limpeza> getSupervionados(){
		return this.supervisionados;
	}
	
	public void setSupervionados( List<Limpeza> supervisionados){
		this.supervisionados = supervisionados;
	}


}
