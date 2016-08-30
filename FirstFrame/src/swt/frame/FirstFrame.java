package swt.frame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FirstFrame extends Frame{
	private static final long serialVersionUID = 1L;

	public FirstFrame(String string){
		super(string);
	}
	
	public static void main(String args[]){
		FirstFrame f = new FirstFrame("My First Frame Applet");
		f.setSize(300, 200);
		f.setBackground(Color.BLUE);
		f.setVisible(true);
		f.addWindowListener(f.new Mywindowadapter());
	}
	
	class Mywindowadapter extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}
