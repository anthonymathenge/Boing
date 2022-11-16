
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class ReadShapeFile {

	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */

	private static Circle readcircle(Scanner in) {
		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int diameter = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);

		Circle thecircle=new Circle(insertionTime, px, py, vx, vy, diameter, colour, isFilled);
		return thecircle;

	}
	private static Square readSquare(Scanner in) {
		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int side = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);

		Square thesquare =new Square(insertionTime, px, py, vx, vy, side, colour, isFilled);

		return thesquare;
	}
	private static Rect readRect(Scanner in) {
		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);

		Rect therect = new Rect(insertionTime, px, py, vx, vy,  width,height,colour, isFilled);
		return therect;

	}
	private static Triangle readTri(Scanner in) {
		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);

		Triangle thetriangle = new Triangle(insertionTime, px, py, vx, vy,width,height,colour, isFilled);
		return thetriangle;

	}
	private static Oval readOval(Scanner in) {
		int insertionTime = in.nextInt();
		int px = in.nextInt();
		int py = in.nextInt();
		int vx = in.nextInt();
		int vy = in.nextInt();
		boolean isFilled = in.nextBoolean();
		int width = in.nextInt();
		int height = in.nextInt();
		int r = in.nextInt();
		int g = in.nextInt();
		int b = in.nextInt();
		Color colour = Color.rgb(r, g, b);

		Oval theoval= new Oval(insertionTime, px, py, vx, vy, width , height, colour, isFilled);
		return theoval;

	}


	public static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
		ClosedShape thisshape = null;
		while(in.hasNext()) {
			String x = in.next();
			if (Objects.equals(x, "circle")) {
				thisshape=readcircle(in);
				shapeQueue.enqueue(thisshape);
			} else if (Objects.equals(x, "square")) {
				thisshape=readSquare(in);
				shapeQueue.enqueue(thisshape);
			} else if (Objects.equals(x, "rect")) {
				thisshape=readRect(in);
				shapeQueue.enqueue(thisshape);
			} else if (Objects.equals(x, "oval")) {
				thisshape=readOval(in);
				shapeQueue.enqueue(thisshape);
			}else if (Objects.equals(x, "triangle")) {
				thisshape=readTri(in);
				shapeQueue.enqueue(thisshape);
			}

		}
		return shapeQueue;
	}
	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		File f = new File(filename);
		Scanner in = null;
		try {
			in = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find" + " " + filename);
			e.printStackTrace();
			System.exit(0);
		}
		return ReadShapeFile.readLineByLine(in);

	    
	}
}
