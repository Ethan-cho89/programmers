package sort;


/*
 * 
[k번째 수]
 문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
입출력 예
array	commands	return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
입출력 예 설명
[1, 5, 2, 6, 3, 7, 4]를 2번째부터 5번째까지 자른 후 정렬합니다. [2, 3, 5, 6]의 세 번째 숫자는 5입니다.
[1, 5, 2, 6, 3, 7, 4]를 4번째부터 4번째까지 자른 후 정렬합니다. [6]의 첫 번째 숫자는 6입니다.
[1, 5, 2, 6, 3, 7, 4]를 1번째부터 7번째까지 자릅니다. [1, 2, 3, 4, 5, 6, 7]의 세 번째 숫자는 3입니다.

 * 
 */

public class NumberK {
	public static void main(String[] args) {
		int[] a = {1, 5, 2, 6, 3, 7, 4};
		int[][] b = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] answer = new int[b.length];
		answer[0]=1;
		answer[1]=9;
		
		for(int i=0; i<b.length; i++) {
			
			int no1 = b[i][0]; //2
			int no2 = b[i][1]; //5
			int no3 = b[i][2]; //3
			
			int length = 1;
			if(no1>no2) {
				length= no1-no2+1;
			}else if(no1<no2){
				length= no2-no1+1;
			}
			int[] temp=new int[length];
			int n = 0;
			
			for(int j=no1-1; j<=no2-1; j++) {
				temp[n++]=a[j];
			}
			for(int tt=0; tt<temp.length-1; tt++) {
				for(int t=0; t<temp.length-1; t++) {
					if(temp[t]>temp[t+1]) {
						int tmp = temp[t];
						temp[t]=temp[t+1];
						temp[t+1]=tmp;
					}
				}
			}
			System.out.println("answer = "+ temp[no3-1]);
		}
	}
}
