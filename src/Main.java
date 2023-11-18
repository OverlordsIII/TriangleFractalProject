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

		Scanner scanner = new Scanner(System.in);
		System.out.print("What depth do you want?: ");
		int depth = scanner.nextInt();

		// depth must be lower than 10 or it will be too small to render on the screen
		while (depth >= 10) {
			System.out.println("Depth must be less than 10, otherwise it will be too small to see.");
			System.out.print("What is your new value for depth?:");
			depth = scanner.nextInt();
		}

		System.out.print("What side length do you want?: ");
		int sideLength = scanner.nextInt();

		// create canvas to draw to
		// create turtle object that should start at 100, 100
		TurtleCanvas canvas = new TurtleCanvas(new Turtle(100, 100), sideLength, depth);
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