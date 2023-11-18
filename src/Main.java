import javax.imageio.ImageIO;
import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// create jFrame window
		JFrame jFrame = new JFrame();

		// to spawn turtle in middle of window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();

		Scanner scanner = new Scanner(System.in);
		System.out.print("What depth do you want?: ");
		int depth = scanner.nextInt();
		System.out.print("What side length do you want?: ");
		int sideLength = scanner.nextInt();

		// create canvas to draw to
		// create turtle object that should start at the middle of the canvas
		TurtleCanvas canvas = new TurtleCanvas(new Turtle((int) (width / 2), (int) (height / 2)), sideLength, depth);
		jFrame.add(canvas);

		// set size of window to be 1000
		jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		jFrame.setVisible(true);

		// make program exit when jFrame closed
		jFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				BufferedImage image = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics2D = image.createGraphics();
				jFrame.paint(graphics2D);
				try {
					ImageIO.write(image, "jpeg", new File("triangle_fractal.jpeg"));
				} catch (IOException ex) {
					throw new RuntimeException(ex);
				}
				System.exit(1);
				super.windowClosing(e);
			}
		});
	}
}