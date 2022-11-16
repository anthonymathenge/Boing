

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends ClosedShape{
    //side of square
    private int side;
    /**
     * Creates a closed shape object.
     *
     * @param insertionTime
     * @param x             The x position.
     * @param y             the y position.
     * @param vx
     * @param vy
     * @param colour        The line or fill colour.
     * @param isFilled      True if the shape is filled, false if not.
     */
    protected Square(int insertionTime, int x, int y, int vx, int vy,int side, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.side=side;
    }

    /**
     * @param side Resets the side.
     */
    public void setSide (int side) {
        this.side = side;
    }
    @Override
    /**
     * @return The width of the square
     */
    public int getWidth() {
        return 0;
    }
    @Override
    /**
     * @return The height of the square
     */
    public int getHeight() {
        return 0;
    }

    /**
     * @return The side of the square
     */
    public int getSide(){return side;}

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side is " + this.side + "\n";
        return result;
    }

    /**
     * Draw the square on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw(GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side);
        }
        else {
            g.strokeRect( x, y, side, side );
        }

    }

}

