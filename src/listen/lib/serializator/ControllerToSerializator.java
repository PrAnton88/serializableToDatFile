package listen.lib.serializator;

import listen.lib.Consoleable;

//import listen.toTest.globVar.Glob; //Glob.filePath

/*
D:
cd toJava/classObject
javac listen/lib/serializator/ControllerToSerializator.java
*/

import listen.lib.Print;
import listen.lib.serializator.Serializator;
import listen.lib.serializator.Controller;
import listen.lib.serializator.UnityIni;
import listen.lib.person.*;
import java.util.ArrayList;

import java.io.IOException;
import listen.lib.Consoleable;

public class ControllerToSerializator extends Controller<Serializator<Person>>{
    
	private Serializator serialize;
	private static Consoleable console = new Consoleable();
	// ������� ������������ �� Controller
	
	public ControllerToSerializator(Serializator s) throws IOException{
		super(s);
	}
	
	/* ��������� �� ������� ������ */
	public class Lala extends UnityIni{
		public Lala(String helpInfo){
			super(helpInfo);
		}
		public void ini(){
			Print.ln("I am testSt method, and I say - lala");
			/* �������� ��� serialize */
		}
	}
	
	/* ��������� �� ������� ������ */
	public class Haha extends UnityIni{
		public Haha(String helpInfo){
			super(helpInfo);
		}
		public void ini(){
			Print.ln("������� �� ��������");
			/* �������� ��� serialize */
		}
	}
	
	/* ���������� � Controller, ��� �� ���������������� ���� � ������� �������� ���� �����,
	� �������� ���� (�����) ������, ������� ����������� ������ ���� ����������� �� UnityIni*/
	public void ini(Serializator s){
		serialize = s;
		
		/* ������� ���� ������ */
		map.put("lala",new Lala("lala �������"));
		
		map.put("haha",new Haha("haha �������"));
	}
	
	public void write() throws IOException{
		Print.ln("������� write - ����� ������");
		
		String name = console.readLine("���: ");
		int age = Integer.parseInt(console.readLine("�������: "));
		double height = Double.parseDouble(console.readLine("����: "));
		boolean married = Boolean.parseBoolean(console.readLine("� �����: "));
		
		/* ������ � ���� */
		try{
			
			serialize.write(new Person(name,age,height,married));
			
		}catch(NullPointerException  ex){
			Print.ln("serialize is null ");
		}
	}
	
	public void clear(){
		Print.ln("������� clear - �������� ����");
		serialize.clear();
	}
	
	public void readAll(){
		ArrayList<Person> ls = serialize.readObject();
		
		Print.ln("=============== ��� ������ ===================");
		for(Person o: ls)
			Print.ln("���: "+o.getName()+" �������: "+o.getAge()+" ����: "+o.getHeight()+" � �����: "+o.getMarried());
		Print.ln("==============================================");
		
	}
	
}