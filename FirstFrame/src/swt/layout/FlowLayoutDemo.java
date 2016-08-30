package swt.layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowLayoutDemo {
	private Frame f;
	private Button b1;
	private Button b2;
	private Button b3;
	
	public FlowLayoutDemo(){
		b1 = new Button("continue");
		b2 = new Button("cancel");
		b3 = new Button("ok");
	}
	
	public void show(){
		f = new Frame("Flowlayout Demo");
		f.setSize(300, 240);
		f.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));
		f.add(b1);
		f.add(b2);
		f.add(b3);
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
		FlowLayoutDemo fl = new FlowLayoutDemo();
		fl.show();
	}
}
