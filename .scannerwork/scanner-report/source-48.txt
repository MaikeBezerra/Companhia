package br.ufc.qxd.persistencia.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pesquisadores_projetos")
public class PesquisadoresProjetos implements Bean{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="horas_id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Pesquisador pesquisador;
	
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;
	
	@Column(name = "horas_trabalhadas")
	private int horas;
	
	public PesquisadoresProjetos(){}
	
	public PesquisadoresProjetos(Pesquisador pesquisador, Projeto projeto, int horas) {
		this(0, pesquisador, projeto, horas);
	}

	public PesquisadoresProjetos(int id, Pesquisador pesquisador, Projeto projeto, int horas) {
		this.id = id;
		this.pesquisador = pesquisador;
		this.projeto = projeto;
		this.horas = horas;
	}
	
	public Pesquisador getPesquisador() {
		return pesquisador;
	}

	public void setPesquisador(Pesquisador pesquisador) {
		this.pesquisador = pesquisador;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
}
