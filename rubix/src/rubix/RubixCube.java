package rubix;

import javax.swing.JFrame;
import java.awt.Component;

public class RubixCube extends JFrame {

	public RubixCube() {
		super("Rubix Cube");
		setSize(480, 480);

		gui rubix = new gui();
		((Component) rubix).setFocusable(true);

		getContentPane().add(rubix);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		 RubixCube rc = new RubixCube();
		//cube c = new cube();
		//c.print();
		//c.topRotateClock();
		//System.out.println();
		//c.print();
	}
}
