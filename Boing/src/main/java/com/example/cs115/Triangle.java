

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends ClosedShape{
    private int width;
    private int height;
    double[] xCoords = new double[]{this.x, this.x,this.x+this.width};
    double[] yCoords = new double[]{this.y+((double)this.height/2),this.y+this.height,this.y};


    /**
     * Creates a closed shape object.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the oval (in pixels).
     * @param height The height of the oval (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the oval is filled with colour, false if opaque.
     */
    protected Triangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }
    /**
     * @return The xCoords of the triangle
     */
    public double[] getXCoords(){return this.xCoords;}
    /**
     * @return The yCoords of the triangle
     */
    public double[] getYCoords(){
        return this.yCoords;
    }

    /**
     * @param width Resets the width.
     */

    public void setWidth (int width) {
        this.width = width;
    }


    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }


    /**
     * @return The width of the triangle
     */
    public int getWidth() {return this.width;}


    /**
     * @return The height of the triangle
     */
    public int getHeight() {return this.height;}

    /**
     * Method to convert a triangle to a string.
     */
    public String toString () {
        String result = "This is a triangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Draw the triangle on the screen.
     * @param g The graphics object of the scene component.
     */
    public void draw(GraphicsContext g) {

        double[] xCoords = new double[]{this.x, this.x+this.height,this.x+this.width};
        double[] yCoords = new double[]{(this.y+(double)this.height/2),this.y+this.height,this.y};
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon( xCoords, yCoords, 3);
        }
        else {
            g.strokePolygon( xCoords, yCoords, 3);
        }

    }
}