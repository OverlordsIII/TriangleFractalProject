import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TurtleCanvas extends JPanel {
	private Turtle turtle;

	private int depth;

	private int sideLength;

	public TurtleCanvas(Turtle turtle, int sideLength, int depth) {
		this.turtle = turtle;
		this.sideLength = sideLength;
		this.depth = depth;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		drawFractal(g, sideLength, depth);
	}

	// Main Recursive Method
	private void drawFractal(Graphics graphics, int sideLength, int depth) {
		// base case. If depth 0, just draw an equilateral triangle with the sidelengths provided
		if (depth == 0) {
			drawTriangle(sideLength, graphics);
		} else {
			// Draw first triangle from tip of big triangle down
			// this will draw the first line
			drawFractal(graphics, sideLength / 2, depth - 1);
			// move down to repeat process
			turtle.move(sideLength / 2);
			// draw second triangle, creating the second side of the triangle in the middle
			// what we are actually doing is drawing 3 triangles in each point of triangle
			// making it look like we are drawing one in the middle when we are not
			drawFractal(graphics, sideLength / 2, depth - 1);
			// this operations recalibrate the turtle to make the 3rd triangle
			turtle.move(- sideLength / 2);
			turtle.turn(60);
			turtle.move(sideLength / 2);
			turtle.turn(-60);
			// do the 3rd triangle
			drawFractal(graphics, sideLength / 2, depth - 1);
			// reset to do the same thing again
			turtle.turn(60);
			turtle.move(-sideLength / 2);
			turtle.turn(-60);
		}



	}

	// draw triangles with 120 degree angles. Used in base case
	private void drawTriangle(int sideLength, Graphics graphics) {
		for (int i = 0; i < 3; i++) {
			turtle.move(sideLength);
			turtle.turn(120);
			draw(graphics);
		}
	}

	// draws a line for turtle graphics
	private void draw(Graphics gc) {
		// Draw the line representing the turtle's path first
		gc.drawLine((int) turtle.getPrevX(), (int) turtle.getPrevY(), (int) turtle.getX(), (int) turtle.getY());
	}
}
