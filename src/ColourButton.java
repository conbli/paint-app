import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColourButton extends JButton implements MouseListener, ActionListener {
    private Canvas canvas;
    private String name;
    private Color color;

    public ColourButton(Canvas canvas, String name, Color color) {
        super(name);
        this.canvas = canvas;
        this.name = name;
        this.color = color;
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(name + " has been selected as brush colour.");
        canvas.brushColour = color;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
