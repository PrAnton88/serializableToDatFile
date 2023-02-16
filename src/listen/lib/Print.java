package listen.lib;

import listen.lib.person.*;

public class Print{
	public Print(String mess){
		System.out.print(mess);
	}
	private static void print(boolean ln, Object ...list){
		if(list.length > 0){
			for(Object item: list){
				if(ln) System.out.println(item);
				else System.out.print(item);
			}
		}else{
			if(ln) System.out.println("");
			else System.out.print("");
		}
	}
	public static void c(Object ...list){
		print(false, list);
	}
	public static void ln(Object ...list){
		print(true, list);
	}
	public static void f(String param, Object ...list){
		System.out.printf(param, list);
	}
	
}