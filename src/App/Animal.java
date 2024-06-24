package App;

import java.awt.Image;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Animal extends Thread {
    private int pos;
    private int lastPos;
    private JLabel[] board;
    private final Icon goal;
    private final Icon imageAnimal;
    private String name;
    private int speed;
    private boolean tortoise;

    public Animal(int pos, int lastPos, String name, JLabel[] board) {
        super();
        this.pos = pos;
        this.lastPos = lastPos;
        this.speed = "tortoise".equals(name) ? 1150 : 250;
        this.imageAnimal = loadImage(name+".png");
        this.goal = loadImage("goal.png");
        this.board = board;
        this.name=name;
    }

    private Icon loadImage(String fileName) {
        URL imageURL = getClass().getResource("/Images/" + fileName);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image scaledImage = icon.getImage().getScaledInstance(27, 29, Image.SCALE_DEFAULT);
            return new ImageIcon(scaledImage);
        } else {
            throw new IllegalArgumentException("Resource not found: " + fileName);
        }
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Icon getGoal() {
        return goal;
    }

    public Icon getImageAnimal() {
        return imageAnimal;
    }
    
    public boolean isTortoise() {
        return tortoise;
    }

    @Override
    public void run() {
        try {
            while (pos < 14) {
                lastPos = pos;
                pos++;

                if (lastPos != 11) {
                    board[lastPos].setIcon(null);
                } else {
                    board[lastPos].setIcon(goal);
                }

                if (pos == 14) {
                    break;
                }
                
                board[pos].setIcon(imageAnimal);
                if ("hare".equals(name) & pos == 8) {
                    Thread.sleep(9500);
                }

                Thread.sleep(speed);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Animal.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Reset icons when thread finishes or is interrupted
            for (int i = 0; i < board.length; i++) {
                board[i].setIcon(null);
            }
        }
    }
}