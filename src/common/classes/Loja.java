package common.classes;

import java.util.ArrayList;

import common.interfaces.IAdmin;
import common.listas.ListaLivros;
import common.listas.ListaPedidos;
import common.listas.ListaUsuarios;
import external.Menu;

public class Loja {
	
	private Usuario user;
	private ListaLivros livros = new ListaLivros();
	private ListaPedidos pedidos = new ListaPedidos();
	private ListaUsuarios listaUsuarios;
	
	public Loja(ListaUsuarios lista, Usuario usuario) {
		super();
		this.user = usuario;
		this.listaUsuarios = lista;
	}

	
	public void drawMenu(){ArrayList<String> opcoesArray = new ArrayList<String>();
	opcoesArray.add("1");
	opcoesArray.add("Procurar livros");
	opcoesArray.add("2");
	opcoesArray.add("Adicionar Livros ao carrinho"); 
	opcoesArray.add("3");
	opcoesArray.add("Listar livros do carrinho");
	opcoesArray.add("4");
	opcoesArray.add("Remover livros do carrinho");
	opcoesArray.add("5");
	opcoesArray.add("Fechar pedido");
	if (user instanceof IAdmin) {
		opcoesArray.add("6");
		opcoesArray.add("Adicionar livro ao estoque");
		opcoesArray.add("7");
		opcoesArray.add("Remover livro do estoque");
		opcoesArray.add("8");
		opcoesArray.add("Listar Livros");
		opcoesArray.add("9");
		opcoesArray.add("Listar Pedidos");
		opcoesArray.add("10");
		opcoesArray.add("Listar Clientes");
	}

	opcoesArray.add("0");
	opcoesArray.add("Sair");
	String[] opcoesDoMenu = new String[opcoesArray.size()];
	opcoesDoMenu = opcoesArray.toArray(opcoesDoMenu);
	Menu menu = new Menu(opcoesDoMenu);
	
	do{
		menu.drawMenu();
		switch(menu.getInput()){
		case 0:
			return;
		case 1:
			user.escolheLivro(livros.getLista());
			break;
		case 2:
			user.addLivro(livros.getLista());
			break;
		case 3:
			user.veCarrinho();
			break;
		case 4:
			user.delLivro();
			break;
		case 5:
			pedidos.addPedido(user.fechaPedido());
			user.limpaCarrinho();
			break;
		case 6:
			if(user instanceof IAdmin)
				((IAdmin) user).criaLivro(livros);
			break;
		case 7: 
			if(user instanceof IAdmin)
				((IAdmin) user).delLivro(livros);
			break;
		case 8:
			if(user instanceof IAdmin)
				((IAdmin) user).listaLivros(livros);
			break;
		case 9:
			if(user instanceof IAdmin)
				((IAdmin) user).listaPedidos(pedidos);
			break;
		case 10:
			if(user instanceof IAdmin)
				((IAdmin) user).listaClientes(listaUsuarios);
			break;			
		}
	}while(true);

	}
	
	
	private void teste(){
		livros.addLivro(new Livro("Autor1", "Titulo1", 1F));
		livros.addLivro(new Livro("Autor2", "Titulo2", 2F));
		livros.addLivro(new Livro("Autor3", "Titulo3", 3F));
		livros.addLivro(new Livro("Autor4", "Titulo4", 4F));
	}
}
