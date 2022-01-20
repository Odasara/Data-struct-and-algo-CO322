public class Entry{    //entry class to create a entry with a key and value pair
	private int key;
	private String value;
	
	public Entry(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public int getKey(){   //return the key
		return key;
	}
	
	public String getValue(){     //return the value
		return value;
	}	
}