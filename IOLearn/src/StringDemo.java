
class MyData{
	int i;
	long l;
	float f;
	double d;
	MyData(){
		i = 1;
		l = 2l;
		f = 3.0f;
		d = 4.0d;
	}
	public String toString(){
		String str = new String();
		str = "i:" + i + "; j:" + "; f:" + f + "; d:" + d;
		return str;
	}
}

public class StringDemo {
	public static void main(String args[]){
		char[] c = {'a', 'b', 'c'};
		String s2 = new String(c);
		String s3 = new String(s2);
		System.out.println(s2.length() + ":" + s3);
		MyData data = new MyData();
		System.out.println(data);
		String subStr = data.toString();
		System.out.println("subStr.charAt(1)" + subStr.charAt(1));
	}
}
