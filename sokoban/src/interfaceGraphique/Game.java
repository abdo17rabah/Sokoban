package interfaceGraphique;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import levels.Levels;
import sokoban.Game.BoardGame;

/**
 * <h1>La classe Game</h1>
 * <p>La classe Game correspond a la page du jeu avec le board et les déplacement</p>
 *
 * @author  Abderrafii RABAH
 */
public class Game extends JPanel implements ActionListener{
    

    private int height ;
    
    private BoardGame board;
    
    private final JButton quitter = new JButton("quitter");
    private final JButton suiv = new JButton("Niveau Suivant");
    
    JFrame endScreen;
    
    private Window window;
    
    public Game(BoardGame board, Window window){
        
        this.window = window;
        
        this.height = 60;
        this.board = board;
        
        this.add(suiv);
        suiv.addActionListener(this);
        suiv.setBackground(Color.LIGHT_GRAY);
        
        this.add(quitter);
        quitter.addActionListener(this);
        quitter.setBackground(Color.LIGHT_GRAY);
      
        this.setVisible(true);
        
    }
    
    @Override
    public void paintComponent(Graphics g){       
        
        
        Load newImage = new Load();  
        
        if(this.board.haveNoZone()){
            
            System.out.println("test");
            
            this.endScreen();
            
        }

        for (int x = 0; x < board.getBoard()[0].length ; x++){

            for (int y = 0 ; y < board.getBoard().length; y++){
                
                char zone = this.board.getBoard() [y] [x];
                

                switch (zone){
                    
                    case ' ':
                        g.drawImage(newImage.getGround(), x * height, y * height, height, height, this);
                        break;
                        
                    case '#':
                        g.drawImage(newImage.getWall(), x * height, y * height,height,height, this);
                        break;
                        
                    case '@':
                        g.drawImage(newImage.getGround(), x * height, y * height,height,height, this);
                        g.drawImage(newImage.getPlayer(), height * x, height * y,height,height, this);
                        break;  
                        
                    case '$':
                        
                        g.drawImage(newImage.getBox(), height * x, height * y ,height,height, this);
                        break;
                        
                    case '*':
                        g.drawImage(newImage.getValidBox(), height * x, height * y ,height,height, this);
                        break;
                        
                    case '.':                       
                        g.drawImage(newImage.getGround(), height * x, height * y,height,height, this);
                        g.drawImage(newImage.getZones(), height * x +5, height * y +5, this);
                        break;
                    
                    default:
                        g.drawImage(newImage.getGround(), x * height, y * height, height, height, this);
                        break;
                }
            }
        }
        
        
    }
 
    /**
     * Permet d'afficher la fenetre de fin
     */    
    public void endScreen() {
        
        this.endScreen = new JFrame();
        
        /*Panel*/
        JPanel container = new JPanel();
        
        /*Bouton*/
        JButton quitter = new JButton("Quitter");
        JButton suiv = new JButton("Niveau Suivant");
    
        /*Label*/
        JLabel bravo = new JLabel("Bravo, vous avez fini le puzzle !!!");
        
        /* Parametre de la fenetre */
        endScreen.setSize(400, 400);
        endScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endScreen.setResizable(false);
        endScreen.setLocationRelativeTo(null);
        
        /* Parametre du container */
        container.setLayout(null);
        endScreen.setContentPane(container);
        
        container.setLayout(null);
        container.setBackground(Color.LIGHT_GRAY);
        
        container.add(bravo);
        bravo.setBounds(75,100,250,50);
        
        container.add(quitter);
        quitter.addActionListener(quit);
        quitter.setBackground(Color.LIGHT_GRAY);
        quitter.setBounds(100,150,200,40);
        
        container.add(suiv);
        suiv.addActionListener(suivt);
        suiv.setBackground(Color.LIGHT_GRAY);
        suiv.setBounds(100,200,200,40);

        endScreen.setVisible(true);
    }
    
    public ActionListener quit = (ActionEvent e) -> {
        System.exit(0);  
    };
    
    public ActionListener suivt = (ActionEvent e) -> {
        
        
        this.board.LevelSuiv();
        this.window.changePan(3);
        this.endScreen.dispose();
        
    };
    
   
    /**
     * permet de mettre a jour la vue
     * @param board la plateau de jeu
     */    
    public void refresh(BoardGame board){
        
        this.board = board;
        this.repaint();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == quitter){
            
            System.out.println("quitter");
            System.exit(0);   
            
        }
        
       else if(source == suiv){
                      
            this.board.LevelSuiv();
            this.window.changePan(3);
            this.board.printBoard();
            this.refresh(this.board);;
            
           
        }
            
        
    }

    
    
}