/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonus2;

import dungeon.Dungeon;
import dungeon.Player;
import dungeon.Vampire;

/**
 *
 * @author Home
 */
public class Bonus2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Player amar = new Player();
        Dungeon dungeon = new Dungeon(5, 5, 4, 10, true, amar);
        
       
        dungeon.run();
        
    }
    
}
