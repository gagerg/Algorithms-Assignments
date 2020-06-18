import java.util.concurrent.TimeUnit;
import java.util.Random;

/**
 *
 * @author Gage Gutmann and Vincent Rettke
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        int[] array1 = new int[100];
        int[] array2 = new int[100];
        int[] array3 = new int[100];
        int[] array4 = new int[1000];
        int[] array5 = new int[1000];
        int[] array6 = new int[1000];
        int[] array7 = new int[100000];
        int[] array8 = new int[100000];
        int[] array9 = new int[100000];
        
        Random rand = new Random();
        
        
        array1 = rand.ints(100,10,10000).toArray();
        System.out.print("Array 1: ");
        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        
        array2 = rand.ints(100,10,10000).toArray();
        System.out.print("Array 2: ");
        for(int i = 0; i < array2.length; i++){
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        
        array3 = rand.ints(100,10,10000).toArray();
        System.out.print("Array 3: ");
        for(int i = 0; i < array3.length; i++){
            System.out.print(array3[i] + " ");
        }
        System.out.println();
        
        array4 = rand.ints(1000,10,10000).toArray();
        System.out.print("Array 4: ");
        for(int i = 0; i < array4.length; i++){
            System.out.print(array4[i] + " ");
        }
        System.out.println();
        
        array5 = rand.ints(1000,10,10000).toArray();
        System.out.print("Array 5: ");
        for(int i = 0; i < array5.length; i++){
            System.out.print(array5[i] + " ");
        }
        System.out.println();
        
        array6 = rand.ints(1000,10,10000).toArray();
        System.out.print("Array 6: ");
        for(int i = 0; i < array6.length; i++){
            System.out.print(array6[i] + " ");
        }
        System.out.println();
        
        array7 = rand.ints(100000,10,10000).toArray();
        System.out.print("Array 7: ");
        for(int i = 0; i < array7.length; i++){
            System.out.print(array7[i] + " ");
        }
        System.out.println();

        
       array8 = rand.ints(100000,10,10000).toArray();
        System.out.print("Array 8: ");
        for(int i = 0; i < array8.length; i++){
            System.out.print(array8[i] + " ");
        }
        System.out.println();
        
        
       array9 = rand.ints(100000,10,10000).toArray();
        System.out.print("Array 9: ");
        for(int i = 0; i < array9.length; i++){
            System.out.print(array9[i] + " ");
        }
        System.out.println();
        
        System.out.println("sieve with array 1");
        long startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array1.length; i++){
            sieve(array1[i]);
        }
	long endTime = System.currentTimeMillis();
	long timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("sieve with array 4");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array4.length; i++){
            sieve(array4[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("sieve with array 7");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array7.length; i++){
            sieve(array7[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        
        System.out.println("euclid with array 2 and array 3");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array2.length; i++){
            euclid(array2[i],array3[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("euclid with array 5 and array 6");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array5.length; i++){
            euclid(array5[i],array6[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("euclid with array 8 and array 9");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array8.length; i++){
            euclid(array8[i],array9[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("consecutive with array 2 and array 3");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array2.length; i++){
            consecutive(array2[i],array3[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("consecutive with array 5 and array 6");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array5.length; i++){
            consecutive(array5[i],array6[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
        System.out.println("consecutive with array 8 and array 9");
        startTime = System.currentTimeMillis();
	TimeUnit.SECONDS.sleep(5);
        for(int i = 0; i< array8.length; i++){
            consecutive(array8[i],array9[i]);
        }
	endTime = System.currentTimeMillis();
	timeElapsed = endTime - startTime-5000;
	System.out.println("Execution time in milliseconds: " + timeElapsed);
        
    }
    
    public static int[] sieve(int n){
        int[] array = new int[n];
     
        int count = 0;
        
        for(int p = 2; p < n; p++){
            array[p] = p;
        }
        
        int j;
        for(int p = 2; p <= floorCompute(n); p++){
            if(array[p] != 0){
                j = p*p;
                while(j<n){
                    array[j] = 0;
                    j = j+p;
                    count++;
                }
            }
        }
        int[] result = new int [count];
        int i = 0;
        for(int p = 2; p <n; p++){
            if(array[p] != 0){
                result[i] = array[p];
                i++;
            }
        }
        return result;
    }
    
    public static int euclid(int m, int n){
        int r = 0;
        while (n!= 0){
            r = m%n;
            m = n;
            n= r;
        }
        return m;
    }
    
    public static int consecutive(int m, int n){
        int t = 0;
        if (m <= n){
            t = m;
        }else{
            t = n;
        }
        
        while(t >0 ){
            if ((m%t ==0) && (n%t == 0)){
                break;
            }
            t--;
        }
        return t;
        
        
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
