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
	// консоль унаследовали от Controller
	
	public ControllerToSerializator(Serializator s) throws IOException{
		super(s);
	}
	
	/* принимать за единицу метода */
	public class Lala extends UnityIni{
		public Lala(String helpInfo){
			super(helpInfo);
		}
		public void ini(){
			Print.ln("I am testSt method, and I say - lala");
			/* действия над serialize */
		}
	}
	
	/* принимать за единицу метода */
	public class Haha extends UnityIni{
		public Haha(String helpInfo){
			super(helpInfo);
		}
		public void ini(){
			Print.ln("иханьки да хаханьки");
			/* действия над serialize */
		}
	}
	
	/* вызывается в Controller, что бы инициализировать файл с которым работает этот класс,
	и добавить свои (новые) методы, которые обязательно должны быть наследованы от UnityIni*/
	public void ini(Serializator s){
		serialize = s;
		
		/* добавим свои методы */
		map.put("lala",new Lala("lala команда"));
		
		map.put("haha",new Haha("haha команда"));
	}
	
	public void write() throws IOException{
		Print.ln("команда write - новая запись");
		
		String name = console.readLine("имя: ");
		int age = Integer.parseInt(console.readLine("возраст: "));
		double height = Double.parseDouble(console.readLine("рост: "));
		boolean married = Boolean.parseBoolean(console.readLine("в браке: "));
		
		/* запись в файл */
		try{
			
			serialize.write(new Person(name,age,height,married));
			
		}catch(NullPointerException  ex){
			Print.ln("serialize is null ");
		}
	}
	
	public void clear(){
		Print.ln("команда clear - очистить файл");
		serialize.clear();
	}
	
	public void readAll(){
		ArrayList<Person> ls = serialize.readObject();
		
		Print.ln("=============== все записи ===================");
		for(Person o: ls)
			Print.ln("имя: "+o.getName()+" возраст: "+o.getAge()+" рост: "+o.getHeight()+" в браке: "+o.getMarried());
		Print.ln("==============================================");
		
	}
	
}