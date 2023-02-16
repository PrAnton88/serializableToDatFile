package listen.lib;

import listen.lib.person.*;

public class TestGenericsInterface<T extends MethodPerson>{
	
	private T obj;
	private T obj1;
	
	public TestGenericsInterface(){}
	
	public void testHi(T obj){
		obj.Hi();
	}
	
	/* тут E - только не тип интерфейса
	public<E> void testHi1(E obj1){
		obj1.Hi();
	}
	*/
	
}