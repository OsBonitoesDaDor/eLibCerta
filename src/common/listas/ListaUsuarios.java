package common.listas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

import common.classes.Admin;
import common.classes.Usuario;
import external.Utils;

public class ListaUsuarios implements Serializable {

	//TODO: PEGAR O ULTIMO ID, QUADO O PROGRAMA REINICIA ELE COMECA A CONTAGEM DE NOVO
	
	private static final long serialVersionUID = 1L;

	private static int id = 0;

	private ListaGenerica<Usuario> lista = new ListaGenerica<>();
	
	private transient Scanner scan = new Scanner(System.in);

	public ListaUsuarios() {
		id = 0;
	}

	public void addUsuario() {
		String userName, email, input = null, senha;
		Usuario newUser;
		boolean isAdmin = false;
		ArrayList<Usuario> usuarios =(ArrayList<Usuario>) 
				lista.getLista(Utils.getUsersFilePath());
		
		System.out.println("Qual o nome do usuario? ");
		userName = scan.nextLine();
		System.out.println("Qual o EMAIL do usuario? ");
		email = scan.nextLine();
		System.out.println("O usuario eh admin? (S/N)");
		input  = scan.nextLine();
		if(Utils.isStringEqual(input, "s")){
			isAdmin = true;
		}
		if (usuarios != null) {
			// Checa se o nome do usuario esta disponivel
			for (Usuario u : usuarios) {
				if (Utils.isStringEqual(u.getNome(), userName)) {
					System.out.println("Esse usuario ja existe, tente novamente!");
					return;
				}
			}

			// Checa se o EMAIL esta disponivel e
			for (Usuario u : usuarios) {
				if (Utils.isStringEqual(u.getEmail(), email)) {
					System.out.println("Esse EMAIL ja esta cadastrado, tente novamente!");
					return;
				}
			}
		}
		System.out.println("Qual a senha do usuario? ");
		senha = scan.nextLine();
		
		if(isAdmin)
			newUser = new Admin(userName, email, id, senha);
		else
			newUser = new Usuario(userName, email, id, senha);
		System.out.println("User: " + newUser);
		usuarios.add(newUser);
		id++;
		lista.saveLista(usuarios, Utils.getUsersFilePath());
	}

	public void mostraUsuarios() {
		for (Usuario u : lista.getLista(Utils.getUsersFilePath())) {
			System.out.println(u);
		}
	
	}

	public void delUsuario() {
		String tag;
		ArrayList<Usuario> usuarios = lista.getLista(Utils.getUsersFilePath());
		ArrayList<Usuario> delUsers = lista.getLista(Utils.getDelUsersFilePath());
		System.out.println("Qual usuario deseja excluir? ");
		tag = scan.nextLine();
		Usuario u = null;
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

	public ArrayList<Usuario> getLista(){
		return lista.getLista(Utils.getUsersFilePath());
	}

}
