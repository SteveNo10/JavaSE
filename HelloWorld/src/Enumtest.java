
public class Enumtest {

	public static void main(String[] args) {
		Color mycolor = Color.Green;
		if(1 == mycolor.getVal()) {
			System.out.println("1 == " + mycolor);
		}
		else {
			System.out.println("1 != " + mycolor);
		}
		
		Color[] colors = Color.values();
		for(Color color : colors) {
			System.out.println(color);
		}
	}

}
