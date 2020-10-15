
package interfaceGraphique;

import interfaceGraphique.control.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import sokoban.Game.BoardGame;

/**
 * <h1>La classe Window</h1>
 * <p>La classe Window correspond a la JFrame du jeu</p>
 *
 * @author  Abderrafii RABAH
 */
public class Window extends JFrame{
    
    /* plateau de jeu */
    private BoardGame board;
    

    /* CardLayout */
    private CardLayout cl = new CardLayout();
    private JPanel container = new JPanel();
    private String[] listContent = {"accueil", "option", "credit","jouer"};
    public static Image im;
    
    public Window(BoardGame board){
        
        this.board = board;
        
        try{
            this.im = ImageIO.read(new File("src/interfaceGraphique/images/Acceuil.jpg"));
            
        } catch (IOException ex) {
            System.out.println("fichier introuvable");
        }
        
        this.setTitle("Sokoban");
        //this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setSize(750,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        
        container.setLayout(cl);
        //this.setUndecorated(true);
      
        Accueil accueil = new Accueil(this); 
        container.add(accueil, listContent[0]);
        
        Option option = new Option(this);
        container.add(option, listContent[1]);
        
        Credit credit = new Credit(this);
        container.add(credit, listContent[2]);
        
        Game jouer = new Game(this.board, this); 
        container.add(jouer, listContent[3]);
        
        ControlCaracter cc = new ControlCaracter(board, jouer);
        
        addKeyListener(cc);
        
        cl.show(container, listContent[0]);
                
        this.setContentPane(container);
        this.setVisible(true);
        
    }
    
    public void setBoard(BoardGame board){
        
        this.board = board;
        
    }

    
    public void changePan(int indice){
        
        cl.show(container, listContent[indice]);
        if(indice == 3){
            this.changeTaille(this.board.getBoard()[0].length, this.board.getBoard().length);
            requestFocusInWindow();
        }
        
    }
    
    public void changeTaille(int x, int y){
        
        this.setSize(x*60, y*60);
        requestFocusInWindow();
        
    }

}
