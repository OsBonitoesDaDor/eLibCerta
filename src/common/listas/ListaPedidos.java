package common.listas;

import java.util.ArrayList;

import common.classes.Pedido;
import external.Utils;

public class ListaPedidos {
	
	private ListaGenerica<Pedido> lista = new ListaGenerica<>();
	
	public void addPedido(Pedido p){
		ArrayList<Pedido> l = lista.getLista(Utils.getPedidosFilePath());
		l.add(p);
		lista.saveLista(l, Utils.getPedidosFilePath());
	}

	public ArrayList<Pedido> getLista(){
		return lista.getLista(Utils.getPedidosFilePath());
	}

	public void listaPedidos(){
		for (Pedido p : this.getLista()) {
			System.out.println(p);
		}
	}
	
}
