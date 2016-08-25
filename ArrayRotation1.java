
public class ArrayRotation1 {

	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7};
		int d=3;
		rotate(arr,d);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	//Block Swap algorithm
	private static void rotate(int[] arr, int d) {
		int n=arr.length;
		int size1=d;
		int size2=n-d;
		while(size1!=size2){
			if(size1<size2){
				int s1=d-size1;
				int s2=d+size2-size1;
				swap(arr,s1,s2,size1);
				size2-=size1;
			}
			else{
				int s1=d-size1;
				int s2=d;
				swap(arr,s1,s2,size2);
				size1-=size2;
			}
		}
		swap(arr,d-size1,d,size1);
	}
	private static void swap(int[] arr, int s1, int s2, int size1) {
		int i=0;
		while(i<size1){
			int temp=arr[s1];
			arr[s1]=arr[s2];
			arr[s2]=temp;
			s1++; s2++; i++;
		}
		
	}

}
