import java.util.Random;


class MaxSub { 

    static int MAX_NUM = 200; 
    static int start, end; 

    static int [] generate(int howmany) { 
	int [] data = new int[howmany]; 
	Random randomGenerator = new Random();
	for(int i=0; i<howmany; i++) 
	    data[i] = randomGenerator.nextInt(MAX_NUM) - (MAX_NUM/2); 
	return data; 
    }

    static void show(int []data, int s, int e) { 
	for(int i=s; i<e; i++) 
	    System.out.print(data[i] + " "); 
	System.out.println(); 
    }	



/* **********************************************************************************
 This method is using brute force approach
 
 When we measure the runtime of this method, it is much larger than next method
 
 Time complexity = O(n^3)
 
 ************************************************************************************ */

	 static int findMaxSubBruteForce(int [] data){
  		int maxsum = Integer.MIN_VALUE;
  		int size = data.length;
  		for(int sub_array_size = 1; sub_array_size <= size; ++sub_array_size ){
   			for (int start_index = 0; start_index < size; ++start_index) {
    			if(start_index + sub_array_size > size){
     				break;
    			}
    			int sum = 0;
    			for(int i = start_index; i < (start_index + sub_array_size); i++){
     				sum = sum + data[i];
   				 }
    		maxsum = Math.max(maxsum, sum);
    
  			 }
		}	 
  		 return maxsum;
 	 
	} 
	
	
 /* *****************************************************
   This method is using dynamic programming concepts
   
   It takes less time to execute than Brute Force method
   
   Time complexity = O(n)
   ****************************************************** */	

    static int findMaxSub(int [] data) {   // find the MaxSub array sum and return 
	
	
        int size = data.length;
        int sum = Integer.MIN_VALUE, max_end = 0;
 
        for (int i = 0; i < size; i++){        //loop till array length
        
            max_end += data[i];                //add element values to max_end
			
            if (sum < max_end)                 //check if sum<max_end and if so, assign max_end to sum
                sum= max_end;
            if (max_end < 0)                   //check if max_end is negative and if so, assign 0 to max_end
                max_end = 0;
        }
		
        return sum;                            //return sum
	
    }
	
	

    public static void main(String [] args) { 
	// try it with a known array first
	// then use a random array and see it works 
	
	//int [] data = {1, 12, -129, 192, 2, 10, -19, 25, -200, 91, 10};
		int []data = generate(100);
		
		long startTime = System.nanoTime();     	//start measuring time
		
		findMaxSub(data);                       	//call the method findMaxSub or findMaxSubBruteForce
		//findMaxSubBruteForce(data);
		
		long endTime = System.nanoTime();       	//end measuring time
		
		
		System.out.println("Max sum = " + findMaxSub(data));                //Display the max subarray sum
		//System.out.println("Max sum = " + findMaxSubBruteForce(data)); 
		
		long timeElapsed = endTime - startTime;                  //calculate the time elapsed
		
		System.out.println("Execution time in nanoseconds: " + timeElapsed);         //display the timeelapsed
		
	    }	
	}