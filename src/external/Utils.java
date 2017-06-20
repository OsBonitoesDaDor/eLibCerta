package external;

import java.io.File;

public class Utils {

	public static boolean isStringEqual(String str1, String str2){
		if(str1.equals("") || str2.equals("") || str1.equals(null) || str2.equals(null))
			return false;
		return str1.toLowerCase().equals(str2.toLowerCase());
	}
	
	public static boolean isInteger(String s){
		for (char c : s.toCharArray()) {
			if(c < '0' || c > '9')
				return false;
		}
		return true;
	}

	public static String getAbsPath(){
		final File f = new File("res\\");
		return f.getAbsolutePath();
	}
	
	public static String getUsersFilePath(){
		return getAbsPath() + "\\activeUsers.dat";
	}
	
	public static String getDelUsersFilePath(){
		return getAbsPath() + "\\deletedUsers.dat";
	}
	
	
	public static String getPedidosFilePath(){
		return getAbsPath() + "\\pedidos.dat";
	}

	public static String getLivrosFilePath() {
		return getAbsPath() + "\\livros.dat";
	}
}
