package sort;

/*
 * 
가장 큰 수
문제 설명

0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	return
[6, 10, 2]	"6210"
[3, 30, 34, 5, 9]

 * 
 */

public class BiggestNumber {
	public static void main(String[] args) {
		int[] quiz  = {9,90,40,4}; //원래 숫자
		int qLength =quiz.length;
		
		int[] a  = new int[qLength]; //맨 앞자리 저장
		int[] b  = new int[qLength]; // 두번째 자리 저장
		int[] c  = new int[qLength]; // 세번째 자리 저장
		int[] d  = new int[qLength]; // 네번째 자리 저장

		
		for(int j=0; j<quiz.length; j++) {
			int num = quiz[j];
			
			if(num==1000) {
				a[j]=1;
				b[j]=-999;
				c[j]=-999;
				d[j]=-999;
				
			}else if(num>99) {
				a[j]= num/100;
				System.out.println(num+"/100 = "+num/100);
				
				if(num%100/10==0) {
					b[j]= -999;
				}else {
					b[j]= num%100/10;
				}
				System.out.println(num+"%100/10 = "+ num%100/10);
				
				if(num%10==0) {
					c[j]= -999;
				}else {
					c[j]= num%10;
				}
				System.out.println(num+"%10 = "+ num%10);
				
				d[j]=-1;
				
			}else if(num>9) {
				a[j]=num/10;
				System.out.println(num+"/10 = "+ num/10);
				if(num%10==0) {
					b[j]= -999;
				}else {
					b[j]= num%10;
				}
				System.out.println(num+"%10= "+ num%10);
				c[j]=-1;
				d[j]=-1;
			}else {
				a[j]=num;
				System.out.println("num = "+num);
				b[j]=-1;
				c[j]=-1;
				d[j]=-1;
			}
		}		

		int tmp=0;
		for(int i=0; i<quiz.length-1; i++) {
			for(int j=0; j<quiz.length-1; j++) {
				if(a[j]==a[j+1]) {
					if(b[j]==b[j+1]) {
						if(c[j]==c[j+1]) {
							if(d[j]<d[j+1]) {
								tmp=a[j];
								a[j]=a[j+1];
								a[j+1]=tmp;
								
								tmp=b[j];
								b[j]=b[j+1];
								b[j+1]=tmp;
								
								tmp=c[j];
								c[j]=c[j+1];
								c[j+1]=tmp;
								
								tmp=d[j];
								d[j]=d[j+1];
								d[j+1]=tmp;
							}
						}else if(c[j]<c[j+1]) {
							tmp=a[j];
							a[j]=a[j+1];
							a[j+1]=tmp;
							
							tmp=b[j];
							b[j]=b[j+1];
							b[j+1]=tmp;
							
							tmp=c[j];
							c[j]=c[j+1];
							c[j+1]=tmp;
							
							tmp=d[j];
							d[j]=d[j+1];
							d[j+1]=tmp;
						}
					}else if(b[j]<b[j+1]) {
						tmp=a[j];
						a[j]=a[j+1];
						a[j+1]=tmp;
						
						tmp=b[j];
						b[j]=b[j+1];
						b[j+1]=tmp;
						
						tmp=c[j];
						c[j]=c[j+1];
						c[j+1]=tmp;
						
						tmp=d[j];
						d[j]=d[j+1];
						d[j+1]=tmp;
					}
				}else if(a[j]<a[j+1]) {
					tmp=a[j];
					a[j]=a[j+1];
					a[j+1]=tmp;
					
					tmp=b[j];
					b[j]=b[j+1];
					b[j+1]=tmp;
					
					tmp=c[j];
					c[j]=c[j+1];
					c[j+1]=tmp;
					
					tmp=d[j];
					d[j]=d[j+1];
					d[j+1]=tmp;
				}
			}
		}	
		String[] answer = new String[quiz.length];
		
		for(int i=0; i<quiz.length; i++) {
			answer[i]= (""+a[i]+b[i]+c[i]+d[i]).replace("-999", "0").split("-")[0];
			System.out.println("a["+i+"] = "+a[i]);
			System.out.println("b["+i+"] = "+b[i]);
			System.out.println("c["+i+"] = "+c[i]);
		}
		String aws = "";
		for(String aaa : answer) {
			aws+=aaa;
		}
//		System.out.println(Long.parseLong(aws));
		
		System.out.println(aws);
	}
	
	
	//얘를 한번 생각해보기..
	int[] compare (int a, int b, int[] arr, int n) {
        // 두 숫자를 결합하여 A+B , B+A 를 각각 비교해 전자가 크면 유지, 후자가 크면 위치를 변경한다.
        String strA = ""+a+b;
        String strB = ""+b+a;     
        //int numberA = Integer.parseInt(strA);
        //int numberB = Integer.parseInt(strB);

        // 조건에 맞으면 자리 변경 (Swap)
        if (strB.compareTo(strA)>0) {
            arr[n] = b;
            arr[n+1] = a;
        }
        return arr;
    }
}
