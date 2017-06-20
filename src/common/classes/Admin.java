package common.classes;

import java.util.ArrayList;
import java.util.Scanner;

import common.interfaces.IAdmin;
import common.listas.ListaLivros;
import common.listas.ListaPedidos;
import common.listas.ListaUsuarios;
import external.Utils;

public class Admin extends Usuario implements IAdmin{

	public Admin(String nome, String email, int id, String senha) {
		super(nome, email, id, senha);
	}

	
	@Override
	public void criaLivro(ListaLivros lista) {
		Livro res = criaLivro(lista.getLista());
		if(res == null)
			return;
		lista.addLivro(res);
	}

	
	private Livro criaLivro(ArrayList<Livro> lista){
		String nome;
		String autor = "";
		float preco = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual o nome do autor? ");
		nome = scan.nextLine();
		System.out.println("Qual o titulo da obra? ");
		autor = scan.nextLine();
		
		if(nome.equals("")){
			System.out.println("Nome mal inserido, tente novamente");
			return null;
		}
		
		if(autor.equals("")){
			System.out.println("Autor mal inserido, tente novamente");
			return null;
		}
		
		for (Livro livro : lista) {
			if(Utils.isStringEqual(livro.getAutor(), autor) && Utils.isStringEqual(livro.getTitulo(), nome)){
				System.out.println("Livro ja cadastrado, tente novamente!");
				return null;
			}
		}
		
		System.out.println("Qual o preco? ");
		preco = scan.nextFloat();
		
		if(preco <= 0){
			System.out.println("Preco mal inserido");
			return null;
		}
		return new Livro(autor, nome, preco);		
	}


	
	@Override
	public void delLivro(ListaLivros lista) {
		Livro l = super.escolheLivro(lista.getLista());
		lista.removeLivro(l);		
	}


	@Override
	public void listaLivros(ListaLivros lista) {
		for (Livro l : lista.getLista()) {
			System.out.println(l);
		}
		
	}


	@Override
	public void listaPedidos(ListaPedidos lista) {
		for (Pedido  p : lista.getLista()) {
			System.out.println(p);
		}
	}


	@Override
	public void listaClientes(ListaUsuarios lista) {
		for (Usuario u : lista.getLista()) {
			System.out.println(u);
		}
		
	}


}
