
public class IntageTest {

	public static void main(String[] args) {
		int[] i = {20};
		Change(i);
		System.out.println(i[0]);
	}

	public static void Change(int[] i) {
		i[0] = 10;
	}
}
