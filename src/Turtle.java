public class Turtle {

	private double x;

	private double y;

	private double prevX;

	private double prevY;

	private double angle;


	public Turtle(int x, int y) {
		this.x = x;
		this.y = y;
		this.prevX = x;
		this.prevY = y;
		this.angle = 0;
	}

	public void move(double distance) {
		prevX = x;
		prevY = y;
		x = x + distance * Math.cos(Math.toRadians(angle));
		y = y + distance * Math.sin(Math.toRadians(angle));
	}

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