
public class MaxSumWithoutAdjacentElements {

	public static void main(String[] args) {
		int arr[]={5,5,10,40,50,35};
		//int arr[]={3,2,7,10};
		maxSum(arr);
	}

	private static void maxSum(int[] arr) {
		int n=arr.length;
		int sum_inc_prev=arr[0];
		int sum_exc_prev=0;
		int sum_inc=0, sum_exc=0;
		int max=0;
		for(int i=1;i<n;i++){
			sum_inc=Math.max(sum_exc_prev+arr[i], sum_inc_prev);
			sum_exc=sum_inc_prev;
			sum_inc_prev=sum_inc;
			sum_exc_prev=sum_exc;
		}
		System.out.println(Math.max(sum_inc, sum_exc));
		
	}

}
