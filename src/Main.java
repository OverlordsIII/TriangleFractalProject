import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) {
		// create jFrame window
		JFrame jFrame = new JFrame();

		// create canvas to draw to
		// create turtle object that should start at the middle of the canvas
		TurtleCanvas canvas = new TurtleCanvas(new Turtle(500, 500));
		jFrame.add(canvas);

		// set size of window to be 1000
		// TODO set size to be size of monitor
		jFrame.setSize(1000, 1000);
		jFrame.setVisible(true);

		// make program exit when jFrame closed
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
				super.windowClosing(e);
			}
		});
	}
}