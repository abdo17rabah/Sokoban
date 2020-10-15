package sokoban.Token;

import sokoban.Token.Token;
import java.util.ArrayList;
import javafx.util.Pair;
import sokoban.Game.BoardGame;

/**
 * <h1>La classe Box</h1>
 * <p>Box hérite de Token</p>
 * <p>La classe Box correspond a toute les méthode qui on un effet sur le jeu comme les déplacements et sont status  </p>
 * <p>Les attribut de Box sont : </p>
 * <ul>
 *  <li> La possition X d'une boite, de type int (posX)</li>
 *  <li> La possition Y d'une boite, de type int (posY) </li>
 *  <li> Le plateau de jeu, de type BoardGame (board) </li>
 * </ul>
 *
 * @author  Abderrafii RABAH
 */




public class Box extends Token{
    /**
     * Le statut d'un caise correspond si oui ou non elle est possitionner sur une zones (cf BoardGames zones).
     *
     * @see Box#status
     * 
     */
    private boolean status = true;
    
    //////////////////////////// Constructeur //////////////////////////////////
    /**
     * Constructeur de la classe Token (Box hérite de Token).
     *
     * @param posX La possition X d'une boite
     * @param posY La possition Y d'une boite
     * @param board Le plateau de jeu
     * 
     */
    public Box(int posX, int posY, BoardGame board) {
    
        super(posX, posY, board);
    }
    
    ////////////////////////////// Methodes ////////////////////////////////////

    /**
     * Récupère l'input du joueur puis modifie la possition de l'objet déplacer
     * @param input la direction choisit par le joueur
     */
    public void casesMoves(char input){
    
        switch (input){
            case 'u':
                this.posX -= 1 ;
                break;
             
            case 'd' :
                this.posX += 1 ;
                break;
                
            case 'l':   
                this.posY -= 1 ;
                break;
            
            case 'r' :
                this.posY += 1 ;
                break;
        }
    }
    
    /**
     * vérifie si une boite est sur une zone afin de changer sont statut
     * 
     * @param listBox la liste des Box sur le plateau
     * @param posZone la liste des Zone sur le plateau
     */
    public static void verifPos(ArrayList<Box> listBox, ArrayList<Goal> posZone){
        for (Box i: listBox){
            for (Goal j : posZone) {
                
                if (i.posX == (int)j.getPosX() && i.posY == (int)j.getPosY()){
                    i.setStatus(false);                   
                    break;
                }
                
                else{
                    i.setStatus (true);
                }
                
            }
        }
        
        
    }

    
    /////////////////////////////// Getter /////////////////////////////////////
    /**
     * Récupère le status d'une boite.
     * 
     * @return Le status de la boite  .
     * 
     */
    public boolean getStatus(){
        return this.status;
    }

    
     
    /////////////////////////////// Setter /////////////////////////////////////
    /**
     * Permet de modifier le status d'une boite selon sont status actuel.
     * 
     */
    public void setStatus(boolean status) {
        if (status == true){
            this.status = true;
        }
        else {
            this.status = false;
        }
    }
    
    
    /////////////////////////////// Message/////////////////////////////////////

    
    public String toString(){
        return (" la possition de cette  "+ this.getClass() +" est :" + this.posX + " " + this.posY + " "+ this.status);
    }
    
}
