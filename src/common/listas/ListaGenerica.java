package common.listas;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import external.Utils;


public class ListaGenerica<T>{
	@SuppressWarnings("unused")
	private T tipo;
	
	private ObjectInputStream entr;
	private ObjectOutputStream saida;
	
	@SuppressWarnings("unchecked")
	public ArrayList<T> getLista(String path){
		ArrayList<T> lista = null;
		try {
			entr = new ObjectInputStream(new FileInputStream(path));
			lista = (ArrayList<T>) entr.readObject();
		} catch(FileNotFoundException e){
			//e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
			//System.out.println("Erro ao ler o arquivo!");
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
		}finally {
			try {
				entr.close();
			} catch (IOException e) {
				System.out.println(e);
			} catch (NullPointerException e) {
				System.out.println(e);
			}
		}
		if (lista == null)
			return new ArrayList<T>();

		return lista;
	}

	public void saveLista(ArrayList<T> lista, String path){
		try{
			saida = new ObjectOutputStream(new FileOutputStream(path));
			saida.writeObject(lista);
		}catch(IOException e){
			
		}finally{
			try{
				saida.close();
			}catch(IOException e){
				
			}
		}
	}

	public void saveObject(T t, String path){
		try{
			saida = new ObjectOutputStream(new FileOutputStream(Utils.getUsersFilePath()));
			saida.writeObject(t);
		}catch(IOException e){
			
		}finally{
			try{
				saida.close();
			}catch(IOException e){
				
			}
		}
	}

}
