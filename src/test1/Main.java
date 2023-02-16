package test1;


import listen.toTest.globVar.Glob; //Glob.filePath
/*
D:
cd toJava/classObject
javac listen/toTest/io/controllerSerializator/Main.java
*/

import java.io.IOException;
import listen.lib.person.*;
import listen.lib.serializator.*;



public class Main{
    
	private static String fileName = "testSerializable.dat";
	
    public static void main (String args[]){
    	
		try {
			
			//Serializator<Person> sr = new Serializator<Person>(Glob.filePath,"testSerializable.dat");
			
			//ControllerToSerializator cr = new ControllerToSerializator(sr);
			
			new ControllerToSerializator(new Serializator<Person>(Glob.filePath,fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
    
    }
}