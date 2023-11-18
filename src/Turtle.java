// Our implementation of the Turtle object from python in Java
public class Turtle {

	// current X position of turtle
	private double x;

	// current y positoin of turtle
	private double y;

	// prev X position of turtle
	private double prevX;

	// prev Y position of turtle
	private double prevY;

	// angle that turtle has turned to
	private double angle;


	public Turtle(int x, int y) {
		this.x = x;
		this.y = y;
		this.prevX = x;
		this.prevY = y;
		this.angle = 0;
	}


	// moves turtle. Negative will move turtle backwards
	public void move(double distance) {
		prevX = x;
		prevY = y;
		x = x + distance * Math.cos(Math.toRadians(angle));
		y = y + distance * Math.sin(Math.toRadians(angle));
	}

	// turns the turtle to the left a certain number of degrees
	// enter negative number to turn to the right
	public void turn(double degrees) {
		angle += degrees;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getPrevX() {
		return prevX;
	}

	public double getPrevY() {
		return prevY;
	}

	public double getAngle() {
		return angle;
	}
}