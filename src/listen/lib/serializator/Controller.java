package listen.lib.serializator;

//import listen.toTest.globVar.Glob; //Glob.filePath

/*
D:
cd toJava/classObject
javac listen/lib/serializator/Controller.java
*/

import listen.lib.Print;
import listen.lib.serializator.Ini;
/* где, Ini - интерфейс, который наследует UnityIni - класс, 
который должен быть родительским для всех дополнительных созданных методов - 
в родительских классах, наследуемых от этого Controller */


import java.io.IOException;

import listen.lib.Consoleable;

import java.util.HashMap;
import java.util.Map;

/* тут, S скорее всего, почти всегда будет классом для работы с потоком вода - вывода,
 для работы с каком либо файлом, как вариант классом Serializator */
public abstract class Controller<S>{
    
	private String command;
	

	private Consoleable console = new Consoleable();
	
	// получаем консоль
   // public Console console = System.console();
	public Map<String, Ini> map = new HashMap<String, Ini>();
	
	public Controller() throws IOException{
		whatCommand();
	}
	
	public Controller(S so) throws IOException{
		ini(so);/* для инициализации объеккта для работы с файлом - в наследнике */
		
		whatCommand();
	}
	
	/* обязательно к переопределению в наследнике - 4 штуки */
	public abstract void ini(S so);
	/* следующие три используют в себе экземпляр so */
	public abstract void write() throws IOException;
	public abstract void clear();
	public abstract void readAll();
	
	
	private void breakCommand(){
		Print.ln("команда break - управление завершено");
	}
	
	
	public void whatCommand() throws IOException{

		command = console.readLine("введите команду:");
		/* разбор команды */
		parseCommand();
	}
	
	public void parseCommand() throws IOException{
		/* разбор команды */
		
		switch(command){
			case "break": 
				breakCommand();
				break;
			case "write": /* переопределить в наследнике */
				write();
				break;
			case "clear": /* переопределить в наследнике */
				clear();
				break;
			case "help": 
				help();
				break;
			case "readAll": /* переопределить в наследнике */
				readAll();
				break;
			default:
			{
				
				if(map.isEmpty()) Print.ln("команды "+command+" не существует");
				else {
					/* идём по массиву - зарегистрированных новых методов */
					/* вызвать метод класса, который наследовал этот класс, и добавил в map свои команды */
					/* добавление в этот класс он реализовал в свойм методе ini */
					
					Ini la = map.get(command);
					
					if(la != null) la.ini();
					else Print.ln("команды "+command+" не существует");
					
				}
				
			}
		}

		if(!command.equals("break")) whatCommand();
	}
	
	private String createStrToHelp(String cm){
		cm = "| "+cm;
		if(cm.length() < 44){
			for(int i=cm.length(); i<43; i++)
				cm+=" ";
		}
		cm+="|";
		return cm;
	}
	
	private void helpHead(){
		/* длинна строки 44 символа */
		Print.ln("================= справка ==================");
		Print.ln("| break - остановить чтение команд         |");
		Print.ln("| write - новая запись                     |");
		Print.ln("| clear - очистить файл                    |");
		Print.ln("| readAll - показать все записи            |");
		Print.ln("| help - получить справку                  |");
	}
	
	
	private void helpFooter(){
		Print.ln("============================================");
	}
	
	private void help(){
		helpHead();
		
		if(!map.isEmpty()){
			for(Map.Entry<String, Ini> item : map.entrySet()){
			   Print.ln(createStrToHelp(item.getValue().getInfoHelp()));
			}
		}
		
		helpFooter();
	}
	
	public String getCommand(){
		return command;
	}
}


