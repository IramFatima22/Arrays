
public class LargestSumSubarray {

	public static void main(String[] args) {
		int arr[]={-2, -3, 4, -1, -2, 1, 5, -3};
		int arr1[]={-2, -3, -4, -3, -2, -7, -5, -3};
		System.out.println(method1(arr));
		System.out.println(method2(arr1));
	}
	//this method handles the case when all the array elements are negative
	private static int method2(int[] arr) {
		int n=arr.length;
		int sum=arr[0];
		int max=arr[0];
		for(int i=1;i<n;i++){
			sum=Math.max(arr[i], sum+arr[i]);
			max=Math.max(sum, max);
		}
		return max;
	}
	//Kandane Algorithm
	private static int method1(int[] arr) {
		int n=arr.length;
		int sum=0,max=0;
		for(int i=0;i<n;i++){
			sum+=arr[i];
			if(sum<0)
				sum=0;
			if(sum>max)
				max=sum;
		}
		return max;	
	}

}
