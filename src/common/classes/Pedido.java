package common.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Pedido implements Serializable {
	private Usuario u;
	private ArrayList<Livro> carrinho;
	private GregorianCalendar data;

	public Pedido(Usuario u, ArrayList<Livro> carrinho, GregorianCalendar data) {
		this.u = u;
		this.carrinho = carrinho;
		this.data = data;
	}

	@Override
	public String toString() {

		return String.format(
				"Pedido feito em %d/%d/%d:\n\tUsuario: \n\t\t%s\n\t\tPeiddo: %s",
				data.get(GregorianCalendar.DAY_OF_MONTH),
				data.get(GregorianCalendar.MONTH),
				data.get(GregorianCalendar.YEAR), u, carrinho);
	}

}
