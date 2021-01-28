/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Home
 */
public class Dungeon {
    private int length;
    private int height;
    private int vampires;
    private ArrayList<Vampire> vampireList;
    private int moves;
    private boolean vampiresMove;
    private Player player;
    
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove, Player player){
        this.length = length;
        this.height = height;
        this.vampires = vampires;
        this.vampireList = new ArrayList<Vampire>();
        this.moves = moves;
        this.vampiresMove = vampiresMove;
        this.player = player;
    }
     
    public void run(){
        Scanner reader = new Scanner(System.in);
        this.generateVampires();
        while(!this.validateVampirePositions()){
            this.generateVampires();
        }
        while(moves>0){
            if(vampireList.size()==0){
                System.out.println("Congratulations, you won!");
                return;
            }
            System.out.println("Player has " + moves + " moves.");
            System.out.println("+--+-+-+-+-+--+");
            System.out.println("Player @ ("+player.getX() +", "+player.getY()+")");
        
            for(Vampire vampire: vampireList){
                System.out.println("v: " + vampire.vampirePosition());
            }
        
            System.out.println("");
            printSituation();
            
            String command = reader.nextLine();
            movePlayer(command);
            if(vampiresMove){
                moveVampires();
            }
            moves--;
        }
        
        /*while(moves>0){
            //print situation
            if(this.vampireList.size()==0){
                System.out.println("Congratz, you won!");
                return;
            }
            
            
            
            
            moves--;
        }*/
        
        
        System.out.println("You lost!");
    }
    
    public void movePlayer(String command){
        for(int i=0; i<command.length(); i++){
            int tempX = player.getX();
            int tempY = player.getY();
            player.move(command.charAt(i));
            if(validatePlayerMove()){
                killVampire();
            }
            else{
                player.setX(tempX);
                player.setY(tempY);
            }
            
            
        }
    }
    
    public boolean validatePlayerMove(){
        boolean valid = true;
        if(player.getX()>= this.length || player.getX()<0){
            valid = false;
        }
        else if(player.getY()>=this.height || player.getY()<0){
            valid = false;
        }
        return valid;
    }
    
    public void killVampire(){
        for(int i=0; i<vampireList.size(); i++){
            if(vampireList.get(i).getX() == player.getX() && 
                vampireList.get(i).getY() == player.getY()){
                vampireList.remove(vampireList.get(i));
            }    
        }
    } 
    
    
    public void generateVampires(){
        for(int i=0; i<vampires; i++){
            Vampire vampire= new Vampire(new Random().nextInt(this.height), new Random().nextInt(this.length));
            if(vampire.getX() == 0 && vampire.getY() == 0){
                vampire.setX(1 + new Random().nextInt(this.length-1));
            }
            vampireList.add(vampire);
        }
    }
    
    public void moveVampires(){
        for(Vampire vampire: vampireList){
            int tempX = vampire.getX();
            int tempY = vampire.getY();
            vampire.move();
            if(!validMove(vampire)){
                vampire.setX(tempX);
                vampire.setY(tempY);
            }
        }
    }
    
    public boolean validMove(Vampire vampire){
        boolean valid = true;
        if(vampire.getX()>=this.length || vampire.getX()<0){
            valid = false;
        }
        else if(vampire.getY()>=this.height || vampire.getY()<0){
            valid = false;
        }
        else if(Overlap()){
            valid = false;
        }
        return valid;
    }
    
    public boolean Overlap(){
        //check for overlapping positions
        for(int i=0; i<vampireList.size()-1; i++){
            for(int j = i+1; j<vampireList.size(); j++){
                if(vampireList.get(i).getX() == vampireList.get(j).getX() && 
                    vampireList.get(i).getY() == vampireList.get(j).getY()){
                    return true;
                }
            }
        }
        return false;
       
        
    }
     
    public boolean validateVampirePositions(){
        boolean valid = true;
        
        for(int i=0; i<vampireList.size()-1; i++){
            for(int j = i+1; j<vampireList.size(); j++){
                /*
                System.out.println(vampireList.get(i).vampirePosition());
                System.out.println(vampireList.get(j).vampirePosition());*/
                if(vampireList.get(i).getX() == vampireList.get(j).getX() && 
                    vampireList.get(i).getY() == vampireList.get(j).getY()){
                    valid = false;
                }
            }
        }
       
        if(valid == false){
            vampireList.clear();
        }
        return valid;   
    }
     
    public void printSituation(){
        for(int i=0; i<this.length; i++){
            for(int j=0; j<this.height; j++){
                if(player.getX() == j && player.getY() == i){
                    System.out.print("@");
                }
                else if(checkPosition(i,j)){
                    System.out.print("v");
                }
                else{
                    System.out.print(".");
                }
                
            }
            System.out.println("");
        }
    }
    
    public boolean checkPosition(int x, int y){
        for(Vampire vampire: vampireList){
            if(vampire.getY()==x && vampire.getX()==y){
                return true;
            }
            
        }
        return false;
    }
}
