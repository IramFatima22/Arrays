
public class MinLengthUnsortedSubarray {

	public static void main(String[] args) {
		int arr[]={10,12,20,30,25,40,32,31,35,50,60};
		//int arr[]={10,12,20,30,25,40,50,60};
		System.out.println(method1(arr));
	}

	private static int method1(int[] arr) {
		int n=arr.length;
		int s=-1,e=-1;
		for(int i=0;i<n-1;i++){
			if(arr[i]>arr[i+1]){
				s=i;
				break;
			}
		}
		if(s==-1)
			return 0;
		for(int i=n-1;i>0;i--){
			if(arr[i]<arr[i-1]){
				e=i;
				break;
			}
		}
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=s;i<=e;i++){
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i];
		}
		for(int i=0;i<s;i++){
			if(arr[i]>min){
				s=i;
				break;
			}
		}
		for(int j=n-1;j>=e;j--){
			if(arr[j]<max){
				e=j; 
				break;
			}
		}
		return e-s+1;
	}

}
