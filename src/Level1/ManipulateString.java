package Level1;
/*
 * 
[문자열 다루기 기본]

문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요. 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
입출력 예
s	return
"a234"	false
"1234"	true
 */
public class ManipulateString {
	public static void main(String[] args) {
		
		System.out.println(check("a1234"));
		System.out.println(check("a12"));
		System.out.println(check("123456678"));
		System.out.println(check("asagsd"));
		System.out.println(check("1234"));
	}
	
	public static boolean check(String s) {
		if(s.length()!=4 && s.length()!=6) {
			return false;
		}
		char[] c = s.toCharArray();
		for(char cc : c) {
			if(Character.isLetter(cc)) {
				return false;
			}
		}
		return true;
	}
}
