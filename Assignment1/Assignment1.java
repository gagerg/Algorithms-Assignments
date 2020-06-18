/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gager
 */
public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(floorCompute(37));
        System.out.println(floorCompute(23));
        System.out.println(floorCompute(15));
        
    }
    
    public static int floorCompute(int n){ 
        int bottom = 1; //Can't go below this 
        int top = n; //Dont want to go above the integer
        int target;
        
        while(bottom <= top){
            target = (bottom+top)/2; 
            
            if(Math.pow(target, 2) == n){ //Case of perfect square
                return target;
            }
            
            if(Math.pow(target, 2) > n){ //Makes sure the target is floored
                top = target - 1;
            }else{
                bottom = target + 1; //Narrows the binary search
            }  
            
        }
        
        return top;
    }
    
}

