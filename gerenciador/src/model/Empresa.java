package model;

public class Empresa {

	private static int geradorIds;
	private int id;
	private String nome;
	private String data;
	
	public Empresa (String nome, String data) {
		this.id = ++geradorIds;
		this.nome = nome;
		this.data = data;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public int getId() {
		return id;
	}
}
