
package AI.AStar;

import sokoban.Game.BoardGame;

/**
 * <h1>La classe MazeModel </h1>
 * <p>La classe MazeModel est la classe qui correspond a l'IA du jeu.</p>
 * <p>Les attribut de MazeModel sont : </p>
 * 
 * <ul>
 *  <li>Le terrain du jeu, de type BoardGame (maze)</li>
 *  <li>la solution du jeu la plus optimiser, de type String(solution)</li>
 * </ul>
 * 
 * @author  Abderrafii RABAH
 */
public class MazeModel {
    public BoardGame maze;
    public String solution;

    /**
     * Constructeur de la class MazeModel
     * 
     * @param maze un état du jeu, un plateau
     * @param s la solution pour arriver a cette état
     */
    MazeModel(BoardGame maze, String s) {
        this.maze = maze;
        this.solution = s;
    }
    
    /**
     * Retourne le terrain 
     * @return le terrain 
     */
    public BoardGame getMaze(){
        return this.maze;
    }
    
    /**
     * Retourne les direction pour arrivé a cette etat du jeu
     * @return les direction pour arrivé a cette etat du jeu
     */
    public String getSoluce(){
        return this.solution;
    }
}
