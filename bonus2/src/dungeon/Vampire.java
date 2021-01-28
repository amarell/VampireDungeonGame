/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.Random;

/**
 *
 * @author Home
 */
public class Vampire {
    private int x;
    private int y;
    private static final char[] moves = new char[]{
        'w', 's', 'a', 'd'
    };

    public Vampire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public String vampirePosition(){
        return "("+this.x + ", "+this.y+")";
    }
    
    public void move(){
        int randomIndex = new Random().nextInt(4);
        char move = moves[randomIndex];
        if(move == 'a'){
            this.x = x-1;
        }
        else if(move == 'd'){
            this.x = x+1;
        }
        else if(move == 's'){
            this.y = y+1;
        }
        else if(move == 'w'){
            this.y--;
        }
    }
}
