package listen.lib.serializator;

//import listen.toTest.globVar.Glob; //Glob.filePath

/*
D:
cd toJava/classObject
javac listen/lib/serializator/Controller.java
*/

import listen.lib.Print;


import java.io.Console;

public class ControllerMax{
    
	private Serializator serialize;
	private String command;
	
	// получаем консоль
    private Console console = System.console();
	
	public ControllerMax(Serializator s){
		
		serialize = s;
		whatCommand();
	}
	
	public ControllerMax(/*Serializator s*/){
		
		//serialize = s;
		whatCommand();
	}
	
	private void whatCommand(){
		command = console.readLine("введите команду:");
		/* разбор команды */
		parseCommand();
	}
	
	private void parseCommand(){
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
				Print.ln("команды "+command+" не существует");
		}

		if(!command.equals("break")) whatCommand();
		else Print.ln("управление завершено");
	}
	
	private void breakCommand(){
		Print.ln("команда break - остановить чтение команд");
		/* разбор команды */
	}
	
	private void write(){
		Print.ln("команда write - новаЯ запись");
		/* разбор команды */
	}
	
	private void clear(){
		Print.ln("команда clear - очистить файл");
		/* разбор команды */
	}
	
	
	
	private void help(String cm){
		
		helpHead();
		
		cm = "| "+cm;
		if(cm.length() < 44){
			for(int i=cm.length(); i<43; i++)
				cm+=" ";
		}
		cm+="|";
		
		Print.ln(cm);
		
		helpFooter();
	}
	
	private void helpHead(){
		/* длинна строки 44 символа */
		Print.ln("==================справка===================");
		Print.ln("| break - остановить чтение команд         |");
		Print.ln("| write - новаЯ запись                     |");
		Print.ln("| clear - очистить файл                    |");
		Print.ln("| readAll - показать все записи            |");
		Print.ln("| help - получить справку                  |");
	}
	
	
	private void helpFooter(){
		Print.ln("============================================");
	}
	
	private void help(){
		helpHead();
		helpFooter();
	}
	private void readAll(){
		Print.ln("команда readAll - показать все записи");
		/* разбор команды */
	}
	
	public String getCommand(){
		return command;
	}
}


