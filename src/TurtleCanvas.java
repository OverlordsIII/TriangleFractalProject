import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

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
			// set to random color
			graphics.setColor(getColor());
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

	// random color based on 14 based colors in Java AWT package

	private Color getColor() {
		int depth = new Random().nextInt(1, 15);
		Color color = Color.BLACK;
		switch (depth) {
			case 1 -> color = Color.WHITE;
			case 2 -> color = Color.LIGHT_GRAY;
			case 3 -> color = Color.GRAY;
			case 4 -> color = Color.DARK_GRAY;
			case 5 -> color = Color.BLACK;
			case 6 -> color = Color.RED;
			case 7 -> color = Color.PINK;
			case 8 -> color = Color.ORANGE;
			case 9 -> color = Color.YELLOW;
			case 10 -> color = Color.GREEN;
			case 11 -> color = Color.MAGENTA;
			case 12 -> color = Color.CYAN;
			case 13 -> color = Color.BLUE;
		}

		return color;
	}

	// draw triangles with 120 degree angles. Used in base case
	private void drawTriangle(int sideLength, Graphics graphics) {
		int[] xPoints = new int[3];
		int[] yPoints = new int[3];

		for (int i = 0; i < 3; i++) {
			turtle.move(sideLength);
			xPoints[i] = (int) turtle.getX();
			yPoints[i] = (int) turtle.getY();
			turtle.turn(120);
		}

		//graphics.setColor(color);
		graphics.fillPolygon(xPoints, yPoints, 3);
	}

	// draws a line for turtle graphics
	private void draw(Graphics gc) {
		// Draw the line representing the turtle's path first
		gc.drawLine((int) turtle.getPrevX(), (int) turtle.getPrevY(), (int) turtle.getX(), (int) turtle.getY());
	}
}
