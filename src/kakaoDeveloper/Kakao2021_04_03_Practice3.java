package kakaoDeveloper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

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
public class Kakao2021_04_03_Practice3 {
	public static void main(String[] args) {
		int[] passenger1	= {1,1,1,1,1,1};
		int[][] train1 = {{1,2},{1,3},{1,4},{3,5},{3,6}};	
		
		int[] passenger2	= {2,1,2,2};
		int[][] train2 = {{1,2},{1,3},{2,4}};	
		
		int[] passenger3	= {1,1,2,3,4};
		int[][] train3 = {{1,2},{1,3},{1,4},{1,5}};
		
		checkTrain(6,passenger1, train1);
		
		checkTrain(4,passenger2, train2);
		checkTrain(5,passenger3, train3);
		
	}
	
	public static int[] checkTrain(int n, int[] passenger, int[][] train) {
		int[] answer = new int[2];
		int max =0; // 가장 사람이 많이 타는 조합의 결과값 (번호의 경우의 수마다 검토) 
		int lastStation = 0; // 맥스 값이 바뀔때 마지막 정류장 정보 저장
		int last=0; // 매 조회마다의 마지막 정류장 정보 
		int temp=0;
		int tempIndex=0;
		Stack<Integer> st = new Stack<Integer>();
		
		String stations ="1"; //경우의 수 조합
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean hasNext = true;
		boolean checkAgain = false;
		
		int total =0;
		for(int i=0; i<train.length; i++) {
			if(train[i][0]==1) { // 출발지라면 다음 정거장을 매개변수로 주고 재귀메소드로 이어지는 정거장 다 찾아오기
									// 얘가 시작 정거장인 애를 찾고 또 걔랑 이어지는 애가 시작 정거장인 애를 찾고... 찾.. ㅊ...
				temp = train[i][1];
				stations+= temp;
				hasNext = true;
				for(int j=0; j<train.length; j++) {
					System.out.println("station에 마지막 저장된 애 : " +stations.charAt(stations.length()-1));
					if(temp==train[j][0]) { //저번의 마지막과 이번의 시작이 같은가?
						temp=train[j][1];
						stations+=temp;
						tempIndex=j;
						j=0;
						hasNext=true;
						checkAgain=true;
					}else if(j==train.length-1) { // 마지막까지 찾았는데 없으면 
						hasNext= false;
					}
					if(!hasNext) { // 마지막까지 갔을때 이어지는 정류장이 없으면 출발역 정보를 0으로 만들어서 검색 안되도록 한다
						train[tempIndex][0] = 0;
					}
				}
				System.out.println("stations = "+stations);
				char[] people = stations.toCharArray();
				for(char c : people) {
					System.out.println("c = "+c);
					total+= passenger[Integer.parseInt(c+"")-1];
				}
				if(max<=total) { // 이번 조합의 최대 승객 수가 같거나 크다면
					max=total;
					last = Integer.parseInt(people[people.length-1]+"");
					if(lastStation<last) {
						lastStation=last;
					}
				}
				System.out.println("Max = "+max+" // total = "+total);
				total=0;
				stations="1";
			}
			if(checkAgain) { //한번이라도 다른 정류장을 만나면 다시 돌아가서 검사하기
				 checkAgain = false;
				 i=0;
			}
		}
		System.out.println("답은 "+ last + " // "+max);
		answer[0]=lastStation;
		answer[1]=max;
		
		return answer;
	}
	
}