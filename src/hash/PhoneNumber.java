package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PhoneNumber {
	public static void main(String[] args) {
		String[] phone_book = {"123", "456", "789", "010","78","45"};
		boolean answer = true;
        Arrays.sort(phone_book);
	    HashMap<String, String> map = new HashMap<String, String>();
	    
	    for( String p : phone_book) {
	    	map.put(p, p);
	    }
	    for(String p:phone_book) {
	    	map.get(p);
	    }       
        
		System.out.println(answer);
	}
	
}
