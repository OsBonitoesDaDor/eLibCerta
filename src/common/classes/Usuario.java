package common.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import common.interfaces.IAdmin;
import common.interfaces.IUser;
import external.Utils;

public class Usuario implements IUser, Serializable{
	private String nome, email, senha;
	private int id;
	private ArrayList<Livro> carrinho;
	public Usuario(String nome, String email, int id, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.id = id;
		carrinho = new ArrayList<Livro>();
	}
	

	public void limpaCarrinho() {
		carrinho = new ArrayList<Livro>();
	}


	@Override
	public void addLivro(ArrayList<Livro> lista) {
		Livro l = this.escolheLivro(lista);
		carrinho.add(l);
	}


	@Override
	public Livro escolheLivro(ArrayList<Livro> lista) {
		int index = 0;
		Scanner scan = new Scanner(System.in);
		String tag;
		ArrayList<Livro> matches;
		Livro res;
		System.out.println("Livros disponiveis: ");
		for (Livro livro : lista) {
			index++;
			System.out.println(index + " -> " + livro);
		}
		System.out.println("Sua busca: ");
		tag = scan.nextLine();
		if(Utils.isInteger(tag)){
			res = lista.get(Integer.parseInt(tag) - 1);
			return res;
		}else{
			matches = new ArrayList<Livro>();
			for (Livro livro : lista) {
				if(livro.getAutor().toLowerCase().contains(tag.toLowerCase()) || livro.getTitulo().toLowerCase().contains(tag.toLowerCase()))
					matches.add(livro);
			}
		}
		
		if(matches.isEmpty() || matches == null){
			System.out.println("Livro nao encontrado, tente novamente!");
			return null;
		}
		
		if(matches.size() == 1){
			res = matches.get(0);
			return res;
		}
		
		System.out.println("Multiplas referencias foram encontradas, mas filtramos sua busca! Tente de novo :)");
		return escolheLivro(matches);
		
	}

	@Override
	public void veCarrinho() {
		if(!carrinho.isEmpty()){
			for (Livro livro : carrinho) {
				System.out.println(livro);
			}
		}else
			System.out.println("Carrinho vazio :(");
		
	}

	@Override
	public void delLivro() {
		Livro l = this.escolheLivro(carrinho);
		carrinho.remove(l);		
	}

	@Override
	public Pedido fechaPedido() {
		return new Pedido(this, carrinho);
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
	
	
	@Override
	public String toString() {
		return "ID: " + id + " => " + "Nome: " + this.nome + "\tEmail: " + this.email + "\tStatus: "
				+ (this instanceof IAdmin ? " Administrador" : " Cliente");
	}


}
