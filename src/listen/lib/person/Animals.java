package listen.lib.person;

import java.io.Serializable;


public class Animals implements Comparable<Animals>,Serializable{
	
	private String name;
	private String saying;
	
	public static boolean personField = true;
	//private static final long SerialVersionUID = (new ObjectStreamClass().getSerialVersionUID());
	
    public Animals(String n, String s){
          
        name=n;
        saying=s;
    }
	
	public String getName() {return name;}
    public String getSaying(){ return saying;}

	public int compareTo(Animals p){
     
        return name.compareTo(p.getName());
    }
}