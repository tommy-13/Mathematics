package mathsol.functions.draw.test;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import mathsol.functions.basic.LinearFunction;
import mathsol.functions.draw.ContinousFunctionPanel;

public class DrawingTest {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Funktionen zeichnen");
		frame.setLayout(new BorderLayout());
		
		//frame.add(new JLabel("Funktion zeichnen"), BorderLayout.NORTH);

		//JPanel panel = new ContinousFunctionPanel(new LinearFunction(0, 1), -20, 20);
		JPanel panel = new ContinousFunctionPanel(new LinearFunction(0, 1), -200, -100, 1200, 800);
		//JPanel panel = new ContinousFunctionPanel(new QuadraticFunction(1, -2, -1), -5, 5, 1000, 800);
		frame.add(panel, BorderLayout.CENTER);
		
		
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
