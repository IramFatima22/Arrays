
public class CeilingInSortedArray {

	public static void main(String[] args) {
		int arr[]={1,2,8,10,10,12,19};
		int x=13;
		System.out.println(ceiling(arr,0,arr.length-1,x));
	}

	private static int ceiling(int[] arr,int s, int e, int x) {
		if(x<=arr[s])
			return arr[s];
		if(x>arr[e])
			return -1;
		int mid=(s+e)/2;
		if(x==arr[mid])
			return arr[mid];
		if(x<arr[mid]){
			if(s<=mid-1 && x>arr[mid-1])
				return arr[mid];
			return ceiling(arr, s, mid-1, x);
		}
		else{
			if(e>=mid+1 && x<arr[mid+1])
				return arr[mid+1];
			return ceiling(arr, mid+1, e, x);
		}	
	}
}
