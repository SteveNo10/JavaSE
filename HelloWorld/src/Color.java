
public enum Color {
	Red(1), 
	Green(2), 
	Blue(3);
	
	private int val;
	private Color(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return this.val;
	}
}
