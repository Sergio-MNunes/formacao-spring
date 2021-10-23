package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Banco {
	private static List<Empresa> empresas = new ArrayList<Empresa>();
	
	static {
		Empresa emp1 = new Empresa("Alura", "2001-01-01");
		Empresa emp2 = new Empresa("Santander", "2005-07-28");
		
		Banco banco = new Banco();
		
		banco.add(emp1);
		banco.add(emp2);
	}

	public void add(Empresa emp) {
		this.empresas.add(emp);
	}
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void remove(int id) {
		
//		O for abaixo daria um erro interno, pois nao podemos modificar a lista (deletar um item) e percorre-la ao mesmo tempo.
//		Por conta disso, tomaremos um ConcurrentModificationException (afinal, estamos alterando E percorrendo simultaneamente).
//		for (Empresa empresa : empresas) {
//			if (empresa.getId() == id) {
//				empresas.remove(empresa);
//			}
//		}
		
//		O jeito correto a se fazer isso eh:
		Iterator<Empresa> it = empresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if (id == emp.getId()) {
				it.remove();
			}
		}
	}

	public Empresa busca(int id) {

		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		throw new NoSuchElementException("Id nao encontrado.");	
	}
}
