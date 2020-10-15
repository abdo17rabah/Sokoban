package sokoban.Token;


import sokoban.Game.BoardGame;



/**
 * <h1>La classe Player</h1>
 * <p>Player hérite de Token</p>
 * <p>La classe Player correspond a toute les action que le personnage peut faire </p>
 * <p>Les attribut de Player sont : </p>
 * <ul>
 *  <li> La possition X du personnage, de type int (posX)</li>
 *  <li> La possition Y du personnage, de type int (posY) </li>
 *  <li> Le plateau de jeu, de type BoardGame (board) </li>
 * </ul>
 * personnage du joueur
 * @author  Abderrafii RABAH
 */
public class Player extends Token{
    
    //////////////////////////// Constructeur //////////////////////////////////
    
    public static final char UP = 'u';
    public static final char DOWN = 'd';
    public static final char LEFT = 'l';
    public static final char RIGHT = 'r';
    
     /**
     * Constructeur de la classe Token (Box hérite de Token).
     *
     * @param posX La possition X du personnage
     * @param posY La possition Y du personnage
     * @param board Le plateau de jeu
     * 
     */
    public Player(int posX, int posY, BoardGame board) {
   
        super(posX, posY, board);
    }
    
    /////////////////////// Methodes de Deplacement ////////////////////////////
    /**
     * Récupère un input précis puis appèle la méthode de déplacement correspondante a la direction donnée.
     * 
     * @param str La direction choisit
     * 
     */
    public void inputMove(char str){
        
        
        switch (str)	{
            case RIGHT:
		//methode de déplacement vers la droite;
                this.right (this.board, this.posX, this.posY);
		break;
                
            case LEFT:
                //methode de déplacement vers la gauche;
                this.left (board, this.posX, this.posY);
                break;

            case UP:
                //methode de déplacement vers le haut;
                this.up (this.board, this.posX, this.posY );
                break;

            case DOWN:
                    //methode de déplacement vers le bas;
                    this.down (this.board, this.posX, this.posY);
                    break;
        }
        
        
        this.board.verifStatus();
        this.board.setBoxes();
        this.board.setZone();
        this.board.printBoard();
    }
    
    /**
     * 
     * Effectue un déplacement du personnage vers l'avant.
     * 
     * @param board le plateau du joueur
     * @param posX la possition X du joueur
     * @param posY  la possition Y du joueur
     * 
     */
    private void up (BoardGame board, int posX, int posY){
        
        System.out.println("up");
        
            if (!this.posibilityMoveP(this.posX-1,this.posY)){                
                
                if ((board.getBoard()[posX-1][posY]=='$' ||board.getBoard()[posX-1][posY]=='*' ) && !this.posibilityMoveC(this.posX-2, this.posY) ){
                    
                    System.out.println("box not wall");
                    System.out.println(board.getBoard()[posX-2][posY]);
                    
                    board.getBoard()[posX-2] [posY] = board.getBoard()[posX-1] [posY];
                    board.getBoard()[posX-1] [posY] = board.getBoard()[posX] [posY] ; 
                    this.posX = posX-1;                   
                    Box box = this.board.whereBox(this.posX,this.posY);
                    box.casesMoves('u');                   
                    board.getBoard()[posX] [posY] = ' ';
                    
                }
                
                
                else if (board.getBoard()[posX-1] [posY] != '$' && board.getBoard()[posX-1][posY]!='*' && board.getBoard()[posX-1][posY]!='#') {
                    
                    System.out.println("not box");
                    
                    board.getBoard()[posX-1] [posY] = board.getBoard()[posX] [posY];
                    board.getBoard()[posX] [posY] = ' ';                                
                    this.posX = posX-1;
                    
                }
                
                else{
                    
                    System.out.println("box bloqué");
                }
                
            }
        
    }
    
    /**
     * 
     * Effectue un déplacement du personnage vers le bas.
     * en vérifiant si le personnage peux ce déplacer et si oui ou non il déplace une boite
     * 
     * @param board le plateau du joueur
     * @param posX la possition X du joueur
     * @param posY  la possition Y du joueur
     * 
     */
    
    private void down (BoardGame board, int posX, int posY){
        
            System.out.println("down");
        
            if (!this.posibilityMoveP(this.posX+1,this.posY)){
                
                if ((board.getBoard()[posX+1][posY]=='$'|| board.getBoard()[posX+1][posY]=='*') && !this.posibilityMoveC(this.posX+2, this.posY) ){

                    System.out.println("box not wall");
                    System.out.println(board.getBoard()[posX+2][posY]);
                    
                    board.getBoard()[posX+2] [posY] = board.getBoard()[posX+1] [posY];
                    board.getBoard()[posX+1] [posY] = board.getBoard()[posX] [posY] ; 
                    this.posX = posX+1;
                    Box box = this.board.whereBox(this.posX,this.posY);
                    box.casesMoves('d');
                    board.getBoard()[posX] [posY] = ' ';
                    
                }


                else if (board.getBoard()[posX+1] [posY] != '$' && board.getBoard()[posX+1][posY] !='*' && board.getBoard()[posX+1][posY]!='#') {
                    
                    System.out.println("not box");
                    
                    
                    board.getBoard()[posX+1] [posY] = board.getBoard()[posX] [posY];
                    board.getBoard()[posX] [posY] = ' '; 
                    this.posX = posX+1;
                }
                
                
                else{
                    
                    System.out.println("box bloqué");
                    
                }
            }
            
        System.out.println(this);
        
    }
    /**
     * 
     * Effectue un déplacement du personnage vers la gauche.
     * en vérifiant si le personnage peux ce déplacer et si oui ou non il déplace une boite
     *
     * @param board le plateau du joueur
     * @param posX la possition X du joueur
     * @param posY  la possition Y du joueur
     * 
     */
    
    private void left (BoardGame board, int posX, int posY){
            
            System.out.println("left");

            if (!this.posibilityMoveP(this.posX,this.posY-1)){
                
                if ((board.getBoard()[posX][posY-1]=='$'||board.getBoard()[posX][posY-1]=='*') && !this.posibilityMoveC(this.posX, this.posY-2) ){                   
                    
                    System.out.println("box not wall");
                    System.out.println(board.getBoard()[posX][posY-2]);
                    
                    board.getBoard()[posX] [posY-2] = board.getBoard()[posX] [posY-1];
                    board.getBoard()[posX] [posY-1] = board.getBoard()[posX] [posY] ; 
                    this.posY = posY-1;
                    Box box = this.board.whereBox(this.posX,this.posY);
                    box.casesMoves('l');
                    board.getBoard()[posX] [posY] = ' ';

                }

                else if (board.getBoard()[posX] [posY-1] != '$' && board.getBoard()[posX][posY-1]!='*'&& board.getBoard()[posX][posY-1]!='#') {                  
                    
                    System.out.println("not box");
                    
                    board.getBoard()[posX] [posY-1] = board.getBoard()[posX] [posY];
                    board.getBoard()[posX] [posY] = ' '; 
                    this.posY = posY-1;

                }
                                
                else{
                    
                    System.out.println("box bloqué");
                    
                    
                }
            }
            
        System.out.println(this);
    }
    
    /**
     * Effectue un déplacement du personnage vers la gauche.
     * en vérifiant si le personnage peux ce déplacer et si oui ou non il déplace une boite
     * 
     * @param board le plateau du joueur
     * @param posX la possition X du joueur
     * @param posY  la possition Y du joueur
     * 
     */
    private void right (BoardGame board, int posX, int posY){
        
            System.out.println("right");       
        
            if (!this.posibilityMoveP(this.posX,this.posY+1)){
                                                
                if ((board.getBoard()[posX][posY+1]=='$'||board.getBoard()[posX][posY+1]=='*') && !this.posibilityMoveC(this.posX, this.posY+2) ){                                    
                    
                    System.out.println("box not wall");
                    System.out.println(board.getBoard()[posX][posY+2]);
                    
                    board.getBoard()[posX] [posY+2] = board.getBoard()[posX] [posY+1];
                    board.getBoard()[posX] [posY+1] = board.getBoard()[posX] [posY] ; 

                    this.posY = posY+1;
                    Box box = this.board.whereBox(this.posX,this.posY);
                    box.casesMoves('r');
                    board.getBoard()[posX] [posY] = ' ';
                    
                }
                
                else if(board.getBoard()[posX] [posY+1] != '$' && board.getBoard()[posX][posY+1] != '*' && board.getBoard()[posX][posY+1]!='#') {                   
                    
                    System.out.println("not box");
                    
                    board.getBoard()[posX] [posY+1] = board.getBoard()[posX] [posY];          
                    board.getBoard()[posX] [posY] = ' ';                                 
                    this.posY = posY+1;
                    
                }
                
                else{
                    
                    System.out.println("box bloqué");                
                    
                }
            }
        
    }
 
    
}
