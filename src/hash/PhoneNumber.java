package hash;

import java.util.Arrays;
import java.util.HashMap;
public class PhoneNumber {
	public static void main(String[] args) {
		String[] phone_book = {"123", "456", "789", "010","787","453"};
		boolean answer = true;
        Arrays.sort(phone_book);
        
        HashMap<String, String> map =  new HashMap<String, String>();
        for(String a : phone_book) {
        	map.put(a, a);
        	System.out.println(a);
        }
        System.out.println("it's = "+map.keySet().iterator().next());
        if(map.keySet().iterator().next()!=null) {
        	answer=false;
        }       
        
		System.out.println(answer);
	}
	
}
