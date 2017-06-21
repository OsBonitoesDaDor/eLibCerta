package common.listas;

import java.io.Serializable;
import java.util.ArrayList;

import common.classes.Livro;
import external.Utils;

public class ListaLivros implements Serializable {

	//TODO: PEGAR O ULTIMO ID, QUADO O PROGRAMA REINICIA ELE COMECA A CONTAGEM DE NOVO
	
	private static final long serialVersionUID = 1L;

	private ListaGenerica<Livro> lista = new ListaGenerica<>();

	
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
	
	public ArrayList<Livro> getLista(){
		return lista.getLista(Utils.getLivrosFilePath());
	}


}
