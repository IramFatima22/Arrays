class MinHeap{
	int arr[];
	public MinHeap(int a[],int k){
		this.arr=new int[k];
		for(int i=0;i<k;i++)
			this.arr[i]=a[i];
		for(int i=k/2-1;i>=0;i--)
			heapify(arr,i,k);
	}
	public void heapify(int[] arr, int i, int n) {
		int min=i;
		int left=i*2+1;
		int right=i*2+2;
		if(left<n && arr[left]<arr[min])
			min=left;
		if(right<n && arr[right]<arr[min])
			min=right;
		if(min!=i){
			swap(arr,i,min);
			heapify(arr,min,n);
		}	
	}
	private void swap(int[] arr, int i1, int i2) {
		int temp=arr[i1];
		arr[i1]=arr[i2];
		arr[i2]=temp;	
	}
}
public class KLargestElements {

	public static void main(String[] args) {
		int arr[]={15,23,12,9,30,2,50};
		int k=3;
		method1(arr,k);
		System.out.println();
		method2(arr,k);
	}
	//Using Order Statistics
	private static void method2(int[] arr, int k) {
		int n=arr.length;
		findKthElement(arr,0,n-1,n-k);
		for(int i=n-k;i<n;i++)
			System.out.print(arr[i]+" ");
	}
	private static int findKthElement(int[] arr, int s, int e, int k) {
		if(s==e)
			return arr[s];
		int mid=(s+e)/2;
		int i=partition(arr,s,e,mid);
		if(i==k)
			return arr[i];
		if(i>k)
			return findKthElement(arr, s, i-1, k);
		return findKthElement(arr, i+1, e, k);
		
	}
	private static int partition(int[] arr, int s, int e, int mid) {
		swap(arr,mid,e);
		int start=s;
		for(int i=s;i<e;i++){
			if(arr[i]<arr[e])
				swap(arr,i,start++);
		}
		swap(arr,start,e);
		return start;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	//Using MinHeap
	private static void method1(int[] arr, int k) {
		int n=arr.length;
		MinHeap minH=new MinHeap(arr,k);
		for(int i=k;i<n;i++){
			if(arr[i]>minH.arr[0]){
				minH.arr[0]=arr[i];
				minH.heapify(minH.arr, 0, k);
			}
		}
		for(int i=0;i<k;i++)
			System.out.print(minH.arr[i]+" ");
		
	}

}
