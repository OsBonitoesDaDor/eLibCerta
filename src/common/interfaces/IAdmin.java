package common.interfaces;

import common.listas.ListaLivros;
import common.listas.ListaPedidos;
import common.listas.ListaUsuarios;

public interface IAdmin {
	/**
	 * Adiciona livro ao estoque
	 */
	public void criaLivro(ListaLivros lista);
	public void delLivro(ListaLivros lista);
	public void listaLivros(ListaLivros lista);
	public void listaPedidos(ListaPedidos lista);
	public void listaClientes(ListaUsuarios lista);

}
