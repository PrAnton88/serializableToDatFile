package listen.lib.serializator;
/* —≈–»јЋ»«ј÷»я */

//import listen.toTest.globVar.Glob; //Glob.filePath
/*
D:
cd toJava/classObject
javac listen/lib/serializator/Serializator.java
*/

import listen.lib.Print;


import java.io.*;
import java.util.ArrayList;

/* для объектов, но не для просто го текста. */
public class Serializator<A extends Serializable>{
    
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ArrayList<A> listObjest = new ArrayList<A>();
	
	private String fileToSerializ;
	// private FileOutputStream anyDatFile;
	
	public Serializator(String fPath, String fileName) throws IOException{
		
		fileToSerializ = fPath+fileName;
		
		/* если файла не существует создать его */
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
			
			// сериализаци€ 
			for(A o : listObjest)
				oos.writeObject(o);
			
		}catch(IOException ex){
			Print.ln(ex.getMessage());
			
		}
	}
	
	/* writeObject и readObject */
	
	public void write(ArrayList list){
		
		listObjest.addAll(list);
		
		/* вызываем запись всего массива */
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
	
				/* где то тут печатается в консоль null.  */
				if((el.equals("null"))||(el.toString().isEmpty())) b = false;
				else listObjest.add(el);
				
			}
			
			
		}catch(IOException|ClassNotFoundException ex){
	
			Print.ln(ex.getMessage());
		}
	
		return listObjest;
	}
}


