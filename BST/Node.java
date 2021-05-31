import java.awt.Graphics;
import java.awt.Color;

public class Node {
    public String toString() { return this.str_value; }
    String str_value;
    Point location;
    int value;

    Color c;
    Node left, right;
    public Node(String value,int val, Point location,Color c) {
        this.str_value = value;
        this.location = location;
        this.value = val;
        this.c = c;


        //this.neighbors = new ArrayList<Node>();
    }
    public void draw(Graphics g) {

        g.setColor(this.c);
        g.fillOval(this.location.x-20,this.location.y-30,50,50);
        g.setColor(Color.BLACK);

        g.drawOval(this.location.x-20, this.location.y-30,50,50);
        g.drawString( this.str_value, this.location.x, this.location.y );
        if(left != null)
            g.drawLine(this.location.x, this.location.y, left.location.x, left.location.y);

        if(right != null)
            g.drawLine(this.location.x, this.location.y, right.location.x, right.location.y);

    }

    public void moveTo(Point somewhere) {
        this.location = somewhere;
    }
}