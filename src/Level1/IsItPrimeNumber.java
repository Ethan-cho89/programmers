package Level1;

import java.util.Arrays;

/*
 * 문제 설명
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.
입출력 예
n	result
10	4
5	3
입출력 예 설명
입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환

 */
public class IsItPrimeNumber {
	public static void main(String[] args) {
		System.out.println(howManyPrime(11));
		
	}
	
	public static int howManyPrime(int n) {
		int answer = 0;
		
		int[] filter = new int[n+1]; //에라토스테네스의 체
		
		Arrays.fill(filter, 1); // filter 배열을 1로 채운다
		
		filter[0]=0; // 소수가 아닌 0,1은 0으로 설정하여 검색에서 제외해준다
		filter[1]=0;
		
		for(int i=2; Math.pow(i, 2)<n; i++) {
			// 최초의 소수인 2 부터 시작
			
			if(filter[i]==1) {
				for(int j= i*2; j<=n; j+=i) {
					filter[j]=0;
				}
			}
		}
		
		for(int check : filter) {
			if(check==1) {
				answer++;
			}
		}
		return answer;
	}
}
