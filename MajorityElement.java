public class MajorityElement {

	public static void main(String[] args) {
		int arr[]={3,3,4,2,4,4,2,4,4};
		System.out.println(method1(arr));
	}
	//Moore's Voting Algorithm
	private static boolean method1(int[] arr) {
		int n=arr.length;
		int val=arr[0];
		int count=1;
		for(int i=1;i<n;i++){
			if(arr[i]==val)
				count++;
			else
				count--;
			if(count==0)
				val=arr[i]; count=1;
		}
		count=0;
		for(int i=0;i<n;i++){
			if(arr[i]==val)
				count++;
		}
		if(count>n/2)
			return true;
		return false;
	}

}
