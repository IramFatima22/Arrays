
public class MedianOfTwoArrays {

	public static void main(String[] args) {
		int arr1[]={10,12,14,16,18,20};
		int arr2[]={11,13,15,17,19,21};

		System.out.println(median(arr1,arr2));
	}
	//Divide and Conquer Algorithm
	//for this method both the arrays should be of same size
	private static double median(int[] arr1, int[] arr2) {
		int n=arr1.length;
		return median(arr1,arr2,0,n-1,0,n-1);
		
	}
	private static double median(int[] arr1, int[] arr2,int s1,int e1,int s2,int e2) {
		int size=e1-s1+1;
		if(size==1)
			return (arr1[s1]+arr2[s2])/2.0;
		if(size==2)
			return (Math.max(arr1[s1], arr2[s2])+Math.min(arr1[e1], arr2[e2]))/2.0;
		double med1,med2;
		if(size%2==0){
			med1=(arr1[s1+size/2]+arr1[s1+size/2-1])/2.0;
			med2=(arr2[s2+size/2]+arr2[s2+size/2-1])/2.0;
		}
		else{
			med1=arr1[s1+size/2];
			med2=arr2[s1+size/2];
		}
		if(med1>med2){
			if(size%2==0)
				return median(arr1, arr2, s1, (s1+e1)/2, (s2+e2)/2+1, e2);
			return median(arr1, arr2, s1, (s1+e1)/2, (s2+e2)/2, e2);
		}
		else{
			if(size%2==0)
				return median(arr1, arr2, (s1+e1)/2+1, e1, s2, (s2+e2)/2);
			return median(arr1, arr2, (s1+e1)/2, e1, s2, (s2+e2)/2);
		}
		
		
	}

}
