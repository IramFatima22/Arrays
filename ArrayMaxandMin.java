
class Pair{
	int max,min;
}
public class ArrayMaxandMin {

	public static void main(String[] args) {
		int arr[]={1000, 11, 445, 1, 330, 3000};
		Pair res=method1(arr,0,arr.length-1);
		System.out.println(res.max+" "+res.min);
		Pair res1=method2(arr);
		System.out.println(res1.max+" "+res1.min);
	}
	//Compare in pairs
	private static Pair method2(int[] arr) {
		int n=arr.length;
		Pair p=new Pair();
		int start=0;
		if(n%2==0){
			p.max=Math.max(arr[0], arr[1]);
			p.min=Math.min(arr[0], arr[1]);
			start=2;
		}
		else{
			p.max=arr[0];
			p.min=arr[0];
			start=1;
		}
		for(int i=start;i<n;i+=2){
			int max=Math.max(arr[i], arr[i+1]);
			int min=Math.min(arr[i], arr[i+1]);
			p.max=Math.max(max, p.max);
			p.min=Math.min(min, p.min);
		}
		return p;
		
	}
	//Tournament method
	private static Pair method1(int[] arr, int s, int e) {
		if(s<=e){
			Pair res=new Pair();
			if(s==e){
				res.max=arr[s];
				res.min=arr[s];
				return res;
			}
			if(s+1==e){
				res.max=Math.max(arr[s], arr[e]);
				res.min=Math.min(arr[s], arr[e]);
				return res;
			}
			int mid=(s+e)/2;
			Pair lr=method1(arr, s, mid);
			Pair rr=method1(arr, mid+1, e);
			res.max=Math.max(lr!=null?lr.max:Integer.MIN_VALUE, rr!=null?rr.max:Integer.MIN_VALUE);
			res.min=Math.min(lr!=null?lr.min:Integer.MAX_VALUE, rr!=null?rr.min:Integer.MAX_VALUE);
			return res;
		}
		return null;
		
	}

}
