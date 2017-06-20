package common;

import java.util.Scanner;

import common.classes.Loja;
import common.classes.Usuario;
import common.listas.ListaUsuarios;
import external.Menu;
import external.Utils;

public class Main {
	
	private static final String[] opMenu = {"1", "Cadastrar Cliente", "2", "Ir a loja", "3", "AAA", "0", "Sair"};
	private static final Menu menu = new Menu(opMenu);

	private static ListaUsuarios users = new ListaUsuarios();
	
	private static Scanner scan = new Scanner(System.in);
			
	public static void main(String args[]){
		do{
			menu.drawMenu();
			switch(menu.getInput()){
			case 0:
				return;
			case 1:
				users.addUsuario();
				break;
			case 2:
				loja();
				break;
			case 3:
				users.mostraUsuarios();
				break;
			}
		}while(true);
	}
	
	private static void mostraAll(){
		for (Usuario u : users.getLista()) {
			System.out.println(u);
		}
	}
	
	private static void addUser(){
		users.addUsuario();
	}
	
	private static void loja(){
		String nome, pass;
		Usuario user = null;
		System.out.println("Qual o nome do usuario? ");
		nome = scan.nextLine();
		for (Usuario u : users.getLista()) {
			if(Utils.isStringEqual(nome, u.getNome())){
				user = u;
				break;
			}
		}
		if(user == null){
			System.out.println("Nome de usuario nao encontrado, tente novamente!");
			return;
		}
		
		System.out.println("Entre com a senha: ");
		pass = scan.nextLine();
		if(!Utils.isStringEqual(pass, user.getSenha())){
			System.out.println("Senha incorreta, tente novamente");
			return;
		}
		
		System.out.println("Bem vindo, " + user.getNome());
		Loja l = new Loja(users, user);
		l.drawMenu();
	}
}
