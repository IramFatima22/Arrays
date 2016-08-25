import java.util.Arrays;
import java.util.HashMap;

public class PairSum {

	public static void main(String[] args) {
		int arr[]={1,4,45,6,10,-8};
		int sum=16;
		System.out.println(method1(arr,sum));
		System.out.println(method2(arr,sum));
	}
	//Using HashMap
	private static boolean method2(int[] arr, int sum) {
		HashMap<Integer,Integer> map=new HashMap<>();
		int n=arr.length;
		for(int i=0;i<n;i++){
			if(map.containsKey(sum-arr[i]))
				return true;
			else
				map.put(arr[i], i);
		}
		return false;
	}
	// Using Sorting
	private static boolean method1(int[] arr, int sum) {
		Arrays.sort(arr);
		int n=arr.length;
		int l=0,r=n-1;
		while(l<r){
			if(arr[l]+arr[r]>sum)
				r--;
			else if(arr[l]+arr[r]<sum)
				l++;
			else
				return true;
		}
		return false;
		
	}

}
