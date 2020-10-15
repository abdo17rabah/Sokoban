
package interfaceGraphique;


import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * <h1>La classe Load </h1>
 * <p>La classe Load est la classe qui permet de charger les images pour le jeu.</p>
 * <p>Les attribut de Load sont : </p>
 * 
 * <ul>
 *  <li>L'image qui correspond aux wall</li>
 *  <li>L'image qui correspond aux ground</li>
 *  <li>L'image qui correspond aux box</li>
 *  <li>L'image qui correspond au player</li>
 *  <li>L'image qui correspond aux trueBox</li>
 *  <li>L'image qui correspond aux zones</li>
 * </ul>
 * 
 * @author  Abderrafii RABAH
 */

public class Load {
    
    public static Image wall;
    private static Image ground;
    private static Image box;
    private static Image player;
    private static Image trueBox;
    private static Image zones;
    
    /**
     * Méthode qui permet de charger une image qui ce situe dans le fichier images.
     */
    public Load(){
        try{
            this.wall = ImageIO.read(new File("src/interfaceGraphique/images/Wall.jpg"));
            this.ground = ImageIO.read(new File("src/interfaceGraphique/images/Ground.jpg"));
            this.box = ImageIO.read(new File("src/interfaceGraphique/images/Box.jpg"));
            this.player = ImageIO.read(new File("src/interfaceGraphique/images/Player.png"));
            this.trueBox = ImageIO.read(new File("src/interfaceGraphique/images/BoxValid.jpg"));
            this.zones = ImageIO.read(new File("src/interfaceGraphique/images/Zones.png"));
            
        } catch (IOException ex) {
            System.out.println("fichier introuvable");
        }
    }
    
    /**
     * Méthode qui retourne l'image du mur
     * @return Méthode qui retourne l'image du mur
     */
    public Image getWall(){
        return this.wall;
    }
    
    /**
     * Méthode qui retourne l'image du sol
     * @return Méthode qui retourne l'image du sol
     */
    public Image getGround(){
        return this.ground;
    }
    
    /**
     * Méthode qui retourne l'image d'une boite
     * @return Méthode qui retourne l'image d'une boite
     */
    public Image getBox(){
        return this.box;
    }
    
    /**
     * Méthode qui retourne l'image du joueur
     * @return Méthode qui retourne l'image du joueur
     */
    public Image getPlayer(){
        return this.player;
    }
    
    /**
     * Méthode qui retourne l'image d'une validBox
     * @return Méthode qui retourne l'image d'une validBox
     */
    public Image getValidBox(){
        return this.trueBox;
    }
    
    /**
     * Méthode qui retourne l'image d'une zone
     * @return Méthode qui retourne l'image d'une zone
     */
    public Image getZones(){
        return this.zones;
    }

}
