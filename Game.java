import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Game extends JFrame implements KeyListener {

    private Container pane;
    private JPanel[][] panels;
    private ImageIcon Pacman;
    private Pacman pac;
    private JLabel con;
    private JLabel b;

    private int xcor = 1;
    private int ycor = 1;

    public Game(){
	
	this.setTitle("Pacman Game");
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setBounds(300, 200, 900, 900);
	addKeyListener(this);
	pane = getContentPane();
	//	b = new JLabel();
	Pacman = new ImageIcon("PacmanRight.png");
	Image image = Pacman.getImage(); // transform it
	Image newimg = image.getScaledInstance(23,23,  java.awt.Image.SCALE_SMOOTH);
	Pacman = new ImageIcon(newimg);  // transform it back
       	pac = new Pacman();
	pane.setLayout(new GridLayout(40,40));
	panels = new JPanel[40][40];
       	con = new JLabel();
	for (int x = 0; x < panels.length;x++) {
            for (int y = 0; y < panels[x].length;y++) {
                panels[x][y] = new JPanel(new GridLayout(1,1));
		JPanel p = panels[x][y];
	       	Container c = getContentPane();
		p.setBackground(Color.BLACK);
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
	//panels[20][20].add(con);
	panels[10][10].add(con);
	con.setIcon(Pacman);

	Ghost ghost = new Ghost();
	panels[20][20].add(ghost);
	//	panels[30][30].setBackground(Color.WHITE);
	//	pane.add(panels[30][30]);
    }

    class Ghost extends JPanel {
	public void paintComponent(Graphics g) {
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 0, getWidth(), getHeight());
	    Pacman.paintIcon(pane, g, xcor, ycor);
	}
    }
		
		/*	if (x == pac.getY() && y == pac.getX()) {
		    //      pac.setX(20);
		    //        pac.setY(20);
		    con.setIcon(Pacman);
		    p.setBackground(Color.BLACK);
		   

		   
		else{
		    p.setBackground(Color.BLACK);
		}
		p.add(con);
		pane.add(p);
	    }
		*/

	    

	
    
    
    public void keyPressed(KeyEvent e){
	int c = e.getKeyCode();
	b = new JLabel();
	
	boolean pressed = true;
	if(pressed || c == KeyEvent.VK_UP || c == KeyEvent.VK_LEFT || c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_DOWN){
	    con.setIcon(null);
	    pressed = false;
	}
	
	    
  	if(c == KeyEvent.VK_UP && pac.getY() - 1 >= 0){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setY(pac.getY() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	}
    
	if(c == KeyEvent.VK_DOWN && pac.getY() + 1 <= 39){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setY(pac.getY() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getY());
	}
	if(c == KeyEvent.VK_RIGHT && pac.getX() + 1 <= 39){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setX(pac.getX() + 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
	if(c == KeyEvent.VK_LEFT && pac.getX() - 1 >= 0){
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(null);
	    pac.setX(pac.getX() - 1);
	    panels[pac.getY()][pac.getX()].add(b);
	    b.setIcon(Pacman);
	    System.out.println(pac.getX());
	}
	this.setVisible(true);
    }
    public void keyTyped(KeyEvent e){
    }
    public void keyReleased(KeyEvent e){
	this.setVisible(true);
    }
    
    public static void main(String[] args){
	Game game = new Game();
	game.setVisible(true);

    }
}
    

