
package sokoban.Token;

import sokoban.Game.BoardGame;

/**
 * <h1>La classe Token</h1>
 * <p>Token(pions) est la classe mere de BoX et Player</p>
 * <p>La classe Token correspond a toute les action commune du personnage et des boites </p>
 * <p>Les attribut de Token sont : </p>
 * <ul>
 *  <li> La possition X d'un token, de type int (posX)</li>
 *  <li> La possition Y d'un token, de type int (posY) </li>
 *  <li> Le plateau de jeu, de type BoardGame (board) </li>
 * </ul>
 *
 * @author  Abderrafii RABAH
 */

public class Token {
    /**
     * La possition en X d'un pions (soit le joueur ou une caisse).
     *
     * 
     */
    protected int posX;
    
    /**
     * La possition en Y d'un pions (soit le joueur ou une caisse).
     *
     * 
     */    
    protected int posY;
    
    /**
     * Le plateau de jeux où est situer un token.
     *
     * 
     */    
    protected BoardGame board;
    
    //////////////////////////// Constructeur //////////////////////////////////

    /**
     * Constructeur de la classe Token.
     * 
     * @param posX La possition X d'un Token
     * @param posY La possition Y d'un Token
     * @param board Le plateau où est situer le Token
     */
    public Token(int posX, int posY, BoardGame board) {

        this.posX = posX;
        this.posY = posY;
        this.board = board;
    }
    
    ////////////////////////////// Methodes ////////////////////////////////////

    /**
     * Récupère la possition futur X et Y d'un Token puis vérifie si cette futur possition correspond a un mur.
     * 
     * @param posX la possition X futur d'un Token
     * @param posY la possition Y futur d'un Token
     * 
     * 
     * @return un boolean correspondant a si la possition suivante est un mur .
     */
    public boolean posibilityMoveP(int posX, int posY){  
        
        return this.board.getBoard()[posX] [posY] == '#' /*||  this.board.getBoard()[posX] [posY] == '*'*/;
        
    }
    
    public boolean posibilityMoveC(int posX, int posY){  

        return this.board.getBoard()[posX] [posY] == '$' ||  this.board.getBoard()[posX] [posY] == '*' || this.board.getBoard()[posX] [posY] == '#';
        
    }
    
    
    /////////////////////////////// Getter /////////////////////////////////////
    /**
     * Récupère la possition futur X et Y d'un Token puis vérifie si cette futur possition correspond a un mur.
     * 
     * 
     * @return La possition X d'un token  .
     * 
     */
    public int getPosX(){
        return this.posX;
    }
    
    /**
     * Récupère la possition futur X et Y d'un Token puis vérifie si cette futur possition correspond a un mur.
     * 
     * 
     * @return La possition Y d'un token .
     * 
     */
    public int getPosY(){ 
        return this.posY;
    }
    
    /**
     * Récupère le plateau.
     * 
     * 
     * @return Le plateau de jeux  .
     * 
     */
    public BoardGame getBoard(){
        return this.board;
    }
    
     @Override
    public String toString (){
        return (" la possition de cette  "+ this.getClass() +" est :" + this.posX + " " + this.posY );
    }
}
