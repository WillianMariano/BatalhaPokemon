package br.computação.model;

public class pokemon {
	private String nome;
	private int hp;
	private int at;

	public pokemon() {
	}

	public pokemon(String nome, int hp, int at) {
		super();
		this.nome=nome;
		this.hp=hp;
		this.at=at;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public int gethp() {
		return hp;
	}
	public void sethp(int hp) {
		this.hp = hp;
	}

	public int getat() {
		return at;
	}
	public void setat(int at) {
		this.at = at;
	}
}
