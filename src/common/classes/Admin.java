package common.classes;

import common.interfaces.IAdmin;
import common.listas.ListaLivros;

public class Admin extends Usuario implements IAdmin{

	public Admin(String nome, String email, int id, String senha) {
		super(nome, email, id, senha);
	}



}
