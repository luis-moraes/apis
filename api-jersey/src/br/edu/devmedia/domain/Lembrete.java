package br.edu.devmedia.domain;

public class Lembrete {

	private int id;
	private String titulo;
	private String descricao;
	
	public Lembrete() { }
	
	public Lembrete(int id, String titulo, String descricao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
	}
	
	public Lembrete(Lembrete lembrete){
		this(lembrete.getId(), lembrete.titulo, lembrete.descricao);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
