
import acm.graphics.*;
import acm.program.CommandLineProgram;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.*;

public class Problema extends GraphicsProgram {

    public static final int PAUSE = 20;
    public static final int PIXELSMOVE = 5;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    GRect square = null;

    public void run() {
        screenSize.width = screenSize.width-50;
        this.resize(screenSize);
        int with = readInt("Enter a natural number for the with, the height will be set with/2: ");
        createRectangle(with,with/2);
        moveSideToSideSquare2();
    }

    private void createRectangle(int with,int height){
        Color color = getSquareColor();
        square = new GRect(with,height);
        square.setColor(color);
        square.setFilled(true);
        add(square,(screenSize.getWidth()/2-with/2),(screenSize.getHeight()/2-height/2));
    }

    private Color getSquareColor(){
        println("{\tRed = 1,\n\tBlue = 2,\n\tGreen = 3,\n\tYellow = 4,\n\tOrange = 5,\n\tBlack = 6\n}");
        println("Which color you want for the square?");
        println("PD: If you type a number that not is in the list by default it will be RED");
        int color = 1;
        color = readInt();
        switch (color){
            case 2:
                return Color.blue;
            case 3:
                return Color.green;
            case 4:
                return Color.yellow;
            case 5:
                return Color.orange;
            case 6:
                return Color.black;
            default:
                return Color.RED;
        }
    }

    public void moveSideToSideSquare(){
        while(true) {
            while (square.getX() > 0) {
                square.setLocation(square.getX() - PIXELSMOVE, square.getY());
                this.pause(PAUSE);
            }
            while((square.getX()+square.getWidth()) < screenSize.getWidth()){
                square.setLocation(square.getX() + PIXELSMOVE, square.getY());
                this.pause(PAUSE);
            }
        }
    }

    public void moveSideToSideSquare2(){
        while(true) {
            while (square.getX() > 0) {
                square.move( (-PIXELSMOVE), 0);
                this.pause(PAUSE);
            }
            while((square.getX()+square.getWidth()) < screenSize.getWidth()){
                square.move(PIXELSMOVE, 0);
                this.pause(PAUSE);
            }
        }
    }

    public static void main(String[] args) {
        new Problema().start(args);
    }
}
