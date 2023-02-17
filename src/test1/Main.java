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
    
	// private static String filePerson = "testSerializable.dat";
	private static String fileAnimals = "testSerializableAnimals.dat";
	
    public static void main (String args[]){
    	
		try {
			
			
			
			// new ControllerToSerializator(new Serializator<Person>(Glob.filePath,filePerson));
			
			new ControllerToSerializatorAnimals(new Serializator<Animals>(Glob.filePath,fileAnimals));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
    
    }
}