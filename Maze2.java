import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Maze2 extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private JLabel con;
    private JLabel b;

    private ImageIcon Pacman;

    private Pacman pac;

    public Maze2(){
	
	this.setTitle("Pacman");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(300, 200, 900, 900);
	addKeyListener(this);
	pane = getContentPane();
       	
	Pacman = new ImageIcon("PacmanRight.png");
	Image image = Pacman.getImage(); // transform it
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);

	Pacman = new ImageIcon(newimg);  // transform it back
	b = new JLabel();
       	pac = new Pacman();
	pane.setLayout(new GridLayout(40 ,40 ));

	panels = new JPanel[40 ][40];
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
		//	con  = new JLabel();
		
	       	Container c = getContentPane();
	
		    
		   			
		if (x == pac.getY() && y == pac.getX()) {
		    //      pac.setX(20);
		    //        pac.setY(20);
		     b.setIcon(Pacman);
		    p.setBackground(Color.BLACK);
		    p.add(b);
		}
		
		
		
		
		    p.setBackground(Color.BLACK);
	    
		    //	p.add(con);
		pane.add(p);

		if (x == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 0, Color.BLUE));
		}
		if (x == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 0, Color.BLUE));
		}
		if (y == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 10, 0, 0, Color.BLUE));
		}
		if (y == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 10, Color.BLUE));
		}
		if (x == 0 && y == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(10, 10, 0, 0, Color.BLUE));
		}
		if (x == 39 && y == 0) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 10, 10, 0, Color.BLUE));
		}
		if (x == 0 && y == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(10, 0, 0, 10, Color.BLUE));
		}
		if (x == 39 && y == 39) {
		    p.setBorder(BorderFactory.createMatteBorder(0, 0, 10, 10, Color.BLUE));
		}
	    }
	}
    }

    
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
	//	 b = new JLabel();
	
	
	if(c == KeyEvent.VK_UP && pac.getY() - 1 > 0){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getY());
	    
	    // b.setLocation(1,1);
 	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 < 39){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getY());
	}
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 <= 39){
	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 > 0){
       	    b.setIcon(null);
	    panels[pac.getY()][pac.getX()].repaint();
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
	//	JLabel b = new JLabel();
	//	(panels[pac.getX()][pac.getY()]).setIcon(Pacman);
	//	b.setIcon(Pacman);
    }
    
    public static void main(String[] args){
	Maze2 maze = new Maze2();
	maze.setVisible(true);
	//	maze.pack();
    }
}
