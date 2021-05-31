import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.util.*;
import java.awt.Color;

public class Screen extends JComponent implements MouseListener, MouseMotionListener {
    Node current;
    public void mouseMoved(MouseEvent e) { }
    public void mouseDragged(MouseEvent e) {
        if (this.current != null) {
            int x = e.getX(), y = e.getY();
            Point mouseLocation = new Point(x, y);
            this.current.moveTo( mouseLocation );
            this.repaint();
        }

    }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        Point mouseLocation = new Point(x, y);
        for (Node c : this.nodes) {
            double d = c.location.distanceTo(mouseLocation);
            // System.out.println( "Distance to " + c + " from your mouse is: " + d );
            if ( d < 20 ) {
                this.current = c;
                // return;
                break;
            }
        }
    }
    public void mouseReleased(MouseEvent e) {
        this.current = null;
    }
    public void mouseClicked(MouseEvent e) { }
    ArrayList<Node> nodes = new ArrayList<Node>();
    public Screen() {

        root = new Node("0", 0, new Point(200, 200),Color.GREEN);
        nodes.add(root);
        for (int i =1; i<10; i++) {
            int rand = (int)(Math.random() *20+1);


            //nodes.add(new Node(node, rand, new Point((int) (Math.random() * 300 + 50), // nodes.add()?
                    //(int) (Math.random() * 300 + 50))));
            insertNode(root, rand,root.location.x,root.location.y,null);
            //else nodes.get(i).left;
        }



        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }
    Node root;
    public Node insertNode(Node n, int value, int x, int y, Color c){
        if(n == null)
        {

            Node newNode = new Node(""+value, value, new Point(x, y),c);
            nodes.add(newNode);
            return newNode;
        }
        else if (n.value < value)
        {
            n.right = insertNode(n.right, value, x+50,y+50,Color.red);
        }
        else if (n.value > value)
        {
            n.left = insertNode(n.left, value,x-50,y+50,Color.BLUE);
        }

        return n;
    }
    public Node findLeftmostNode(Node n){
        if(n == null) {return null;}
        if(n.left == null) {return n;}
        else return findLeftmostNode(n.left);
    }

    public Node removeNode(Node n, int value) {
        if (n == null) {
            System.out.println("Node not detected");
            return null;
        }if (n.value < value) { // to the right
            n.right = removeNode(n.right, value);
            return n;
        }if (n.value > value) { // to the left
            n.left = removeNode(n.left, value);
            return n;
        } else {
            // We've found the node we need to remove
            if (n.left == null && n.right == null) {
                nodes.remove(n);
                return null; // return null
            }
            else if (n.left != null && n.right == null) {
                Node x = n.left;
                x.c = n.c;
                nodes.remove(n);
                return x;
            } else if (n.right != null && n.left == null) {
                Node x = n.right;
                x.c = n.c;
                nodes.remove(n);
                return x;
            } else if (n.right != null && n.left != null) {
                Node leftmost = findLeftmostNode(n.right);
                n.str_value = ""+leftmost.value;
                n.value = leftmost.value;
                n.right = removeNode(n.right, leftmost.value);
                nodes.remove(leftmost);
                return n;
            }
        }
        return null;
    }

    public void paintComponent(Graphics g) {
          for (Node c : this.nodes) {
            c.draw(g);
        }
    }
    public ArrayList<Node> getList(){
        return nodes;
    }
}
