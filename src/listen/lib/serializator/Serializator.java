package listen.lib.serializator;
/* ������������ */

//import listen.toTest.globVar.Glob; //Glob.filePath
/*
D:
cd toJava/classObject
javac listen/lib/serializator/Serializator.java
*/

import listen.lib.Print;


import java.io.*;
import java.util.ArrayList;

/* ��� ��������, �� �� ��� ������ �� ������. */
public class Serializator<A extends Serializable>{
    
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ArrayList<A> listObjest = new ArrayList<A>();
	
	private String fileToSerializ;
	// private FileOutputStream anyDatFile;
	
	public Serializator(String fPath, String fileName) throws IOException{
		
		fileToSerializ = fPath+fileName;
		
		/* ���� ����� �� ���������� ������� ��� */
		File anyDatFile = new File(fileToSerializ);
		if(!anyDatFile.exists()){
			new FileOutputStream(fileToSerializ);
			
		}else{
			readObject();
		}
	}
	
	private void write(){
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileToSerializ)))
		{
			
			// ������������ 
			for(A o : listObjest)
				oos.writeObject(o);
			
		}catch(IOException ex){
			Print.ln(ex.getMessage());
			
		}
	}
	
	/* writeObject � readObject */
	
	public void write(ArrayList list){
		
		listObjest.addAll(list);
		
		/* �������� ������ ����� ������� */
		write();
	}
	
	public void write(A object){
		
		listObjest.add(object);
		
		write();
		
	}
	
	public void clear(){
		listObjest = new ArrayList<A>();
		write();
	}
	
	public ArrayList getList(){
		return listObjest;
	}
	
	public ArrayList readObject(){
		
		listObjest = new ArrayList<A>();
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileToSerializ)))
		{
			
			//listObjest=((ArrayList<A>)ois.readObject());
			//ois.readObject();
			
			A el;
			Boolean b = true;
			
			//if(!implementsSerLi.SerialVersionUID) b = false;
			
			while(b){
				
				el = (A)ois.readObject();
	
				/* ��� �� ��� ���������� � ������� null.  */
				if((el.equals("null"))||(el.toString().isEmpty())) b = false;
				else listObjest.add(el);
				
			}
			
			
		}catch(IOException|ClassNotFoundException ex){
	
			Print.ln(ex.getMessage());
		}
	
		return listObjest;
	}
}


