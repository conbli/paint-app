import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Canvas extends JPanel implements MouseMotionListener, ActionListener, KeyListener {
    int height = 1000;
    int width = 1000;
    double brushSize = 20;
    double xLocation, yLocation;
    int red = 0;
    int green = 0;
    int blue = 0;

    HashMap<Integer, Color> colorSelect = new HashMap<Integer, Color>();
    int selectedColorKey = 0;
    Ellipse2D.Double paint;
    Color backgroundColour = new Color(255, 255, 255);
    Color brushColour = new Color(red, green, blue);

    public Canvas() {
        this.addKeyListener(this);
        this.setFocusable(true);

        this.addMouseMotionListener(this);

        Timer timer = new Timer(1, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        setSize(this.height, this.width);
        setBackground(backgroundColour);


        ColourButton buttonBlack = new ColourButton(this, "Black", Color.black);
        add(buttonBlack);
        colorSelect.put(1, Color.black);

        ColourButton buttonGray = new ColourButton(this, "Gray", Color.gray);
        add(buttonGray);
        colorSelect.put(2, Color.gray);

        ColourButton buttonWhite = new ColourButton(this, "White", Color.white);
        add(buttonWhite);
        colorSelect.put(3, Color.white);

        ColourButton buttonRed = new ColourButton(this, "Red", Color.red);
        add(buttonRed);
        colorSelect.put(4, Color.red);

        ColourButton buttonGreen = new ColourButton(this, "Green", Color.green);
        add(buttonGreen);
        colorSelect.put(5, Color.green);

        ColourButton buttonBlue = new ColourButton(this, "Blue", Color.blue);
        add(buttonBlue);
        colorSelect.put(6, Color.blue);

        ColourButton buttonMagenta = new ColourButton(this, "Magenta", Color.magenta);
        add(buttonMagenta);
        colorSelect.put(7, Color.magenta);

        ColourButton buttonCyan = new ColourButton(this, "Cyan", Color.cyan);
        add(buttonCyan);
        colorSelect.put(8, Color.cyan);

        ColourButton buttonYellow = new ColourButton(this, "Yellow", Color.yellow);
        add(buttonYellow);
        colorSelect.put(9, Color.yellow);

        ColourButton buttonOrange = new ColourButton(this, "Orange", Color.orange);
        add(buttonOrange);
        colorSelect.put(10, Color.orange);

        ColourButton buttonPink = new ColourButton(this, "Pink", Color.pink);
        add(buttonPink);
        colorSelect.put(11, Color.pink);

        Color brown = new Color(66, 40, 14);
        ColourButton buttonBrown = new ColourButton(this, "Brown", brown);
        add(buttonBrown);
        colorSelect.put(12, brown);

        Color blood = new Color(138, 7, 7);
        ColourButton buttonBlood = new ColourButton(this, "Blood", blood);
        add(buttonBlood);
        colorSelect.put(13, blood);


        Graphics2D brush = (Graphics2D) g;
        brush.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        brush.setColor(brushColour);

        this.paint = new Ellipse2D.Double(xLocation, yLocation, brushSize, brushSize);
        brush.fill(paint);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        xLocation = e.getX() - brushSize/2;
        yLocation = e.getY() - brushSize/2;
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 38) {
            brushSize += 5;
            xLocation -= 2.5;
            yLocation -= 2.5;
        } else if (e.getKeyCode() == 40 && brushSize > 0) {
            brushSize -= 5;
            xLocation += 2.5;
            yLocation += 2.5;
        }
        
        if (e.getKeyCode() == 37) {
            selectedColorKey --;
            if (selectedColorKey < 1) {
                selectedColorKey = 13;
            }

        } else if (e.getKeyCode() == 39) {
            selectedColorKey ++;
            if (selectedColorKey > 13) {
                selectedColorKey = 1;
            }
        }
        brushColour = colorSelect.get(selectedColorKey);

        System.out.println("Brush size: " + brushSize);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
