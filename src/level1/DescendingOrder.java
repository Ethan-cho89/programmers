package Level1;

import java.util.Arrays;
import java.util.Collections;

/*
[정수 내림차순으로 배치하기]

문제 설명
함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요. 예를들어 n이 118372면 873211을 리턴하면 됩니다.

제한 조건
n은 1이상 8000000000 이하인 자연수입니다.
입출력 예
n	return
118372	873211
 */


public class DescendingOrder {
	String res = "";
	public static void main(String[] args) {
		long n = 118372;
		System.out.println(changeOrder(n));
	}
	
	public static long changeOrder(long n) {
		char[] cc = (n+"").toCharArray();
		int[] arr = new int[cc.length];
		for(int i=0; i<arr.length; i++) {
			arr[i]= Integer.parseInt(cc[i]+"");
		}
		Integer[] iArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		Arrays.sort(iArr, Collections.reverseOrder());
		String tmp = "";
		for(int i : iArr) {
			tmp+= i+"";
		}
		long answer = Long.parseLong(tmp);
		
		return answer; 
		
	}
	public int reverseInt(int n){
        res = "";
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
        return Integer.parseInt(res);
    }
	
}
