package listen.lib;

public class Log{
	public Log(String mess){
		System.out.println(mess);
	}
	/* методы static могут быть вызваны без создания экземпляра */
	public static void pr(String mess){
		System.out.print(mess);
	}
	public static void ln(String mess){
		System.out.println(mess);
	}
	public static void line(String mess){
		System.out.println(mess);
	}
	public static void printf(String param, Object[] list){
		System.out.printf(param, list);
	}
	public static void f(String param, Object[] list){
		System.out.printf(param, list);
	}
}