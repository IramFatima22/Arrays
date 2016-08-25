
public class CountInversions {
	public static void main(String[] args) {
		//int arr[]={2,5,1,3,5};
		int arr[]={1,20,6,4,5};
		System.out.println(count(arr,0,arr.length-1))	;

	}

	private static int count(int[] arr, int s, int e) {
		int count=0;
		if(s<e){
			int mid=(s+e)/2;
			count+=count(arr,s,mid);
			count+=count(arr,mid+1,e);
			count+=merge(arr,s,mid,e);
		}
		return count;	
	}

	private static int merge(int[] arr, int s, int mid, int e) {
		int count=0;
		int len1=mid-s+1;
		int len2=e-mid;
		int temp1[]=new int[len1];
		int temp2[]=new int[len2];
		int x1=s;
		int i=0;
		while(i<len1)
			temp1[i++]=arr[x1++];
		int x2=mid+1;
		i=0;
		while(i<len2)
			temp2[i++]=arr[x2++];
		int i1=0,i2=0;
		int start=s;
		while(i1<len1 && i2<len2){
			if(temp1[i1]>temp2[i2]){
				arr[start++]=temp2[i2++];
				count+=len1-i1;
			}
			else
				arr[start++]=temp1[i1++];
		}
		while(i1<len1)
			arr[start++]=temp1[i1++];
		while(i2<len2)
			arr[start++]=temp2[i2++];
		return count;
	}

}
