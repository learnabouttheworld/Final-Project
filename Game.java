import javax.swing.*;
import java.awt.*;

public class Game {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pacman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300, 200, 900, 900);
        frame.add(new Ghost());
        frame.setVisible(true);
    }

}


