package common.interfaces;

import java.util.ArrayList;

import common.classes.Livro;
import common.classes.Pedido;

public interface IUser {
	public void addLivro(ArrayList<Livro> lista);
	public void veCarrinho();
	public void delLivro();
	public Pedido fechaPedido();
	
	public Livro escolheLivro(ArrayList<Livro> lista);
}
