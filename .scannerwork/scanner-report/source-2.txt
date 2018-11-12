package br.ufc.qxd.persistencia;

import br.ufc.qxd.persistencia.bean.Pesquisador;
import br.ufc.qxd.persistencia.bean.Projeto;
import br.ufc.qxd.persistencia.dao.impl.PesquisadorJPADAO;
import br.ufc.qxd.persistencia.dao.impl.ProjetoJPADAO;

public class Test {
	
	public static void main(String[] args) {
		
		PesquisadorJPADAO pesqDAO = new PesquisadorJPADAO();
		ProjetoJPADAO projDAO = new ProjetoJPADAO(); 
		//HoraJPADAO horaDAO = new HoraJPADAO();
		
//		LimpezaJPADAO limpDAO = new LimpezaJPADAO();
//		FuncionarioJPADAO funcDAO = new FuncionarioJPADAO();
		
//		Pesquisador pesq = pesqDAO.find(2);
		Pesquisador pesq2 = pesqDAO.find(9);
		Pesquisador pesq3 = pesqDAO.find(11);
//		
		Projeto proj = projDAO.find(1);
//		
//		projDAO.beginTransaction();
//		proj.getPesquisador().add(pesq);
//		proj.getPesquisador().add(pesq2);
//		proj.getPesquisador().add(pesq3);
//		projDAO.commit();
//		projDAO.close();
//		pesqDAO.close();
		
//		Funcionario func = funcDAO.find(2);
//		System.out.println(func.getNome());
//		Limpeza limp = limpDAO.find(4);
//		
////		limpDAO.beginTransaction();
//		funcDAO.beginTransaction();
//		func.setSupervisionado(limp);
////		limp.setSupervisor(func);
////		limpDAO.commit();
//		funcDAO.commit();
//		limpDAO.close();
//		funcDAO.close();
		
		
		
	}
}
