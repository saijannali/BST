import javax.swing.JFrame;

public class Example {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new Screen());
        f.setVisible(true);
        f.setSize(400, 400);
    }
}