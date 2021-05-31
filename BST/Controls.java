import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Controls extends JPanel implements ActionListener{
    Screen s;
    public Controls(Screen s) {
        this.s = s;
        this.add(new JLabel("Choose Options"));
        String[] bOptions = {"Insert", "Remove" };
        b = new JComboBox(bOptions);
        this.add(b);
        a = new JTextField();
        a.setPreferredSize(new Dimension(40, 20));
        this.add(a);
        JButton c = new JButton("Proceed");
        c.addActionListener(this);
        this.add(c);
    }
    public void actionPerformed(ActionEvent e) {
        Screen list = new Screen();
        ArrayList<Node> nodes = list.getList();
       if (b.getSelectedItem().equals("Insert")){
           /*if(nodes.size() == 0) {
           }
           int value = Integer.parseInt(a);*/
           int value = Integer.parseInt(a.getText());
           s.insertNode(s.root,value,s.root.location.x,s.root.location.y,null);
           System.out.println(s.nodes);
           s.repaint();
       }
       /*else if(b.getSelectedItem().equals("Remove")) {
            s.nodes.removeNode
       }*/

       if (b.getSelectedItem().equals("Remove")){
           int removeValue = Integer.parseInt(a.getText());
           s.removeNode(s.root,removeValue);
           System.out.println(s.nodes);
           s.repaint();
       }
    }

    JComboBox b;
    JTextField a;

}
