
package interfaceGraphique.control;



import interfaceGraphique.Game;
import java.awt.event.*;
import sokoban.Game.BoardGame;
/**
 * <h1>La classe ControlCaracter </h1>
 * <p>La classe ControlCaracter est la classe qui correspond aux déplacement du personnage sur le jeu(interface).</p>
 * <p>Les attribut de AStar sont : </p>
 * 
 * 
 * @author  Abderrafii RABAH
 */
public class ControlCaracter implements KeyListener {
    
    KeyEvent e;
    private BoardGame board;
    private Game game;
    
    public ControlCaracter (BoardGame board, Game game){
    
    this.board = board;
    this.game = game;
    
    
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
	int key = e.getKeyCode();
        System.out.println(key);
        
        switch (key){
            
            case KeyEvent.VK_UP : // si la touche enfoncée est celle du haut
                System.out.println("up");
                this.board.getPlayer().inputMove(board.getPlayer().UP);
                this.game.refresh(board);
                break;
            case KeyEvent.VK_LEFT: // si la touche enfoncée est celle de gauche
                System.out.println("left");
                this.board.getPlayer().inputMove(board.getPlayer().LEFT);
                this.game.refresh(board);
                break;
            case KeyEvent.VK_RIGHT: // si la touche enfoncée est celle de droite
                System.out.println("right");
                this.board.getPlayer().inputMove(board.getPlayer().RIGHT);
                this.game.refresh(board);
                break;
            case KeyEvent.VK_DOWN: // si la touche enfoncée est celle du bas
                System.out.println("down");
                this.board.getPlayer().inputMove(board.getPlayer().DOWN);
                this.game.refresh(board);
                break;
            
            
        }   
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
  
            
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}    
