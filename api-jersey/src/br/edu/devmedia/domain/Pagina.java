package br.edu.devmedia.domain;

import java.util.List;

public class Pagina {

	private List<Lembrete> dados;
	
	public Pagina(){ }
	
	public Pagina(List<Lembrete> dados){
		this.dados = dados;
	}

	public List<Lembrete> getDados() {
		return dados;
	}

	public void setDados(List<Lembrete> dados) {
		this.dados = dados;
	}
}
