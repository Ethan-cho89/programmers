package Level1;


/*
[시저 암호]

문제 설명
어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다. 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

제한 조건
공백은 아무리 밀어도 공백입니다.
s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
s의 길이는 8000이하입니다.
n은 1 이상, 25이하인 자연수입니다.
입출력 예
s		n	result
"AB"	1	"BC"
"z"		1	"a"
"a B z"	4	"e F d"
 */
public class CaesarCode {
	public static void main(String[] args) {
		System.out.println("make ="+makeSaesarCode("a B z",4));
		System.out.println("seasar ="+seasar("a B z",4));
	}
	
	public static String seasar(String s, int n) {
	    String result = "";
	    n = n % 26;
	    
	    // 뽑힌 알파벳에서 맨 첫글자인 a 또는 A를 빼주고 더해줄 숫자를 적용시킨뒤 알파벳 개수인 26으로 나눈후 다시 첫번째 숫자를 더해준다.
  	  	//예를 들어 z에 5를 더하는 거면
  	  	// (122-97+5)%26+97 = 답은 e가 될거고  e는 101이다. 
	    for (int i = 0; i < s.length(); i++) {
	      char ch = s.charAt(i);
	      if (Character.isLowerCase(ch)) {
	        ch = (char) ((ch - 'a' + n) % 26 + 'a'); 
	      } else if (Character.isUpperCase(ch)) {
	        ch = (char) ((ch - 'A' + n) % 26 + 'A');
	      }
	      result += ch;
	    }
	        return result;
	}
	
	
	
	public static String makeSaesarCode(String s, int n) {

		
		// 65~90 A ~ Z 97~122 a~z
		String answer = "";
		for(int i =0; i<s.length(); i++) {
			int c = s.charAt(i);
			if(c==32) { //공백이면 다음으로 넘기고
				answer+= (char)32;
			}
			if(c>=65 && c<=90) { // 대문자
				if((c+n)>90) {
					answer+= (char)((c+n)-90+65-1);
				}else {
					answer+= (char)(c+n);
				}
			}else if(c>=97&&c<=122) { // 소문자
				if((c+n)>122) {
					answer+= Character.toChars((c+n)-122+97-1)[0];
				}else {
					answer+= Character.toChars(c+n)[0];
				}
			}
		}
		return answer;
	}
	
}
