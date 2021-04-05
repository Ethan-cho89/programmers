package kakaoDeveloper;

import java.util.HashMap;

/*
 * 
문제 설명
1부터 n까지 번호가 하나씩 붙어있는 n개의 역이 철로로 연결되어 있습니다.
철로는 양방향 통행이 가능하며, 임의의 두 역을 직접 연결하는 철로는 최대 하나입니다.
또, 서로 다른 두 역 사이의 이동 경로는 딱 한 가지며, 임의의 두 역 사이에 이동 불가능한 경우는 없습니다.

출발역과 종착역 사이를 왕복하는 열차를 운행하려 합니다. 출발역은 1번 역이며, 
전체 역 중 한 곳을 종착역으로 정해야 합니다. 단, 열차가 출발역에서 종착역까지 갈 때 모든 역을 방문할 필요는 없으며, 
같은 역을 두 번 이상 방문하면 안 됩니다.

종착역을 정하기 위해 각 역의 일일 이용객 수를 조사했습니다. 
이때, 열차가 방문하는 역의 일일 이용객 수의 합이 최대가 되도록 종착역을 지정하면 됩니다.
만약 일일 이용객 수의 합이 최대가 되는 역이 여러개라면, 그 중 번호가 큰 역을 선택하면 됩니다.

전체 역의 개수 n, 1번부터 n번 역까지 일일 이용객 수 passenger, 역 사이의 철로 연결 정보 train이 매개변수로 주어질 때, 
종착역으로 지정할 역 번호와 그때의 이용객 수 합을 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 2 이상 100,000 이하인 자연수입니다.
passenger의 길이는 n입니다.
passenger의 원소는 1 이상 10,000 이하인 자연수입니다.
passenger[i]는 i + 1번 역의 일일 이용객 수 입니다.
train의 세로(행) 길이는 n - 1 입니다.
train의 가로(열) 길이는 2입니다.
train의 원소는 [A, B] 형태입니다.
A, B는 철로가 연결하는 두 역의 번호입니다.
A, B는 1 이상 n 이하인 자연수이며, A와 B가 같은 경우는 없습니다.
같은 철로에 대한 정보가 중복해서 들어있지 않습니다.
입출력 예
n	passenger			train								result
6	[1,1,1,1,1,1]		[[1,2],[1,3],[1,4],[3,5],[3,6]]		[6,3]
4	[2,1,2,2]			[[1,2],[1,3],[2,4]]					[4,5]
5	[1,1,2,3,4]			[[1,2],[1,3],[1,4],[1,5]]			[5,5]
입출력 예 설명
입출력 예 #1

train_2.png

5번 역을 종착역으로 정하면 열차는 1번 역 → 3번 역 → 5번 역 → 3번 역 → 1번 역 → ... 과 같이 움직입니다. 1번, 3번, 5번 역의 일일 이용객 수의 합은 3명입니다.
6번 역을 종착역으로 정하면 열차는 1번 역 → 3번 역 → 6번 역 → 3번 역 → 1번 역 → ... 과 같이 움직입니다. 1번, 3번, 6번 역의 일일 이용객 수의 합은 3명입니다.
일일 이용객 수의 합이 최대인 경우가 여러 개라면 그중 번호가 큰 역을 선택해야 합니다. 따라서 6번 역을 종착역으로 정합니다.

입출력 예 #2

4번 역을 종착역으로 정하면 열차는 1번 역 → 2번 역 → 4번 역 → 2번 역 → 1번 역 → ... 과 같이 움직입니다. 세 역의 일일 이용객 수의 합은 5명이 되고, 이때가 최대입니다.

입출력 예 #3

5번 역을 종착역으로 정하면 열차는 1번 역 → 5번 역 → 1번 역 → ... 과 같이 움직입니다. 1번, 5번 역의 일일 이용객 수의 합은 5명이고, 이때가 최대입니다.
 */
public class Practice3 {
	public static void main(String[] args) {
		int[] passenger1	= {1,1,1,1,1,1};
		int[][] train1 = {{1,2},{1,3},{1,4},{3,5},{3,6}};	
		
		int[] passenger2	= {2,1,2,2};
		int[][] train2 = {{1,2},{1,3},{2,4}};	
		
		int[] passenger3	= {1,1,2,3,4};
		int[][] train3 = {{1,2},{1,3},{1,4},{1,5}};
		
		moving(6,passenger1, train1);
//		moving(4,passenger2, train2);
//		moving(5,passenger3, train3);
		
	}
	
	public static int[] moving(int n, int[] passenger, int[][] train) {
		int[] answer = new int[2];
		int sum = 0;
		int index = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<train.length; i++) {
			if(train[i][0]==1) { //첫번째랑 두번째 역 이용하는 승객 더하기
				sum += passenger[train[i][0]-1];
				sum += passenger[train[i][1]-1];
			}
			for(int k=0; k<train.length; k++) {
				if(train[i][1]==train[k][0]) {
					if(train[k][1]==0) {
						continue;
					}
					sum+= passenger[train[k][1]-1];
					train[k][1]=0;
					i=k;
					index=k;
					k=0;
				}
			}
			map.put(train[index][1],sum);
		}
		
		return answer;
	}
}
