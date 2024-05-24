import javax.swing.*;

public class Easel extends JFrame {
    Canvas canvas = new Canvas();

    public Easel() {
        setSize(canvas.width, canvas.height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(canvas);
        setVisible(true);
    }
}
