package hash;
import java.util.HashMap;

public class CompletedParticipant {
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana","mislav"};
		String[] completion = {"mislav", "mislav", "stanko", "ana"};
		String answer = "";
		
		HashMap<String, Integer> result = new HashMap<String, Integer>(); //중복값이 안들어가는 hashmap을 만든다
        for(String player : participant){ 
            int count = 0;
            Integer value =result.get(player); //이미 저장된 이름인지 확인
            if(value != null){ // 이름이 이미 있으면 
                count = value; // player라는 이름으로 저장된 값을 count에 넣는다
            }
            result.put(player, ++count);
            System.out.println("player : "+player+"/ count : "+count);
        }
        for(String player : completion){
            int count = result.get(player);
            if(count == 1){
                result.remove(player);
            }else{
                result.put(player, --count);
            }
        }
        
        System.out.println(result.keySet().iterator().next());

	}
}
