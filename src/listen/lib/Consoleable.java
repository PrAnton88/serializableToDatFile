package listen.lib;
// import listen.lib.Consoleable; 


import java.io.Console; 
// ||
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Consoleable{
	
	private Console systemConsole = System.console();
	// ||
	private BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	

	public Consoleable(){
		
	}
	
	public String readLine(String message) throws IOException{
		
		System.out.print(message);
		// System.out.println(message);
		
		return readLine();
	}
	
	public String readLine() throws IOException{
		
		if(systemConsole == null) {
			return console.readLine();
		}
		
		return systemConsole.readLine();
	}
	
}