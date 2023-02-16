package listen.lib.listType;

import listen.lib.listType.BaseType;

public class Type<T> implements BaseType<T>{
	
	public T val;
	
	public Type(T val){
		this.val = val;
	}
	public void setVal(T val){
		this.val = val;
	}
	public T getVal(){
		return val;
	}
	
}