package swt.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutDemo {
	Frame f;
	Button north;
	Button south;
	Button west;
	Button east;
	Button center;
	
	public BorderLayoutDemo(){
		f = new Frame("BorderLayout Demo!");
		north = new Button("NORTH");
		south = new Button("SOUTH");
		west = new Button("WEST");
		east = new Button("EAST");
		center = new Button("CENTER");
	}
	
	public void Show(){
		f.setSize(500, 400);
		f.setLayout(new BorderLayout());
		f.setBackground(Color.BLUE);
		f.add(BorderLayout.NORTH, north);
		f.add(BorderLayout.SOUTH, south);
		f.add(BorderLayout.WEST, west);
		f.add(BorderLayout.EAST, east);
		f.add(BorderLayout.CENTER, center);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			}
		});
		f.setVisible(true);
	}
	
	public static void main(String args[]){
		BorderLayoutDemo bl = new BorderLayoutDemo();
		bl.Show();
	}
}
