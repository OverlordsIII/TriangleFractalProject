import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TurtleCanvas extends JPanel {
	private Turtle turtle;

	public TurtleCanvas(Turtle turtle) {
		this.turtle = turtle;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		drawFractal(g, 250, 3, turtle.getX(), turtle.getY());
	}

	private void drawFractal(Graphics graphics, int sideLength, int depth, double x, double y) {
		if (depth == 0) {
			return;
		}

		drawTriangle(sideLength, graphics);


	}

	private void drawTriangle(int sideLength, Graphics graphics) {
		for (int i = 0; i < 3; i++) {
			turtle.move(sideLength);
			turtle.turn(120);
			draw(graphics);
		}
	}

	private void draw(Graphics gc) {
		// Draw the line representing the turtle's path first
		gc.drawLine((int) turtle.getPrevX(), (int) turtle.getPrevY(), (int) turtle.getX(), (int) turtle.getY());

		// Draw the turtle at its current position
	}
}
