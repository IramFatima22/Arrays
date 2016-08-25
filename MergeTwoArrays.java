
public class MergeTwoArrays {

	public static void main(String[] args) {
		//"-1" here indicates Null values
		int arr1[]={2,-1,7,-1,-1,10,-1};
		int arr2[]={5,8,12,14};
		merge(arr1,arr2);
		for(int i=0;i<arr1.length;i++)
			System.out.print(arr1[i]+" ");
	}

	private static void merge(int[] arr1, int[] arr2) {
		int start=0;
		int n=arr1.length;
		for(int i=0;i<n;i++){
			if(arr1[i]!=-1)
				swap(arr1,start++,i); 
		}
		start--;
		int r1=arr1.length-1;
		int r2=arr2.length-1;
		while(r2>=0 && start>=0){
			if(arr1[start]>arr2[r2]){
				arr1[r1--]=arr1[start--];
			}
			else
				arr1[r1--]=arr2[r2--];
		}
		while(r2>=0){
			arr1[r1--]=arr2[r2--];
		}
		
	}
	private static void swap(int[] arr, int i1, int i2) {
		int temp=arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;
	}
}
