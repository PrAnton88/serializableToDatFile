package listen.book;

public interface Printable{
	void print();
	
	static void test(String mess){
		
		
		
		if(mess.length() == 0){
			//System.out.println(" mess not found ");
			mess = new String(" this is test method interface ");
			
		}
		
		System.out.println(mess);
	}
}