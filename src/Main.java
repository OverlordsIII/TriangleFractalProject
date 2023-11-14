import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		TurtleCanvas canvas = new TurtleCanvas(new Turtle(500, 500));
		jFrame.add(canvas);
		jFrame.setSize(1000, 1000);
		jFrame.setVisible(true);
	}
}