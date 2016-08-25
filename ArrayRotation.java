
public class ArrayRotation {

	public static void main(String[] args) {
		int arr[]={1,2,3,4,5,6,7};
		int n=2;
		rotate(arr,n);
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	//Juggling algorithm
	private static void rotate(int[] arr, int d) {
		int n=arr.length;
		int gcd=getGCD(d,n);
		for(int i=0;i<gcd;i++){
			int temp=arr[i];
			int j=i,k;
			while(true){
				k=j+d;
				if(k>=n)
					k=k-n;
				if(k==i)
					break;
				arr[j]=arr[k];
				j=k;
			}
			arr[j]=temp;
		}
		
	}
	private static int getGCD(int val1, int val2) {
		if(val2==0)
			return val1;
		return getGCD(val2, val1%val2);
	}

}
