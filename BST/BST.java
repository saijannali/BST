import javax.swing.JFrame;
import java.awt.*;

public class BST {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Screen a = new Screen();
        f.add(new Controls(a),BorderLayout.PAGE_START);
        f.add(a,BorderLayout.CENTER);

        //f.add(new Controls(a),BorderLayout.CENTER);

        f.setVisible(true);
        f.setSize(700, 700);


    }

}