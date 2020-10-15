
package sokoban.Token;


import sokoban.Game.BoardGame;

/**
 * <h1>La classe Goal</h1>
 * <p>Goal hérite de Token</p>
 * <p>La classe Goal correspond a toute les zones du plateau </p>
 * <p>Les attribut de Goal sont : </p>
 * <ul>
 *  <li> La possition X du personnage, de type int (posX)</li>
 *  <li> La possition Y du personnage, de type int (posY) </li>
 *  <li> Le plateau de jeu, de type BoardGame (board) </li>
 * </ul>
 *
 * @author  Abderrafii RABAH
 */
public class Goal extends Token {
    /**
     * Constructeur de la class Goal
     * @param posX la possition X de la zone 
     * @param posY la possition Y de la zone
     * @param board le boardGame qui contient la zone
     */
    public Goal(int posX, int posY, BoardGame board) {
        super(posX, posY, board);
    }
               
}
