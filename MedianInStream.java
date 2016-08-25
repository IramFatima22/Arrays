class MaxHeap{
	int arr[];
	int curr;
	public MaxHeap(int n){
		arr=new int[n];
		curr=0;
	}
	public void insert(int val){
		arr[curr++]=val;
		for(int i=(curr)/2-1;i>=0;i--)
			heapify(arr,i,curr);
	}
	public void heapify(int[] arr, int i, int n) {
		int max=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]>arr[max])
			max=left;
		if(right<n && arr[right]>arr[max])
			max=right;
		if(max!=i){
			swap(arr,max,i);
			heapify(arr,max,n);
		}	
	}
	private void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
class MinHeap1{
	int arr[];
	int curr;
	public MinHeap1(int n){
		arr=new int[n];
		curr=0;
	}
	public void insert(int val){
		arr[curr++]=val;
		for(int i=(curr)/2-1;i>=0;i--)
			heapify(arr,i,curr);
	}
	public void heapify(int[] arr, int i, int n) {
		int min=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]<arr[min])
			min=left;
		if(right<n && arr[right]<arr[min])
			min=right;
		if(min!=i){
			swap(arr,min,i);
			heapify(arr,min,n);
		}	
	}
	private void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
public class MedianInStream {

	public static void main(String[] args) {
		int arr[]={5,15,1,3,2,8,7,9,10,6,11,4};
		int n=arr.length;
		MaxHeap maxH=new MaxHeap(n/2+1);
		MinHeap1 minH=new MinHeap1(n/2+1);
		double med=0;
		for(int i=0;i<arr.length;i++){
			med=median(arr[i],maxH,minH,med);
			System.out.print(med+" ");
		}

	}

	private static double median(int val, MaxHeap maxH, MinHeap1 minH, double med) {
		if(maxH.curr==minH.curr){
			if(val<med){
				maxH.insert(val);
				med=maxH.arr[0];
			}
			else{
				minH.insert(val);
				med=minH.arr[0];
			}
		}
		else if(maxH.curr<minH.curr){
			if(val<med){
				maxH.insert(val);
				med=(maxH.arr[0]+minH.arr[0])/2.0;
			}
			else{
				maxH.insert(minH.arr[0]);
				minH.curr--;
				minH.arr[0]=minH.arr[minH.curr];
				minH.heapify(minH.arr,0,minH.curr);
				minH.insert(val);
				med=(maxH.arr[0]+minH.arr[0])/2.0;
			}
		}
		else{
			if(val<med){
				minH.insert(maxH.arr[0]);
				maxH.curr--;
				maxH.arr[0]=maxH.arr[maxH.curr];
				maxH.heapify(maxH.arr, 0, maxH.curr);
				maxH.insert(val);
				med=(maxH.arr[0]+minH.arr[0])/2.0;
			}
			else{
				minH.insert(val);
				med=(maxH.arr[0]+minH.arr[0])/2.0;
			}
		}
		return med;	
	}

}
