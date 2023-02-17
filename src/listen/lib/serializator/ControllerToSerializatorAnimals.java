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

public class ControllerToSerializatorAnimals extends Controller<Serializator<Animals>>{
    
	private Serializator serialize;
	private static Consoleable console = new Consoleable();
	// ������� ������������ �� Controller
	
	public ControllerToSerializatorAnimals(Serializator s) throws IOException{
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
	
	/* ���������� � Controller, ��� �� ���������������� ���� � ������� �������� ���� �����,
	� �������� ���� (�����) ������, ������� ����������� ������ ���� ����������� �� UnityIni*/
	public void ini(Serializator s){
		serialize = s;
		
		/* ������� ���� ������ */
		map.put("lala",new Lala("lala �������"));
	}
	
	public void write() throws IOException{
		Print.ln("������� write - ����� ������");
		
		String name = console.readLine("���: ");
		String saying = console.readLine("�������: ");
		
		/* ������ � ���� */
		try{
			
			serialize.write(new Animals(name,saying));
			
		}catch(NullPointerException  ex){
			Print.ln("serialize is null ");
		}
	}
	
	public void clear(){
		Print.ln("������� clear - �������� ����");
		serialize.clear();
	}
	
	public void readAll(){
		ArrayList<Animals> ls = serialize.readObject();
		
		Print.ln("=============== ��� ������ ===================");
		for(Animals o: ls)
			Print.ln("���: "+o.getName()+" �������: "+o.getSaying());
		Print.ln("==============================================");
		
	}
	
}