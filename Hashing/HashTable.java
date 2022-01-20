import java.util.Arrays; 

public class HashTable {
	private Entry[] entryList;
	private int capacity;
	private int currentSize;
	
	public HashTable(int capacity) {
		this.capacity = capacity ;
		this.entryList = new Entry[capacity] ;
		this.currentSize = 0;
		
	}
	
	 public void clearAll() {				//method to clear all entries
		 this.entryList = new Entry[capacity];
		 this.currentSize = 0;
		 
	 }
	 
	 public int getCurrentSize() {			 //method to get current size 
		 return this.currentSize;
	 }
	 
	 public boolean isFull(){
		 return currentSize == capacity ;
	 }
	 
	 public boolean isEmpty() {
		 return currentSize == 0;
	 }
	  
	//check whether the hash table contains a key or not   
	 public boolean containsKey(int key) {
		 return get(key) != null ;
	 }
	 
	 //h(k)= k % N
	 private int hash1(int key) {
		 return key %   capacity;
	 }
	 
	 //p(k,i) = i* {1+ k % (N-1) }
	 private int hash2(int key, int i ) {
		 return i * (1 + (key % (capacity - 1)));
	 } 
	 
	 public void insert (int key, String value) {
		 if (currentSize > (capacity-1)) return ;
		 
		 Entry entryToInsert = new Entry (key,value);
		 
		 int h1 =hash1(key);
		 int i=1;
		 
		 while (entryList[h1] != null) {
			 h1 = (h1 + hash2(key,i))% capacity ;
			 i++;
		 }
		  
		 entryList[h1] =entryToInsert;
		 currentSize = currentSize + 1 ;
		 
	 }
	 
	 public Entry[] getEntryList() {
		 return this.entryList;
		 
	 }
	 
	 public String get(int key) {
		 int h1 = hash1(key) ;
		 
		 Entry readEntry = entryList[h1] ;
		 
		 int i=1;
		 while (readEntry != null && !(readEntry.getKey()==key)) {
			 h1 = (h1 + hash2(key,i))% capacity ;
			 i++;
			 readEntry = entryList[h1] ;
		 }
		 
		 return entryList[h1].getValue();
	 }
	 
	 public void remove (int key) {    //to remove an entry
		 if  (!containsKey(key)) return ;
		 
		 int h1 = hash1 (key);
		 
		 Entry readEntry = entryList [h1];
		 int i=1;
		 while (readEntry != null && (readEntry.getKey() != key)) {
			 h1 = (h1 + hash2(key,i))% capacity ;
			 i++;
			 readEntry = entryList[h1] ;
		 }
		 
		 entryList[h1] = null ;
	 }
	 
	 public void printList() {        //to display whole list
		 Arrays.stream(entryList).forEach(entry ->{
			 if (entry != null) {
				 System.out.println("key : " +entry.getKey() + " value : " +entry.getValue());
			 }
		 });
	 }
	 

}