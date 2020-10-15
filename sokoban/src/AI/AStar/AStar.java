package AI.AStar;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import levels.Levels;
import levels.Levels_list;
import sokoban.Game.BoardGame;
import sokoban.Token.Player;

/**
 * <h1>La classe AStar </h1>
 * <p>La classe AStar est la classe qui correspond a l'IA du jeu.</p>
 * <p>Les attribut de AStar sont : </p>
 * 
 * <ul>
 *  <li>Le terrain de basse du jeu, de type char [][] (start)</li>
 *  <li>Le terrain de fin du jeu, de type char [][] (end)</li>
 *  <li>Les déplacements possible du joueur, de type final char [] (direction) </li>
 *  <li>Le chemin le plus optimiser pour résoudre le niveau, de type String (path)</li>
 * </ul>
 * 
 * @author  Abderrafii RABAH
 */
public class AStar {

    private char[] [] end ;
    
    
    private final char[] direction = {Player.UP,Player.DOWN,Player.LEFT,Player.RIGHT};
    private String path;
    
    
    
    
    //////////////////////////// Constructeur //////////////////////////////////
    /**
     * Constructeur de la Class AStar
     * 
     * @param start plateau de départ
     */
    public AStar (BoardGame start){
        this.end = this.solver(start) ;
    }
    
    
    ////////////////////////////// Methode ////////////////////////////////////
    /**
     * Méthode qui permet de trouver le chemin le plus optimiser afin de résoudre le niveau
     * 
     * @param maze le plateau de jeux (etat actuel)
     * 
     * @return le chemin le plus optimiser pour la résolution du problème
     */
    public String pathFinding (BoardGame maze) throws IOException{
        this.end = this.solver(maze);
        String idTerrain = mazeConverter(maze);
        Set<String> closeSet = new HashSet<>();
        LinkedList<MazeModel> openSet = new LinkedList<>();
        //System.out.println(idTerrain);
        
        closeSet.add(idTerrain);   
        openSet.add(new MazeModel(maze, ""));

        while (!openSet.isEmpty()) {
           System.out.println("ok");
           MazeModel current = openSet.poll();
           BoardGame action = current.getMaze();
           String solution = current.getSoluce();
            
            for (int i = 0; i<direction.length; i++){
                System.out.println();
                BoardGame eltCurrent = copy(action);
                char move = direction[i];
                eltCurrent.getPlayer().inputMove(direction[i]);
                String terrain = mazeConverter(eltCurrent);
                System.out.println("openset siez : "+openSet.size());
                System.out.println("closeset siez : "+closeSet.size());
                System.out.println("terrain présent : "+closeSet.contains(terrain));
                System.out.println();System.out.println();
                eltCurrent.printBoard();
                

                if(!closeSet.contains(terrain)){
                    System.out.println('o');
                    String newSolution = solution + direction[i];
                    if ( comparator(eltCurrent.getBoard() , this.end)) {
                        this.setPath(newSolution);
                        System.out.println(newSolution);
                        return this.path;
                    }
                    
                    openSet.add(new MazeModel(eltCurrent,newSolution));
                    System.out.println("okoko");
                    closeSet.add(terrain);
                }
            }
            System.out.println(this.path);
        }
        return "pas de solution";
    }
    
    
    /**
     * Convertie le plateau tu BoardGame en String
     * 
     * @param maze un plateau
     * 
     * @return Le plateau convertie
     * 
     */
    public static String mazeConverter(BoardGame maze) {
        String s = "";
        char [] [] mazeS = maze.getBoard();
        for (int i = 0; i < mazeS.length; i++) {
            for(int j = 0 ; j< mazeS[i].length; j++){
                s += mazeS[i][j];
            }
            
        }
        return s;
    }
    
    /**
     * Copie un objet BoardGame donné
     * 
     * @param maze un BoardGame
     * 
     * @return une copy de ce BoardGame
     * 
     */
    private BoardGame copy(BoardGame maze) throws IOException{
        BoardGame board = new BoardGame(new Levels_list());
        
        board.setBoard(this.copyBoard(maze));
        //System.out.println("nouveau plateau");
        board.printBoard();
        //System.out.println();
        
        board.setPlayer();
        board.setBoxes();
        board.posZones();

        return board;  
    }
    
    /**
     * Permet de copier un tableau de type int [][]
     * 
     * @param maze le plateau de jeu
     * 
     * @return une copy du Board du plateau
     */
    private char [][] copyBoard(BoardGame maze){
        char [][] newBoard = new char [maze.getBoard().length][];
        
        for (int i = 0; i < maze.getBoard().length; i++){
            char [] lines = new char[maze.getBoard()[i].length];
            System.arraycopy(maze.getBoard()[i], 0, lines, 0, maze.getBoard()[i].length);
            newBoard[i] = lines;
        }
        return newBoard;
    }
    
    /**
     * La méthode solver permet de transformer l'état du jeu donné en l'état final, soit mettre les boites sur les zones 
     * @param maze un l'état du jeu 
     * @return la version résolut du niveau
     */
    public char[][] solver(BoardGame maze) {
        char[][] board = this.copyBoard(maze);
        for (int i = 0; i< board.length; i++){
            for (int j = 0; j< board[i].length; j++){
                if (board[i][j] == '$'){
                    board[i][j] = ' ';
                }
                if (board[i][j] == '.'){
                    board[i][j] = '*';
                }

            }
        }
        return board;
    }
    
    /////////////////////////////// Setter /////////////////////////////////////
    /**
     * Set le chemin le plus optimiser
     * 
     * @param path le chemin le plus optimiser
     */
    public void setPath(String path){
        this.path = path ;
    }
    
    
    /**
     * permet de Set le résultat du terrain attendu
     * 
     * @param end le terrain attendu a la fin du niveau
     */
    public void setEnd (char [] [] end){
        this.end = end ;
    }
    
    /////////////////////////////// Getter /////////////////////////////////////
    /**
     * Récupère le chemin le plus optimiser
     * @return le chemin le plus optimiser
     */
    public String getPath () {
        return this.path ;
    }
    
    public char[][] getEnd(){
        return this.end;
    }
    
    /**
     * méthode d'affichage
     * 
     * @param board un tableau de int [][] (2 dimenssions)
     */
    public void printBoard (char[][] board) {       
        for( int i = 0; i < board.length; i++) {
            
                System.out.println(" ");
          
            for( int j = 0; j < board[i].length; j++) {
              
                System.out.print(" "+board[i][j]);
            } 
        } 
    }
    
    /**
     * méthode qui compare deux tableau de int []][]
     * 
     * @param start un tableau de int [][]
     * @param end un second tableau de int[]
     * 
     * @return boolean si les tableaux sont les mêmes
     */
    private boolean comparator(char[][] start , char[][] end){
        for (int i = 0; i < start.length; i++){
            for (int j = 0 ; j < start[i].length ; j++){

                if (start[i] [j] != end[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    
    ///////////////////////////// Affichage ////////////////////////////////////
    @Override
    public String toString (){
        return ("le chemin le plus optimisé est : " +this.path );
    }
}
