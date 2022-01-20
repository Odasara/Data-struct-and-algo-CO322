import java.util.LinkedList;
import java.util.List;
public class Main{
	public static void main (String[] args){
		HashTable hashTable = new HashTable (13);
		
		//main can be customized as which method/output we are supposed to get
		
		hashTable.insert(4,"value 4" );
		//hashTable.insert(4,"value 17" );
		//hashTable.insert(4,"value 222" );
		
		
		System.out.println(hashTable.get(4));
		//System.out.println(hashTable.get(17));
		//System.out.println(hashTable.get(222));
		
		hashTable.printList();
		
	}
	
	
}
