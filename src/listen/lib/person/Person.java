package listen.lib.person;

import listen.lib.person.MethodPerson;
import java.io.Serializable;
//import java.io.ObjectStreamClass;


public class Person implements Comparable<Person>,MethodPerson,Serializable{
	
	private String name;
    private int age;
    private double height;
    private boolean married;
	
	public static boolean personField = true;
	//private static final long SerialVersionUID = (new ObjectStreamClass().getSerialVersionUID());
	
	public Person(){
          
        name="name";
        age=17;
        height=1.77;
        married=false;
    }
	
    public Person(String n, int a, double h, boolean m){
          
        name=n;
        age=a;
        height=h;
        married=m;
    }
	
	public String getName() {return name;}
    public int getAge(){ return age;}
    public double getHeight(){return height;}
    public boolean getMarried(){return married;}
	
	public void Hi(){
		System.out.println(" Привет, меня зовут " + getName());
	}
	public int compareTo(Person p){
     
        return name.compareTo(p.getName());
    }
}