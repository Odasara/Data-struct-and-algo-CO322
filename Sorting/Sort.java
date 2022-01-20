/**
 * Simple sorting algorithms and their performance 
 * Reg: E/17/153  
 *
 */
import java.util.concurrent.TimeUnit;
public class Sort {

    //create an array of given size and populate it with random data  
    static int [] create_rand_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = (int)(Math.random() * 100);
	return data; 
    }

    //create an array of given size and populate it with worst data arrangement 
    static int [] create_worst_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = data.length - i;
	return data; 
    }

    //create an array of given size and populate it with best data arrangement 
    static int [] create_best_data(int size_of_array) {
	int [] data = new int[size_of_array];
	int i; 
	for(i=0; i < data.length; i++)
	    data[i] = i;
	return data; 
    }

    // function to swap. Would be useful since all need this 
    static void swap(int []d, int i, int j) { 
	int tmp = d[i]; 
	d[i] = d[j]; 
	d[j] = tmp;
    }

    // check if the soring worked on the array 
    static boolean isSorted(int [] data) {
	int i;
	for(i=1; i < data.length; i++)
	    if(data[i] < data[i-1]) break;
	return (i == data.length);
    }

    // If you want just display the array as well :) 
    static void display(int []data) { 
	System.out.println("=======");
	for(int i=0; i < data.length; i++) 
	    System.out.print(data[i] + "  "); 
	System.out.println("\n=======");
    }

    
    /**********************************************************
     *     Implementation of sorting algorithms               *
     *********************************************************/
	 
    static void buble_sort(int [] data)  {       //implementation of optimized bubble sort method
		
			boolean quit=false;
			for(int i = 0; i<data.length && !quit; i++){
				quit = true;
				for(int j = data.length-1 ; j>i ; j--){        
					if (data[j] < data[j-1]){
						swap(data,i,j);              
						quit = false;
					}
				}
			}
		
	
    }

    static void selection_sort(int [] data) {        //implementation of selection sort method
		
			for(int i=0; i< data.length-1;i++){        //loop till array
				int min_index= i;
				for(int j=i+1 ; j<data.length ; j++){    
					if(data[j] < data[min_index]){       //finding minimum element
						min_index = j;
					}
				}
				swap(data,min_index,i);              //do swap operation by swap method
			}
		
    }

    static void insertion_sort(int [] data) {       //implementation of insertion sort method
		
			for(int i=1; i< data.length ;i++){
				int key = data[i];
				int j =i-1;
				while((j>-1) && (data[j]>key)){         //algorith of insertion
					data[j+1] = data[j];
					j--;
				}
				data[j+1] = key;
			
			}
		
    }

		       
		
   
    public static void main(String [] args) {
	// create arrays of different size populate with data
	// measure the time taken by different algorithms to
	// sort the array.
	// Think about effects of caches, other apps running etc.
	 
		int [] arr= create_rand_data(50000);
		//int[] arr =create_worst_data(50000);     //create array in three different cases
		//int[] arr= create_best_data(50000);
		
		long startTime = System.nanoTime();        //start measuring time
		
		buble_sort(arr);
		//selection_sort(arr);                         //call the method of sorting algorithm
		//insertion_sort(arr);
		
        long endTime = System.nanoTime();        //end measuring time
		
		//display(arr);                            //display the sorted array
 
        long timeElapsed = endTime - startTime;    //time taken for sorting
	   
		/*if(isSorted(arr)){
			 System.out.println("Done");                //check whether the array is sorted correctly
		}*/
 
        System.out.println("Execution time in nanoseconds: " + timeElapsed);    //print the execution time 
		
    }
}