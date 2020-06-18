import java.lang.Math; //This is imported to be able to find the max between two values
import java.util.*;

/**
 *
 * @author Gage Gutmann and Vincent Rettke
 */
public class Assignment3 {

    /**
     * @param args the command line arguments
     */
    public static int totalWeight = 0; // To be added incremetly when kSack is called upon
    public static String indices = ""; // To be concatenated with indices from kSack
    
    public static void main(String[] args) {
        
        
        
        //User input
        Scanner input = new Scanner(System.in);
        System.out.print("Maximum amount of weight that can be held: ");
        int maxWeight = input.nextInt();
        System.out.println();
        
        System.out.print("Number of items to consider: ");
        int numItems = input.nextInt();
        System.out.println();
        
        int weights[] = new int[numItems];
        int costs[] = new int[numItems];
        
        for(int i = 0; i < numItems; i++){
            System.out.print("item " + i + " weight: ");
            weights[i] = input.nextInt();
            System.out.println();
            
            System.out.print("item " + i + " cost: ");
            costs[i] = input.nextInt();
            System.out.println();
            
        }
        
        //Print out all the wieghts and costs 
        System.out.print("[Weights,$Cost]: ");
        
        for(int i = 0; i < numItems; i++){
            System.out.print("[" + weights[i] + ",$" + costs[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        
        //Call the kSack function and print out the total amounts
        System.out.println("Total Cost: " + kSack(weights, costs, maxWeight, numItems));
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        
    }
    
    public static int kSack(int[] weights, int[] costs, int maxWeight, int items){
        
        int sack[][] = new int[items + 1][maxWeight + 1]; //Make a 2D array out of the weights and costs
        
        for (int i = 0; i <= items; i++){ //Loop through rows and columns
            for(int j = 0; j <= maxWeight; j++){
                
                if(i == 0 || j == 0){ // This is the "base case" even though not recursive
                    sack[i][j] = 0;
                }else if(weights[i-1] <= j){ //Comparing values in row to column
                    sack[i][j] = Math.max(costs[i-1] + sack[i-1][j - weights[i-1]], sack[i-1][j]); //Takes the elements that are next to each other and takes the max values to be incremented
                }else{
                    sack[i][j] = sack[i-1][j];
                }
                
            }
        }
        int found = sack[items][maxWeight]; // This is the final element in array, which is the optimal cost
        int moreWeight = maxWeight;
        
        //Now we have to decrement back and dismiss those that are unimportant information (those that don't contribute to the final)
        for(int i = items; i > 0 && found > 0; i--){
            if(found != sack[i-1][moreWeight]){
                totalWeight += weights[i-1]; //Adds the weight to the total weight
                indices += (i-1 + " "); //Adds the indice to the list of indices 
                
                found -= costs[i-1]; //Decrements through resepctive arrays
                moreWeight -= weights[i-1];
            }
        }
        
        return sack[items][maxWeight]; //Optimal cost
        
    }
    
    
    
}
