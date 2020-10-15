package sokoban.Game;

import java.util.ArrayList;
import sokoban.Game.BoardGame;
import sokoban.Token.Box;

/**
 * <h1>La classe Rules</h1>
 * <p>La classe Rules correspond a toute les regles que l'on doit respecter, la gestion du tour et les condition de victoire </p>
 * <p>L'attribut de Player est : </p>
 * <ul>
 *  <li> le tour, de type boolean (turn)</li>
 * </ul>
 *
 * @author  Abderrafii RABAH
 */

public class Rules { 
    /**
     * Un boolean qui permet la gestion des tours entre le joueur et la machine ou bien deux joueur qui s'affronte (ajout pour V4 cf fiche de route sur Forge et Cahier des charges).
     *
     * @see Rules#turn
     * 
     */
    private boolean turn ;
    
    ////////////////////////////// Methodes ////////////////////////////////////
    /**
     * Gere les tours des joueurs 
     * @param loop le tour actuel du jeu, si c'est au tour du joueur ou de l'IA
     */
    public void playerTurn (boolean loop){
        if (loop){
            this.turn = false;
            
        }
        
        this.turn = true ;

    }

    
    /**
     * Gere la Victoire des joueurs a l'aide d'un parcours des différentes caisses, si toute les caisses on leur status a true alors le jeux est fini. 
     * 
     * @param board un état du jeu
     * @return si la partie est fini ou pas .
     */
    public static boolean LevelEnd (BoardGame board){
       
        ArrayList<Box> box = board.getBoxes();
        
        if(box != null){
            int iterator = 0;

            for (Box i : box){
                if (i.getStatus()){
                    return true;
                }
                iterator ++;
            }
            if (iterator == box.size()){
                return false;
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    
    
}
