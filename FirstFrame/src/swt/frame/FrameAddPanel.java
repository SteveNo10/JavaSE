package swt.frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameAddPanel extends Frame{
	
	private static final long serialVersionUID = 1L;

	public FrameAddPanel(String str){
		super(str);
	}
	
	public static void main(String args[]){
		FrameAddPanel f = new FrameAddPanel("Frame Add Panel Test");
		f.setSize(400, 300);
		f.setBackground(Color.BLUE);
		f.setLayout(null);
		
		Panel p = new Panel();
		p.setSize(200, 150);
		p.setBackground(Color.RED);
		
		f.add(p);
		f.setVisible(true);
		f.addWindowListener(f.new MyWindowAdapter());
	}
	
	class MyWindowAdapter extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
}
