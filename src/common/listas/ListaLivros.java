package common.listas;

import java.io.Serializable;
import java.util.ArrayList;

import common.classes.Livro;
import external.Utils;

public class ListaLivros implements Serializable {

	//TODO: PEGAR O ULTIMO ID, QUADO O PROGRAMA REINICIA ELE COMECA A CONTAGEM DE NOVO
	
	private static final long serialVersionUID = 1L;

	private ListaGenerica<Livro> lista = new ListaGenerica<>();
	

	public ListaLivros() {
	}

	public void addLivro(Livro l) {
		ArrayList<Livro> livros = lista.getLista(Utils.getLivrosFilePath());
		livros.add(l);
		lista.saveLista(livros, Utils.getLivrosFilePath());
	}

	public void mostraLivros() {
		for (Livro u : lista.getLista(Utils.getLivrosFilePath())) {
			System.out.println(u);
		}
	
	}

	public void removeLivro(Livro l){
		ArrayList<Livro> livros = lista.getLista(Utils.getLivrosFilePath());
		for (Livro livro : livros) {
			if(Utils.isStringEqual(l.getAutor(), livro.getAutor()) && Utils.isStringEqual(l.getTitulo(), livro.getTitulo())){
				livros.remove(livro);
				break;
			}
		}
		lista.saveLista(livros, Utils.getLivrosFilePath());
	}
	
	/**
	public void delUsuario() {
		String tag;
		ArrayList<UsuarioGenerico> usuarios = lista.getLista(Utils.getUsersFilePath());
		ArrayList<UsuarioGenerico> delUsers = lista.getLista(Utils.getDelUsersFilePath());
		System.out.println("Qual usuario deseja excluir? ");
		tag = scan.nextLine();
		UsuarioGenerico u = null;
		// Encontra quem é o usuario
		if (Utils.isInteger(tag)) {
			u = usuarios.get(Integer.parseInt(tag));
			usuarios.remove(Integer.parseInt(tag));
		} else {
			for (int i = 0; i < usuarios.size(); i++) {
				if (Utils.isStringEqual(tag, usuarios.get(i).getNome())) {
					u = usuarios.get(i);
					usuarios.remove(i);
					break;
				}
			}
		}

		if (u == null) {
			System.out.println("Usuario nao encontrado!");
			return;
		}
		delUsers.add(u);
		lista.saveLista(delUsers, Utils.getDelUsersFilePath());
		lista.saveLista(usuarios, Utils.getUsersFilePath());

	}
*/
	public ArrayList<Livro> getLista(){
		return lista.getLista(Utils.getLivrosFilePath());
	}


}
