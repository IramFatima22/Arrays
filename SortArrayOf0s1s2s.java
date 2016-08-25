
public class SortArrayOf0s1s2s {

	public static void main(String[] args) {
		int arr[]={0,1,1,0,1,2,1,2,0,0,0,1};
		sort(arr);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	//Dutch National Flag Algorithm
	private static void sort(int[] arr) {
		int n=arr.length;
		int lo=0,mid=0,hi=n-1;
		while(mid<=hi){
			if(arr[mid]==0)
				swap(arr,mid++,lo++);
			else if(arr[mid]==1)
				mid++;
			else if(arr[mid]==2)
				swap(arr,mid,hi--);
		}	
	}
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;	
	}

}
