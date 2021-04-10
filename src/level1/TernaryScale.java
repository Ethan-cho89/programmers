package Level1;
/*
[3진법 뒤집기]

문제 설명
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.
입출력 예
n	result
45	7
125	229
입출력 예 설명
입출력 예 #1

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45			1200	0021		7
따라서 7을 return 해야 합니다.
입출력 예 #2

답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
125			11122	22111		229
따라서 229를 return 해야 합니다.
 */


public class TernaryScale {
	public static void main(String[] args) {
		System.out.println(reverse(125));
		System.out.println(toDecimalNumber(reverse(125)));
		
		
		
		
	}
	
	
	public static String reverse(int n) { // 10진수를 받아서 3진수 역순으로 한번에 만들기
		String reverse = "";
		while(n!=0) {
			if((n%3)<10) {
				reverse = reverse+ (n%3);
				n/=3;
			}
		}
		return reverse;
	}

	public static int toDecimalNumber(String s) {
		char[] cArray = s.toCharArray();
		int answer = 0;
		int cnt = 0;
		for(int i=cArray.length-1; i>=0; i--) {
			answer += Integer.parseInt(cArray[i]+"")*Math.pow(3,cnt++);
		}
		return answer;
	}
	
	
    public static String toDeposition(int value, int i){

        String returnString = "";
        String temp = "";

        while(value != 0){

            // 나머지가 0~9 사이이면  캐릭터 값을 배열에 저장
            if( (value % i) < 10 ) {
                //문자열 우->좌로 배열
                returnString = (value % i) + returnString;
                //몫을 구함
                value /= i;
            }
            // 나머지가 10 이상이면 해당하는 값의 알파벳을 저장
            else {
                int temp1 = (char)((value % i)  + 55);
                returnString = Integer.toString(temp1) + returnString;
            }
        }
        return returnString;
    }

}
	
