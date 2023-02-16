package listen.lib.serializator;

public abstract class UnityIni implements Ini{
	private String info;
	public UnityIni(String helpInfo){
		info = helpInfo;
	}
	public String getInfoHelp(){
		return info;
	}
	public abstract void ini();
}