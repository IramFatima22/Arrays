//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
public class MaxJIDiff {

	public static void main(String[] args) {
		int arr[]={34, 8, 10, 3, 2, 80, 30, 33, 1};
		method1(arr);
	}

	private static void method1(int[] arr) {
		int n=arr.length;
		int left[]=new int[n];
		int right[]=new int[n];
		left[0]=arr[0];
		for(int i=1;i<n;i++){
			left[i]=Math.min(arr[i],left[i-1]);
		}
		right[n-1]=arr[n-1];
		for(int i=n-2;i>=0;i--){
			right[i]=Math.max(arr[i], right[i+1]);
		}
		int i=0,j=0;
		int max=0;
		while(i<n && j<n){
			if(left[i]<right[j]){
				max=Math.max(max, j-i);
				j++;
			}
			else if(left[i]>=right[j]){
				i++;
			}
		}
		System.out.println(max);			
	}
}
