

import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int arr[]={5,4,12,8,9};
		findNextGreater(arr);
	}

	private static void findNextGreater(int[] arr) {
		Stack<Integer> s=new Stack<Integer>();
		s.push(arr[0]);
		for(int i=1;i<arr.length;i++){
			int next=arr[i];
			while(!s.isEmpty() && s.peek()<next){
				int val=s.pop();
				System.out.println(val+"-->"+next);
			}
			s.push(next);	
		}
		while(!s.isEmpty())
			System.out.println(s.pop()+"-->-1");
	}

}
