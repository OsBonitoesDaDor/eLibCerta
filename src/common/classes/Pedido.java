package common.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements  Serializable{
	private Usuario u;
	private ArrayList<Livro> carrinho;
	public Pedido (Usuario u, ArrayList<Livro> carrinho){
		this.u = u;
		this.carrinho = carrinho;
	}
	
	
}
