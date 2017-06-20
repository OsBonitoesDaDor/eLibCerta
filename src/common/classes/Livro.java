package common.classes;

import java.io.Serializable;

public class Livro implements  Serializable{
	private String autor, titulo;
	private float preco;
	public Livro(String autor, String titulo, float preco) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.preco = preco;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	@Override
	public String toString(){
		return "Titulo: " + this.getTitulo() + "\tAutor: " + this.getAutor() + "\tPreco: " + this.getPreco();
	}
	
}
