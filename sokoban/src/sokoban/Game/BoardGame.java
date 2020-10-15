package sokoban.Game;




import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;
import levels.Levels;
import levels.Levels_list;
import sokoban.Token.Box;
import sokoban.Token.Goal;
import sokoban.Token.Player;


/**
 * <h1>La classe BoardGame </h1>
 * <p>La classe BoardGame permet de construire un plateau de jeu </p>
 * <p>Les attribut de BoardGame sont : </p>
 * <ul>
 *  <li> Un Joueur, de type Player(player).</li>
 *  <li> D'une liste des possition de toute les boites, de type Box (boxes) .</li>
 *  <li> D'un nombre de case dans le plateau (constante), de type int(numberOfCase).</li>
 *  <li> D'une liste dites de "zone", qui correspond au zone où doivent aller les boites, de type ArrayList de Pair(zones).</li>
 *  <li> D'un plateau de jeu (board) qui est une liste de int, de type int [] [] (board).<li>
 * </ul>
 *
 * @author  Abderrafii RABAH
*/
public class BoardGame {
    /**
     * Le personnage que le joueur controle.
     *
     * 
     */
    private Player player ;
    
    /**
     * Liste de toute les boites du plateau.
     *
     * 
     */
    private ArrayList<Box> boxes;
    
    
    /**
     * Liste de toute les zones du plateau.
     *
     * 
     */
    private ArrayList<Goal> zones;
    
    
    
    /**
     * Le plateau de jeu.
     *
     * 
     */ 
    private char board [][] ;
    
    private ArrayList<Levels> levels;
    
     private int lvlNumber = 0;
    private final Levels_list levels_list;
    
    //////////////////////////// Constructeur //////////////////////////////////
    
    /**
     * Constructeur de la classe BoardGame.
     * 
     * @param levels_list la liste de tout les niveau du jeu
     */
    public BoardGame(Levels_list levels_list){
        
        this.levels_list = levels_list;
        this.levels = levels_list.getLevels();       
        this.board = levels.get(lvlNumber).getLevel();
        
        try{
            this.setPlayer() ;
            this.setBoxes() ;
            this.posZones() ;
        }
        catch(Exception e){
        
        }
    }
    
    /**
     * Constructeur par defaut de la class BoardGame
     */
    public BoardGame (){
        this(null);
    }
    
    
    

    ////////////////////////////// Methodes ////////////////////////////////////
    
    /**
     * Verifie si une boite est sur la possition d'une zone, si cela est vrai alors on change le statut de la boite.
     * 
     */        
    public void verifStatus(){
    
        
        for (Box b : this.boxes){
            for (Goal i : this.zones){
                if (i.getPosX() == b.getPosX() && (int)i.getPosY() == b.getPosY()){
                        this.board[b.getPosX()][b.getPosY()] = '*';
                        b.setStatus(false);
                    } else {
                        b.setStatus(true);
                        //this.board[b.getPosX()][b.getPosY()] = '$';
                } 
            }
        }
        
    }
   
    /**
     * Verifie si la possition d'une des boites du plateau est proche de la possition du joueur.
     * 
     * @param posX correspond a la possition du personnage en X.
     * @param posY correspond a la possition du personnage en Y.
     * 
     * @return La boite qui est au contacte avec le joueur.
     * 
     */
    
    public Box whereBox (int posX, int posY){
    
        
        for (Box i : this.boxes){

            if (i.getPosX() == posX && i.getPosY()== posY) {
                
                return i;
            }    
       
        }
        
        return null;
    }
    
    /**
     * Retourn si le jeu est fini, si il n'y a plus de zone.
     * @return Retourn si le jeu est fini 
     */
    public boolean haveNoZone(){
        for (int x = 0; x < this.board.length ; x++){

            for (int y = 0 ; y < this.board[0].length; y++){
                
                if(this.board[x][y] == '.'){
                    return false;
                }
            }          
        }
            
        return true;
    }
    
    /**
     * Permet de passer au niveau suivant .
     */
    public void LevelSuiv (){
        
        if(lvlNumber == this.levels_list.getNbLevels()-1){
        
            this.lvlNumber = 0;
            this.board = levels.get(0).getLevel();
            
            try{
            this.setPlayer() ;
            this.setBoxes() ;
            this.posZones() ;
            }
             catch(Exception e){
        
            }
            
       }
        
        else{
            
            this.lvlNumber += 1;
            this.board = levels.get(lvlNumber).getLevel();
            
            try{
            this.setPlayer() ;
            this.setBoxes() ;
            this.posZones() ;
            }
            catch(Exception e){
        
            }
            
        }
    }
    
    /////////////////////////////// Setter /////////////////////////////////////
    
    /**
     * Initialise le joueur du plateau en parcourant le plateau
     * 
     */    
    public void setPlayer(){
        for (int i = 0; i< this.board.length;i++){
            for (int j = 0; j< this.board[i].length; j++){
                
                if(this.board[i][j] == '@'){
                    this.player = new Player(i,j,this);
                }
            }
                
        }
    }
    
    /**
     * Set le player sur le plateau
     * 
     * @param player le joueur situer sur le plateau 
     * 
     */
    public void setPlayer(Player player){
        this.player = player;
    }
    
    /**
     * Parcourt le plateau de jeux afin de placer les zones.
     * 
     */
    public void setZone(){
    

        for(Goal i : this.zones ) {
            
            if(this.board[i.getPosX()][i.getPosY()] == ' '){
                           
                this.board[i.getPosX()][i.getPosY()] = '.';
            }
            
        }
        
    }
    /**
     * Parcourt le plateau de jeux afin de placer les boites.
     * 
     * 
     * 
     */
    public void setBoxes(){
    
    ArrayList<Box> boxes = new ArrayList();
    for (int i = 0; i<this.board.length; i++){
        for(int j = 0; j< this.board[i].length; j++){
            if (this.board[i][j] == '$' || this.board[i][j] == '*'){
                boxes.add(new Box(i,j,this));
            }
        }
    }
        this.boxes = boxes;        
    }
    
    /**
     * Permet de changer le plateau du jeux. 
     * 
     * @param maze le terain du plateau
     */
    public void setBoard(char[][] maze){
        this.board = maze;
    }
    
    /////////////////////////////// Getter /////////////////////////////////////
    /**
     * Parcourt le plateau de jeux afin de récupérer la possition des zones.
     * 
     * 
     */
    public void posZones (){
    
        
        ArrayList<Goal> listZones = new ArrayList();
        
        for( int i = 0; i < this.board.length; i++) {
          
            for( int j = 0; j < this.board[i].length; j++) {
                
                if (this.board [i][j] == '.'){
                    
                    Goal pos = new Goal(i, j, this);
                    listZones.add(pos);
                    
                }
                
            }
        }
        
        this.zones = listZones;
    }
    
    /**
     * Retour la possition du joueur sur le plateau.
     * 
     * @return un objet Pair qui correspond au coordonnée du joueur . 
     * 
     */
    public Pair posPlayer (){
    
        
        for( int i = 0; i < this.board.length; i++) {
          
            for( int j = 0; j < this.board[i].length; j++) {
              
                if (board[i][j] == '@'){
                    
                    return new Pair<>(i, j);                  
                }
            }
        }    
                
        return new Pair<>(-1, -1); 
        
    }
    
    /**
     * Retour la possition d'une boite sur le plateau.
     * 
     * @return un objet Pair qui correspond au coordonnée d'une boites .
     * 
     */
    public Pair posBox(){
    
        
        for( int i = 0; i < this.board.length; i++) {
          
            for( int j = 0; j < this.board[i].length; j++) {
                if (this.board[i][j] == '$' || this.board[i][j] == '.'){
                    return new Pair<>(i,j);
                }
                
            }
        }
        return new Pair<>(-1,-1);
    }
    
    public ArrayList <Goal> getZone(){
            return zones;
        }

    public ArrayList<Box> getBoxes (){
        return this.boxes;
    }
    
    /**
     * Retour le plateau de jeu.
     * 
     * @return le plateau .
     * 
     */
    public char [][] getBoard(){
    
        return this.board ;
    }
    
    /**
     * Retour le nombre de case du plateau de jeu.
     * 
     * @return le nombre de case(s) .
     * 
     */
    
    public Player getPlayer(){
        return this.player;
    }
    
    
    ///////////////////////////// Affichage ////////////////////////////////////
    /**
     *
     * Affiche le plateau sur l'inviter de commande
     *  
     */   
    public void printBoard () {
         
        for( int i = 0; i < this.board.length; i++) {
            
                System.out.println(" ");
          
            for( int j = 0; j < this.board[i].length; j++) {
              
                System.out.print(" "+this.board[i][j]);
            } 
        } 
    }
        
}
