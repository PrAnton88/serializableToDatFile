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
	// консоль унаследовали от Controller
	
	public ControllerToSerializatorAnimals(Serializator s) throws IOException{
		super(s);
	}
	
	/* принимать за единицу метода */
	public class Lala extends UnityIni{
		public Lala(String helpInfo){
			super(helpInfo);
		}
		public void ini(){
			Print.ln("I am testSt method, and I say - lala");
			/* действи€ над serialize */
		}
	}
	
	/* вызываетс€ в Controller, что бы инициализировать файл с которым работает этот класс,
	и добавить свои (новые) методы, которые об€зательно должны быть наследованы от UnityIni*/
	public void ini(Serializator s){
		serialize = s;
		
		/* добавим свои методы */
		map.put("lala",new Lala("lala команда"));
	}
	
	public void write() throws IOException{
		Print.ln("команда write - нова€ запись");
		
		String name = console.readLine("“ип: ");
		String saying = console.readLine("√оворит: ");
		
		/* запись в файл */
		try{
			
			serialize.write(new Animals(name,saying));
			
		}catch(NullPointerException  ex){
			Print.ln("serialize is null ");
		}
	}
	
	public void clear(){
		Print.ln("команда clear - очистить файл");
		serialize.clear();
	}
	
	public void readAll(){
		ArrayList<Animals> ls = serialize.readObject();
		
		Print.ln("=============== все записи ===================");
		for(Animals o: ls)
			Print.ln("“ип: "+o.getName()+" говорит: "+o.getSaying());
		Print.ln("==============================================");
		
	}
	
}