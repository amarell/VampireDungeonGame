/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Home
 */
public class Player {
    private int x;
    private int y;

    public Player() {
        this.x = 0;
        this.y = 0;
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
    
    public void move(char letter){
        if(letter == 's'){
            this.y = y+1;
        }
        else if(letter=='w'){
            this.y = y-1;
        }
        else if(letter=='a'){
            this.x = x-1;
        }
        else if(letter=='d'){
            this.x = x+1;
        }
        
    }
}
