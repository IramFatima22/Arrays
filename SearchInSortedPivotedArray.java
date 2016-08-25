
public class SearchInSortedPivotedArray {

	public static void main(String[] args) {
		int arr[]={3,4,5,6,7,1,2};
		int x=5;
		System.out.println(method1(arr,x,0,arr.length-1));
	}
	//Using modified binary search
	private static int method1(int[] arr, int x, int s, int e) {
		if(s>e)
			return -1;
		int m=(s+e)/2;
		if(arr[m]==x)
			return m;
		if(arr[s]<arr[m]){
			if(x>=arr[s] && x<arr[m])
				return method1(arr, x, s, m-1);
			return method1(arr, x, m+1, e);
		}
		else if(arr[m]<arr[e])
			if(x>arr[m] && x<=arr[e])
				return method1(arr, x, m+1, e);
			return method1(arr, x, s, m-1);		
	}

}
