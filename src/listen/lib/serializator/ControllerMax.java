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
	
	// �������� �������
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
		command = console.readLine("������� �������:");
		/* ������ ������� */
		parseCommand();
	}
	
	private void parseCommand(){
		/* ������ ������� */
		
		switch(command){
			case "break": 
				breakCommand();
				break;
			case "write": /* �������������� � ���������� */
				write();
				break;
			case "clear": /* �������������� � ���������� */
				clear();
				break;
			case "help": 
				help();
				break;
			case "readAll": /* �������������� � ���������� */
				readAll();
				break;
			default:
				Print.ln("������� "+command+" �� ����������");
		}

		if(!command.equals("break")) whatCommand();
		else Print.ln("���������� ���������");
	}
	
	private void breakCommand(){
		Print.ln("������� break - ���������� ������ ������");
		/* ������ ������� */
	}
	
	private void write(){
		Print.ln("������� write - ����� ������");
		/* ������ ������� */
	}
	
	private void clear(){
		Print.ln("������� clear - �������� ����");
		/* ������ ������� */
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
		/* ������ ������ 44 ������� */
		Print.ln("==================�������===================");
		Print.ln("| break - ���������� ������ ������         |");
		Print.ln("| write - ����� ������                     |");
		Print.ln("| clear - �������� ����                    |");
		Print.ln("| readAll - �������� ��� ������            |");
		Print.ln("| help - �������� �������                  |");
	}
	
	
	private void helpFooter(){
		Print.ln("============================================");
	}
	
	private void help(){
		helpHead();
		helpFooter();
	}
	private void readAll(){
		Print.ln("������� readAll - �������� ��� ������");
		/* ������ ������� */
	}
	
	public String getCommand(){
		return command;
	}
}


