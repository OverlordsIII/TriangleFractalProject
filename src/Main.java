import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
	public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		TurtleCanvas canvas = new TurtleCanvas(new Turtle(500, 500));
		jFrame.add(canvas);
		jFrame.setSize(1000, 1000);
		jFrame.setVisible(true);
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
				super.windowClosing(e);
			}
		});
	}
}