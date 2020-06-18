import java.lang.Math; //This is imported to be able to find the max between two values
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

/*
 * Analysis: I was unable to get the memoization algorithm to run properly. Because of my implementation
   I kept getting 1 off errors that I was unable to fix. From what I could tell, by increasing problem size
   in my tests, these algorithms grows exponentially. The amount of time for the algorithms to run, over time, grew to 
   to the hundreds and then thousands of milliseconds. It is from my understanding that these two algorithms run near the 
   same time, however the memoization algorithm can tend to slow down somewhat in intermediary problem sizes compared to 
   the other algorithm. 
 */

/**
 *
 * @author Gage Gutmann
 */
public class Assignment4 {

    public static int totalWeight = 0; // To be added incremetly when kSack is called upon
    public static String indices = ""; // To be concatenated with indices from kSack
    public static double memoHits = 0.0;// Counts the hits in the backtrace to help calculate percentage
    public static double memoPercentage = 0.0;
    
    public static void main(String[] args) throws InterruptedException{
        
        Random rand = new Random();
        
        int[] costs1 = new int[10];
        int[] weights1 = new int[10];
        int maxWeight1 = 25;
        int numItems1 = 10;
        costs1 = rand.ints(10,1,10).toArray();
        weights1 = rand.ints(10,1,10).toArray();
        
        int[] costs2 = new int[50];
        int[] weights2 = new int[50];
        int maxWeight2 = 125;
        int numItems2 = 50;
        costs2 = rand.ints(50,1,10).toArray();
        weights2 = rand.ints(50,1,10).toArray();
        
        int[] costs3 = new int[100];
        int[] weights3 = new int[100];
        int maxWeight3 = 250;
        int numItems3 = 100;
        costs3 = rand.ints(100,1,10).toArray();
        weights3 = rand.ints(100,1,10).toArray();
        
        int[] costs4 = new int[500];
        int[] weights4 = new int[500];
        int maxWeight4 = 1250;
        int numItems4 = 500;
        costs4 = rand.ints(500,1,10).toArray();
        weights4 = rand.ints(500,1,10).toArray();
        
        int[] costs5 = new int[1000];
        int[] weights5 = new int[1000];
        int maxWeight5 = 2500;
        int numItems5 = 1000;
        costs5 = rand.ints(1000,1,10).toArray();
        weights5 = rand.ints(1000,1,10).toArray();
        
        int[] costs6 = new int[10000];
        int[] weights6 = new int[10000];
        int maxWeight6 = 25000;
        int numItems6 = 10000;
        costs6 = rand.ints(10000,1,10).toArray();
        weights6 = rand.ints(10000,1,10).toArray();
        
        int[] costs7 = new int[100000];
        int[] weights7 = new int[100000];
        int maxWeight7 = 250000;
        int numItems7 = 100000;
        costs7 = rand.ints(100000,1,10).toArray();
        weights7 = rand.ints(100000,1,10).toArray();
        
        /*
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
        */
        
        //Print out all the wieghts and costs 
        System.out.print("Set 1 [Weights,$Cost]: ");
        
        for(int i = 0; i < numItems1; i++){
            System.out.print("[" + weights1[i] + ",$" + costs1[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        System.out.print("Set 2 [Weights,$Cost]: ");
        
        for(int i = 0; i < numItems2; i++){
            System.out.print("[" + weights2[i] + ",$" + costs2[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        System.out.print("Set 3 [Weights,$Cost]: ");
        
        for(int i = 0; i < numItems3; i++){
            System.out.print("[" + weights3[i] + ",$" + costs3[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        System.out.print("Set 4 [Weights,$Cost]: ");
        
        for(int i = 0; i < numItems4; i++){
            System.out.print("[" + weights4[i] + ",$" + costs4[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        System.out.print("Set 5 [Weights,$Cost]: ");
        
        for(int i = 0; i < numItems5; i++){
            System.out.print("[" + weights5[i] + ",$" + costs5[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        System.out.print("Set 6 [Weights,$Cost]: ");
        
        for(int i = 0; i < numItems6; i++){
            System.out.print("[" + weights6[i] + ",$" + costs6[i] + "] ");
        }
        System.out.println();
        System.out.println();
        
        
        //Call the kSack function and print out the total amounts
        System.out.println("Data Set 1");
        System.out.println();
        System.out.println("kSack");
        long startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights1, costs1, maxWeight1, numItems1));
        long endTime = System.currentTimeMillis();
	long timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        //return the global variables to 0
        totalWeight = 0;
        indices = "";
        
        /*
         //Call the memo function and print out the total amounts
        System.out.println("memo");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + memo(weights1, costs1, maxWeight1, numItems1));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Percentage Table is used: " + memoPercentage);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        System.out.println(memoHits);
        
        totalWeight = 0;
        indices = "";
        memoHits = 0.0;
        memoPercentage = 0.0;
        */
        
        System.out.println("Data Set 2");
        System.out.println();
        System.out.println("kSack");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights2, costs2, maxWeight2, numItems2));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        /*
        System.out.println("memo");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + memo(weights2, costs2, maxWeight2, numItems2));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Percentage Table is used: " + memoPercentage);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        memoHits = 0.0;
        memoPercentage = 0.0;
        */
        System.out.println("Data Set 3");
        System.out.println();
        System.out.println("kSack");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights3, costs3, maxWeight3, numItems3));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        /*
        System.out.println("memo");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + memo(weights3, costs3, maxWeight3, numItems3));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Percentage Table is used: " + memoPercentage);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        memoHits = 0.0;
        memoPercentage = 0.0;
        */
        System.out.println("Data Set 4");
        System.out.println();
        System.out.println("kSack");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights4, costs4, maxWeight4, numItems4));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        /*
        System.out.println("memo");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + memo(weights4, costs4, maxWeight4, numItems4));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Percentage Table is used: " + memoPercentage);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        memoHits = 0.0;
        memoPercentage = 0.0;
        */
        System.out.println("Data Set 5");
        System.out.println();
        System.out.println("kSack");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights5, costs5, maxWeight5, numItems5));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        /*
        System.out.println("memo");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + memo(weights5, costs5, maxWeight5, numItems5));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Percentage Table is used: " + memoPercentage);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        memoHits = 0.0;
        memoPercentage = 0.0;
        */
        System.out.println("Data Set 6");
        System.out.println();
        System.out.println("kSack");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights6, costs6, maxWeight6, numItems6));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        /*
        System.out.println("memo");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + memo(weights6, costs6, maxWeight6, numItems6));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Percentage Table is used: " + memoPercentage);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        memoHits = 0.0;
        memoPercentage = 0.0;
        */
        
        //May cause heap space error
        System.out.println("Data Set 7");
        System.out.println();
        System.out.println("kSack");
        startTime = System.currentTimeMillis();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("Total Cost: " + kSack(weights7, costs7, maxWeight7, numItems7));
        endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Indices: " + indices);
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println();
        
        totalWeight = 0;
        indices = "";
        
    }
    
    //This function was implemented from the previous assignment. I worked with 
    //Vincent Rettke on this. I wanted to point this out if this particular 
    //algorithm is the same for this assignment
    
    public static int kSack(int[] weights, int[] costs, int maxWeight, int items){
        
        int sack[][] = new int[items+1][maxWeight+1]; //Make a 2D array out of the weights and costs
        
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
    
    public static int memo(int[] weights, int[] costs, int maxWeight, int items){
        int tableF[][] = new int[items+1][maxWeight+1]; 
        
        for(int i = 0; i < items+1; i++){
            for(int j = 0; j < maxWeight+1; j++){
                if((i == 0)|| (j == 0)){
                    tableF[i][j] = 0;
                }else{
                    tableF[i][j] = -1;
                }
            }
        }
        
        /*
        for(int i = 0; i < items +1; i++){
            for(int j = 0; j < maxWeight +1; j++){
                System.out.print(tableF[i][j] + " ");
            }
            System.out.println();
        }
        */
        
        if(tableF[items-1][maxWeight-1] < 0){
            if(maxWeight < weights[items-1]){
                tableF[items-1][maxWeight-1] = memo(weights, costs, items-1 , maxWeight);
            }else{
                tableF[items-1][maxWeight-1] = Math.max((memo(weights, costs, items-1, maxWeight)), costs[items-1] + memo(weights, costs,items-1, (maxWeight) - weights[items-1]));
            }
        }
        
        int found = tableF[items][maxWeight]; // This is the final element in array, which is the optimal cost
        int moreWeight = maxWeight;
        
        //Now we have to decrement back and dismiss those that are unimportant information (those that don't contribute to the final)
        for(int i = items; i > 0 && found > 0; i--){
            if(found != tableF[i-1][moreWeight]){
                totalWeight += weights[i-1]; //Adds the weight to the total weight
                indices += (i-1 + " "); //Adds the indice to the list of indices 
                memoHits++;
                
                found -= costs[i-1]; //Decrements through resepctive arrays
                moreWeight -= weights[i-1];
            }
        }
        
        memoPercentage = (memoHits / ((items+1)*(maxWeight+1)));
        
        return tableF[items][maxWeight];
    }
    
}
