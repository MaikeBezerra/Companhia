package br.ufc.qxd.persistencia.bean;
import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("S")
public class Secretario extends Funcionario {

	private String grau;

	public Secretario(){}
	
	public Secretario(String nome, Endereco endereco, char sexo, Calendar dataNascimento, 
			double salario, Departamento departamento,
			String grau){
		
		super(nome, endereco, sexo, dataNascimento, salario, departamento);
		this.grau = grau;
	}
	
	public Secretario(String grau){
		this.grau = grau;
	}
	
	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

}
