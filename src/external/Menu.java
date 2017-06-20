package external;

import java.util.ArrayList;
import java.util.Scanner;

//Menuzinho modular pra nois da show
public class Menu {
	ArrayList<Item> itens = new ArrayList<Item>();
	Item item;
	Scanner scan = new Scanner(System.in);
	//Classe interna pra cada item
	private class Item{
		private int id;
		private String tag;
		
		public Item(int id, String tag){
			this.id = id;
			this.tag = tag;
		}
				
		public int getId(){
			return this.id;
		}
		
		public String getTag(){
			return this.tag;
		}
	}	

	/**
	 *  Construtor do menu
	 * @param itens padrao: opcao, descricao
	 */
	public Menu(String[] itens){
		int id = -1;
		String tag = null;
		
		for (int i = 0; i < itens.length; i ++) {
			if(i % 2 == 0)
				id = Integer.parseInt(itens[i]);
			else
				tag = itens[i];
			if(id != -1 && tag != null){
				this.itens.add(new Item(id, tag));
				id = -1;tag = null;
			}
		}
	}
	
	/**
	 * Desenha o menu, que nao pode ser nulo!
	 */	
	public void drawMenu(){
		Item item;
		StringBuilder texto  = new StringBuilder();
		System.out.println("Escolha uma opcao: \n");
		for (int i = 0; i < itens.size(); i++) {
			item = itens.get(i);
			texto.append(item.getId() + " -> " + item.getTag());
			System.out.println(texto.toString());
			texto = new StringBuilder();
		}	
	}

	public int getInput(){
		return scan.nextInt();
	}
}


