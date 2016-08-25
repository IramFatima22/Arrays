

public class ArrayElementsConsecutiveCheck {

	public static void main(String[] args) {
		int arr[]={7,10,6,9,8};
		System.out.println(check(arr));
	}

	private static boolean check(int[] arr) {
		int min=arr[0];
		int max=arr[0];
		int n=arr.length;
		for(int i=1;i<n;i++){
			if(arr[i]>max)
				max=arr[i];
			if(arr[i]<min)
				min=arr[i];
		}
		if(max-min+1==n){
			for(int i=0;i<n;i++){
				if(arr[Math.abs(arr[i])-min]>0)
					arr[Math.abs(arr[i])-min]*=-1;
				else
					return false;
			}
			return true;
		}
		return false;	
	}

}
