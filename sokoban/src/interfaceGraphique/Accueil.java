package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * <h1>La classe Accueil</h1>
 * <p>La classe Accueil correspond a la page d'accueil du jeu </p>
 *
 * @author  Abderrafii RABAH
 */
public class Accueil extends JPanel implements ActionListener {
    
    /* Bouton */
    private final JButton jouer = new JButton("Jouez");
    private final JButton quitter = new JButton("Quitter");
    private final JButton option = new JButton("Option");
    private final JButton credit = new JButton("Crédit");
    
    /* comboBox */
    private String diff = new String("Difficulté");
    private String difficulty[] = {"Facile","Normale","Difficile"};
    private JComboBox diffBox = new JComboBox(difficulty);
    
    
    private Window window;
    
    /**
     * Charge la page d'accueil
     * @param window la JFram contenant le page
     */
    public Accueil(Window window){
        
        
        this.window = window;
        
        this.setLayout(null);
        
        this.add(jouer);
        jouer.addActionListener(this);
        jouer.setBackground(Color.LIGHT_GRAY);
        jouer.setBounds(125+3,3,100,30);
        
        this.add(diffBox);
        diffBox.setBounds(125+106,3,100,30);
        
        this.add(option);
        option.addActionListener(this);
        option.setBackground(Color.LIGHT_GRAY);
        option.setBounds(125+209,3,100,30);
        
        this.add(credit);
        credit.addActionListener(this);
        credit.setBackground(Color.LIGHT_GRAY);
        credit.setBounds(125+312,3,100,30);
        
        this.add(quitter);
        quitter.addActionListener(this);
        quitter.setBackground(Color.LIGHT_GRAY);
        quitter.setBounds(125+415,3,100,30);
        
        this.setVisible(true);
      
        
    }
    
    public void paintComponent(Graphics g){
        g.drawImage(this.window.im, 0, 0,750,750, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == quitter){
            System.out.println("quitter");
            window.dispose();
            System.exit(0);
        }
        
        else if (source == option){
            
            window.changePan(1);
            System.out.println("option");
        }
        
        else if (source == credit){
            
            window.changePan(2);
            System.out.println("sources");
        }
        
        else if (source == jouer){
            
            String SelectDif = diffBox.getSelectedItem().toString();
            System.out.println(SelectDif);
            window.changePan(3);
            System.out.println("jouer");
            
        }
    }
}