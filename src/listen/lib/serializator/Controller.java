package listen.lib.serializator;

//import listen.toTest.globVar.Glob; //Glob.filePath

/*
D:
cd toJava/classObject
javac listen/lib/serializator/Controller.java
*/

import listen.lib.Print;
import listen.lib.serializator.Ini;
/* ���, Ini - ���������, ������� ��������� UnityIni - �����, 
������� ������ ���� ������������ ��� ���� �������������� ��������� ������� - 
� ������������ �������, ����������� �� ����� Controller */


import java.io.IOException;

import listen.lib.Consoleable;

import java.util.HashMap;
import java.util.Map;

/* ���, S ������ �����, ����� ������ ����� ������� ��� ������ � ������� ���� - ������,
 ��� ������ � ����� ���� ������, ��� ������� ������� Serializator */
public abstract class Controller<S>{
    
	private String command;
	

	private Consoleable console = new Consoleable();
	
	// �������� �������
   // public Console console = System.console();
	public Map<String, Ini> map = new HashMap<String, Ini>();
	
	public Controller() throws IOException{
		whatCommand();
	}
	
	public Controller(S so) throws IOException{
		ini(so);/* ��� ������������� �������� ��� ������ � ������ - � ���������� */
		
		whatCommand();
	}
	
	/* ����������� � ��������������� � ���������� - 4 ����� */
	public abstract void ini(S so);
	/* ��������� ��� ���������� � ���� ��������� so */
	public abstract void write() throws IOException;
	public abstract void clear();
	public abstract void readAll();
	
	
	private void breakCommand(){
		Print.ln("������� break - ���������� ���������");
	}
	
	
	public void whatCommand() throws IOException{

		command = console.readLine("������� �������:");
		/* ������ ������� */
		parseCommand();
	}
	
	public void parseCommand() throws IOException{
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
			{
				
				if(map.isEmpty()) Print.ln("������� "+command+" �� ����������");
				else {
					/* ���� �� ������� - ������������������ ����� ������� */
					/* ������� ����� ������, ������� ���������� ���� �����, � ������� � map ���� ������� */
					/* ���������� � ���� ����� �� ���������� � ����� ������ ini */
					
					Ini la = map.get(command);
					
					if(la != null) la.ini();
					else Print.ln("������� "+command+" �� ����������");
					
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
		/* ������ ������ 44 ������� */
		Print.ln("================= ������� ==================");
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


