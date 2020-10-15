
package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <h1>La classe Credit</h1>
 * <p>La classe Credit correspond a la page des Credits du jeu </p>
 *
 * @author  Abderrafii RABAH
 */
public class Credit extends JPanel implements ActionListener{
    
    /* Label */
    private JLabel label_src1 = new JLabel("Created by Abdo17R");
    private JLabel label_src2 = new JLabel("L2 informatique UNICAEN, 2018");
    
    /* bouton */
    private JButton back = new JButton("Retour");
    
    private Window window;
    
    public Credit (Window window) {
        
        this.window = window;
        
        this.add(label_src1);
        
        this.add(label_src2);
        
        this.add(back);
        this.back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(this);
        
        
    }
    
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
