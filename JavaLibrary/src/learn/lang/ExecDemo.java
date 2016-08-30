package learn.lang;

public class ExecDemo {
	public static void main(String args[]){
		Runtime t = Runtime.getRuntime();
		Process p = null;
		try{
			p = t.exec("notepad");
			p.waitFor();
		}catch(Exception e){
			System.out.println("open notepad error");
		}
	}
}
