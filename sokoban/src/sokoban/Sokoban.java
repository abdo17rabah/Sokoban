package sokoban;

import AI.AStar.AStar;
import sokoban.Game.BoardGame;
import interfaceGraphique.Window;
import java.io.IOException;
import levels.Levels_list;



/**
 * <h1>La classe Sokoban </h1>
 * <p>La classe Sokoban est la classe executable du jeu.</p>
 * 
 * @author  Abderrafii RABAH
 */

public class Sokoban {

    public static void main(String[] args) throws IOException {
        
        
        Levels_list lvl = new Levels_list();
        
        BoardGame game = new BoardGame(lvl);
        
        game.printBoard();
        
        Window window = new Window(game);
        
        //AStar ai = new AStar(game);
        //ai.pathFinding(game);

    }
    
    
}
