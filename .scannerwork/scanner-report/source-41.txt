package br.ufc.qxd.persistencia.bean;

public class FuncionarioFactory {
	
	public Funcionario criaFuncionario(String tipo, String cargo, 
									int jornada, String area, String grau){
		Funcionario funcionario;
		
		switch (tipo) {
		
		case "Funcionario":
			funcionario = new Funcionario();
			break;
		case "Pesquisador":
			funcionario = new Pesquisador(area);
			break;
		case "Secretario":
			funcionario = new Secretario(grau);
			break;
		case "Limpeza":
			funcionario = new Limpeza(cargo, jornada);
			break;
		default:
			funcionario = null;
			break;
		}
		return funcionario;
	}
}
