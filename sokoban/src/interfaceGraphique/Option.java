
package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * <h1>La classe Option</h1>
 * <p>La classe Option correspond a la page du jeu des Option du jeu</p>
 *
 * @author  Abderrafii RABAH
 */
public class Option extends JPanel implements ActionListener  {
       
    /* Label */
    private JLabel label_opt1 = new JLabel("Volum");
    private JLabel label_opt2 = new JLabel("Changer de personnage");
    
    private JSlider volume;  
    
    /* comboBox */
    private String perso[] = {"BOB","Gertrue","Raoule"};
    private JComboBox persoBox = new JComboBox(perso);
    
    /* bouton */
    private JButton back = new JButton("Retour");
    
    private Window window;
    
    public Option (Window window) {
        
        this.window = window;
        
        this.add(label_opt2);
        
        this.add(persoBox);
        
        this.add(back);
        this.back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        
        this.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(this.window.im, 0, 0,750,750, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == back){
            System.out.println("back");
            window.changePan(0);
        }
    }
    
    
}
